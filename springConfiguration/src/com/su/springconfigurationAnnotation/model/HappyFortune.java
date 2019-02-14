package com.su.springconfigurationAnnotation.model;

import org.springframework.stereotype.Component;

@Component
public class HappyFortune implements FortuneService {
    @Override
    public String getFortune() {
        return "U will have a good day";
    }
}
