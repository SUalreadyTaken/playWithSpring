package com.su.hibernate.one_to_one;

import com.su.hibernate.one_to_one.entity.Course;
import com.su.hibernate.one_to_one.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Delete {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("one_to_one.cfg.xml")
                .addAnnotatedClass(Teacher.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();
            List<Teacher> allTeachers = new ArrayList<>(sessionFactory.getCurrentSession().createCriteria(Teacher.class).list());

            allTeachers.forEach(session::delete);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
