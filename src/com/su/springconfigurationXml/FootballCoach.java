package com.su.springconfigurationXml;

public class FootballCoach implements Coach {

    private FortuneService fortuneService;
    private String name;

    public FootballCoach(){}

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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
