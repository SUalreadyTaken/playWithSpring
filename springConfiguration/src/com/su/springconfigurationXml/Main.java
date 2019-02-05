package com.su.springconfigurationXml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static  void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("com/su/springconfigurationXml/applicationContextXML.xml");

        Coach baseballCoach = context.getBean("myBaseballCoach", Coach.class);
        Coach baseballCoach2 = context.getBean("myBaseballCoach", Coach.class);

        System.out.println(baseballCoach.getDailyWorkout());

        System.out.println("<< setter injection >> " + baseballCoach.getDailyFortune());

        System.out.println("<< literval value injection from propery file >> " + baseballCoach.getName());

        System.out.println("myBaseballCoach scope (default) is singelton so all baseballcoaches as the same object");

        System.out.println("<< baseballCoach == bsaeballCoach2 >> " + (baseballCoach == baseballCoach2));

        Coach footballCoach = context.getBean("myFootballCoach", Coach.class);
        Coach footballCoach2 = context.getBean("myFootballCoach", Coach.class);

        System.out.println(footballCoach.getDailyWorkout());

        System.out.println("<< setter injection >> " + footballCoach.getDailyFortune());

        System.out.println("<< literal value injection >> " + footballCoach.getName());

        System.out.println("myFootballCoach scope is prototype so different football coaches point to different object");

        System.out.println("<< footballCoach == footballCoach2 >> " + (footballCoach == footballCoach2));

        System.out.println("\n!!! \n !!destroy-method wont be called in prototype!! \n!!!");
        context.close();


    }
}
