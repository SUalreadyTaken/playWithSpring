package com.su.hibernate.many_to_many;

import com.su.hibernate.many_to_many.entity.Course;
import com.su.hibernate.many_to_many.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Get {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("many_to_many.cfg.xml")
                .addAnnotatedClass(Teacher.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Teacher teacher = session.get(Teacher.class, 3);

            System.out.println("Teacher >> " + teacher.toString());
            System.out.println("Teacher courses >> " + teacher.getCourses().toString());



            session.getTransaction().commit();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }



    }



}
