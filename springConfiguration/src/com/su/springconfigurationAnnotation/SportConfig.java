package com.su.springconfigurationAnnotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.su.springconfigurationAnnotation")
@PropertySource("classpath:myproperties.properties")
public class SportConfig {

    @Bean
    public FortuneService fortuneService() {
        return new NeutralFortune();
    }

    // injecting fortuneService dependency LINE 14
    @Bean
    public Coach swimCoach() {
        return new SwimCoach(fortuneService());
    }
}
