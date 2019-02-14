package com.su.hibernate.one_to_many;

import com.su.hibernate.one_to_many.entity.Course;
import com.su.hibernate.one_to_many.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Create {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("one_to_many.cfg.xml")
                .addAnnotatedClass(Teacher.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            Teacher teacher = new Teacher("Philip", "Morris", "philip@morris.com");
            Course course = new Course("Marathon");
            Course course2 = new Course("Marathon 2");

            teacher.add(course);
            teacher.add(course2);

            Teacher teacher2 = new Teacher("Joonas", "Maalt", "joonasp@maalt.com");
            Course course3 = new Course("Loodus");
            Course course4 = new Course("Loodus 2");

            teacher2.add(course3);
            teacher2.add(course4);

            Teacher teacher3 = new Teacher("Juku", "Kuult", "juku@kuult.com");
            Course course5 = new Course("Stars");
            Course course6 = new Course("Stars 2");

            teacher3.add(course5);
            teacher3.add(course6);

            List<Teacher> tmpTeachers = new ArrayList<>();
            tmpTeachers.add(teacher);
            tmpTeachers.add(teacher2);
            tmpTeachers.add(teacher3);


            session.beginTransaction();

            tmpTeachers.forEach(session::persist);

            // will save course as well because of cascade ... atm using cascadeAll
            session.getTransaction().commit();



        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
