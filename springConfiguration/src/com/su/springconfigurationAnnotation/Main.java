package com.su.springconfigurationAnnotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static  void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyLoggerConfig.class, SportConfig.class);

        // component with specific name
        Coach baseballCoach = context.getBean("myBaseballCoach", Coach.class);
        Coach baseballCoach2 = context.getBean("myBaseballCoach", Coach.class);

        // component with compiler generated name ... just class name with lower case 1st letter
        // if class names 2nd letter is also capital letter then the name will remain the same
        // example RESTmodel bean name will be RESTmodel not rESTmodel
        Coach footballCoach = context.getBean("footballCoach", Coach.class);
        Coach footballCoach2 = context.getBean("footballCoach", Coach.class);

        System.out.println(baseballCoach.getDailyWorkout());

        System.out.println("<< autowired constructor injection with qualifier >> " + baseballCoach.getDailyFortune());

        System.out.println("bean scope singleton *default* so all created baseballCoaches point to the same object");

        System.out.println("<< baseballCoach == baseballCoach2 >> " + (baseballCoach == baseballCoach2));

        System.out.println("<< properties using annotation @Value('${}') >> " + baseballCoach.getName());

        System.out.println(footballCoach.getDailyWorkout());

        System.out.println("<< autowired qualified setter method for fortune ... can be whatever method not *set* >> " + footballCoach.getDailyFortune());

        System.out.println("bean scope prototype so all created footballCoaches are different objects");

        System.out.println("<< footballCoach == footballCoach2 >> " + (footballCoach == footballCoach2));

        System.out.println("\n!!! \n !!@PreDestroy wont be called in prototype!! \n!!!\n");

        Coach swimCoach = context.getBean("swimCoach", Coach.class);

        System.out.println("<<Bean from SportConfig.class ... swim daily workout >> " + swimCoach.getDailyWorkout());

        System.out.println("<<Dependency injection in SportConfig.class ... fortune >> " + swimCoach.getDailyFortune());

        context.close();


    }
}
