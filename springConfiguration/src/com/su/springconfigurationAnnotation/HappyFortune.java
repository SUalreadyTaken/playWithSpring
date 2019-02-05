package com.su.springconfigurationAnnotation;

import org.springframework.stereotype.Component;

@Component
public class HappyFortune implements FortuneService {
    @Override
    public String getFortune() {
        return "U will have a good day";
    }
}
