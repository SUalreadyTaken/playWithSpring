package com.su.hibernate.CRUD;

import com.su.hibernate.CRUD.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Create {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("crud.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            System.out.println("Creating new student");
            Student tempStudent = new Student("test3", "test3", "test3@test.com");
            session.beginTransaction();
            System.out.println("Saving student >> " + tempStudent.toString());
            session.save(tempStudent);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.close();
            sessionFactory.close();
        }
    }

}
