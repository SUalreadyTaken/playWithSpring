package com.su.springMVC.controller;


import com.su.springMVC.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    // https://stackoverflow.com/questions/5322632/spring-expression-language-spel-with-value-dollar-vs-hash-vs
    @Value("#{genderOptions}")
    private Map<String,String> genderOptions;

    @RequestMapping("/showForm")
    public String showForm(Model model) {

        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("genderOptions", genderOptions);
        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student) {
        System.out.println("First name >> " + student.getFirstName() +
                " Last name >> " + student.getLastName() +
                " gender >> " + student.getGender());

        return "student-confirmation";
    }

}
