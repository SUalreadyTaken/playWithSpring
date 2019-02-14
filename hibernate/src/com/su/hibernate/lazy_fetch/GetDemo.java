package com.su.hibernate.lazy_fetch;

import com.su.hibernate.lazy_fetch.entity.Course;
import com.su.hibernate.lazy_fetch.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class GetDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("one_to_many.cfg.xml")
                .addAnnotatedClass(Teacher.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            Teacher tmp = session.get(Teacher.class, 7);
            System.out.println("teacher >> " + tmp.toString());
            // hibernate will make another query to get the courses because they haven't been loaded.. lazy
            System.out.println("courses >> " + tmp.getCourses());

            session.getTransaction().commit();


        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
