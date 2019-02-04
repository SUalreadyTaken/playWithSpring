package com.su.springconfigurationAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("myBaseballCoach")
//default scope is singleton.. will declare for example purpose
@Scope("singleton")
public class BaseballCoach implements Coach {

    private FortuneService fortuneService;
    @Value("${foo.name}")
    private String name;

    @Autowired
    public BaseballCoach(@Qualifier("happyFortune") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @PostConstruct
    public void myInitMethod() {
        System.out.println("BaseballCoach.java Init method with annotation '@PostConstruct'");
    }

    @PreDestroy
    public void myDestroyMethod() {
        System.out.println("BaseballCoach.java Destroy method with annotation '@PreDestroy'");
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
