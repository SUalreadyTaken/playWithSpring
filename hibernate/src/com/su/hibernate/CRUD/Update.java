package com.su.hibernate.CRUD;

import com.su.hibernate.CRUD.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Update {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("crud.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Student student = session.get(Student.class, 1);
            System.out.println("Student with id 1 >> " + student.toString());

            if (student.getFirstName().equals("test")) {
                student.setFirstName("temp");
            } else {
                student.setFirstName("test");
            }

            System.out.println("Student after setFirstName >> " + student);

            System.out.println("Student will be updated in database after calling commit");
            session.getTransaction().commit();

            // #########

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\n\nupdating using executeUpdate method");
            student = session.get(Student.class, 1);
            System.out.println("Student with id 1 >> " + student.toString());

            if (student.getEmail().contains("test")) {
                session.createQuery("update Student set email='lamp@gmail.com' where email='test@test.com'").executeUpdate();
            } else {
                session.createQuery("update Student set email='test@test.com' where email='lamp@gmail.com'").executeUpdate();
            }

            session.getTransaction().commit();

            // #########

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            student = session.get(Student.class, 1);
            System.out.println("Student after executeUpdate >> " + student.toString());

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.close();
            sessionFactory.close();
        }

    }

}
