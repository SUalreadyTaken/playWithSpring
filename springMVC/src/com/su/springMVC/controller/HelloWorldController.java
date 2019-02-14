package com.su.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/helloworld")
public class HelloWorldController {


    @RequestMapping("/showForm")
    public String showForm() {
        return "showForm";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "processForm";
    }

    @RequestMapping("/processForm2")
    public String processForm2(HttpServletRequest request, Model model) {
        String value = "All caps " + request.getParameter("randomName").toUpperCase();
        model.addAttribute("attributeName", value);
        return "processForm";
    }

    @RequestMapping("/processForm3")
    public String processForm3(@RequestParam("randomName") String theRandomName, Model model) {
        String value = "Really all CAPS ?? " + theRandomName.toUpperCase();
        model.addAttribute("someAttributeName" , value);
        return "processForm";
    }


}
