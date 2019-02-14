package com.su.springconfigurationAnnotation.model;

import org.springframework.stereotype.Component;

@Component
public class BadFortune implements FortuneService {
    @Override
    public String getFortune() {
        return "Ur day will suck";
    }
}
