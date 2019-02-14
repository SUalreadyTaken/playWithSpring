package com.su.springconfigurationXml.model;

public class HappyFortune implements FortuneService {
    @Override
    public String getFortune() {
        return "U will have a good day";
    }
}
