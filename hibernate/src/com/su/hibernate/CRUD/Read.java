package com.su.hibernate.CRUD;

import com.su.hibernate.CRUD.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Read {

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
            // session.getTransaction().commit();


            // session = sessionFactory.getCurrentSession();
            // session.beginTransaction();

            // intellij might show Student as error .. still works .. or just use reference name
            List<Student> studentList = session.createQuery("from Student").getResultList();
            System.out.println("query >> from Student");
            displayQueryResult(studentList);

            studentList.clear();

            studentList = session.createQuery("from Student s where s.lastName='test2'").getResultList();
            System.out.println("query >> from Student s where s.lastName='test2'");
            displayQueryResult(studentList);

            studentList.clear();

            studentList = session.createQuery("from Student s where s.lastName='asdasd'").getResultList();
            System.out.println("query >> from Student s where s.lastName='asdasd'");
            displayQueryResult(studentList);


            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    private static void displayQueryResult(List<Student> studentsList) {
        for(Student s: studentsList) {
            System.out.println(s.toString());
        }
        if (studentsList.isEmpty()) {
            System.out.println("List empty query didnt return anything");
        }
    }

}
