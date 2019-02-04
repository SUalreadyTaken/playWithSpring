package com.su.springconfigurationXml;

public class HappyFortune implements FortuneService {
    @Override
    public String getFortune() {
        return "U will have a good day";
    }
}
