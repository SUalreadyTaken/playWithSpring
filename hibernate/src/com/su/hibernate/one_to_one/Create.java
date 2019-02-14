package com.su.hibernate.one_to_one;

import com.su.hibernate.one_to_one.entity.Course;
import com.su.hibernate.one_to_one.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Create {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("one_to_one.cfg.xml")
                .addAnnotatedClass(Teacher.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            Teacher teacher = new Teacher("Philip", "Morris", "philip@morris.com");
            Course course = new Course("Marathon");
            Teacher teacher2 = new Teacher("Joonas", "Maalt", "joonasp@maalt.com");
            Course course2 = new Course("Loodus");
            Teacher teacher3 = new Teacher("Juku", "Kuult", "juku@kuult.com");
            Course course3 = new Course("Stars");

            teacher.setCourse(course);
            teacher2.setCourse(course2);
            teacher3.setCourse(course3);

            List<Teacher> tmpList = new ArrayList<>();
            tmpList.add(teacher);
            tmpList.add(teacher2);
            tmpList.add(teacher3);

            session.beginTransaction();

            //can use save with CascadeType.ALL
            tmpList.forEach(session::save);


            // will save course as well because of cascade ... atm using cascadeAll
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }


    }
}
