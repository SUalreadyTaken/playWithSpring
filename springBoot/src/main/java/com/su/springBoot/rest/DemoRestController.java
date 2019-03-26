package com.su.springBoot.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class DemoRestController {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello world " + LocalDateTime.now();
    }

}