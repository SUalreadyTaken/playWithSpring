package com.su.springconfigurationAnnotation.model;

public class NeutralFortune implements FortuneService {
    @Override
    public String getFortune() {
        return "Just a normal day";
    }
}
