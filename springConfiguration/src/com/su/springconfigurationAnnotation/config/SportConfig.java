package com.su.springconfigurationAnnotation.config;

import com.su.springconfigurationAnnotation.model.Coach;
import com.su.springconfigurationAnnotation.model.FortuneService;
import com.su.springconfigurationAnnotation.model.NeutralFortune;
import com.su.springconfigurationAnnotation.model.SwimCoach;
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
