package com.su.hibernate.CRUD;

import com.su.hibernate.CRUD.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Delete {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("crud.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            System.out.println("Delete student with session.delete");
            Student student = session.get(Student.class, 1);
            session.delete(student);

            session.getTransaction().commit();

            // ######

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Delete student with exequteUpdate with query delete from Student where id=2");
            session.createQuery("delete from Student where id=2").executeUpdate();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.close();
            sessionFactory.close();
        }

    }

}
