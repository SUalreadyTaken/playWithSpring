package com.su.springconfigurationXml.model;


public class BaseballCoach implements Coach {

    private FortuneService fortuneService;
    private String name;

    public BaseballCoach(){}

    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void myInitMethod() {
        System.out.println("<< inside my init method in BaseballCoach.java with argument >> ");
    }

    public void myDestroyMethod() {
        System.out.println("<< inside myDestroyMethod in BaseballCoach.java >>");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice 3s for 10min";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @Override
    public String getName() {
        return this.name;
    }

}
