package com.su.springconfigurationAnnotation;

import org.springframework.stereotype.Component;

@Component
public class BadFortune implements FortuneService {
    @Override
    public String getFortune() {
        return "Ur day will suck";
    }
}
