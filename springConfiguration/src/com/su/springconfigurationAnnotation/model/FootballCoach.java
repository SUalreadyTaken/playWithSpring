package com.su.springconfigurationAnnotation.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class FootballCoach implements Coach {

    private FortuneService fortuneService;
    private String name;

    public FootballCoach(){}

    @Autowired
    public void setFortune(@Qualifier("badFortune") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDailyWorkout() {
        return "Do some free kicks";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
