package com.su.hibernate.many_to_many;

import com.su.hibernate.many_to_many.entity.Course;
import com.su.hibernate.many_to_many.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Create {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("many_to_many.cfg.xml")
                .addAnnotatedClass(Teacher.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            Teacher teacher = new Teacher("Juku", "Loodus", "juku@loodus.com");
            Teacher teacher2 = new Teacher("Maie", "Loodus/Mata", "maie@loodus.com");
            Teacher teacher3 = new Teacher("Taavi", "Loodus/Mata", "taavi@loodus.com");

            Course course = new Course("loodus");
            Course course2 = new Course("mata");

            teacher.addCourse(course);

            teacher2.addCourse(course);
            teacher2.addCourse(course2);

            teacher3.addCourse(course);
            teacher3.addCourse(course2);

            List<Teacher> teacherList = new ArrayList<>();

            teacherList.add(teacher);
            teacherList.add(teacher2);
            teacherList.add(teacher3);

            session.beginTransaction();

            teacherList.forEach(session::persist);

            session.getTransaction().commit();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }



    }



}
