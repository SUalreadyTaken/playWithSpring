package com.su.springconfigurationAnnotation;

public class NeutralFortune implements FortuneService {
    @Override
    public String getFortune() {
        return "Just a normal day";
    }
}
