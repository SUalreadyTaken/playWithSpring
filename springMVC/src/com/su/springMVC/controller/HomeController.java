package com.su.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String showPage() {
        /*
        will find web/WEB-INF/view/main-menu.jsp
        check inside spring-mvc-demo-servlet.xml
        prefix and suffix
         */
        return "main-menu";
    }
}
