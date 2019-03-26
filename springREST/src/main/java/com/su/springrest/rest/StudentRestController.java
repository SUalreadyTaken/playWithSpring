package com.su.springrest.rest;

import com.su.springrest.entity.Student;
import com.su.springrest.execptions.StudentNotFoundExeption;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> studentList = new ArrayList<>();

    @PostConstruct
    public void testData() {

        studentList.add(new Student("Juku", "Maalt"));
        studentList.add(new Student("Test", "Tset"));
        studentList.add(new Student("Asd", "Dsa"));

    }

    @GetMapping("/students")
    public List<Student> getStudents() {


        return studentList;
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {

        if (id >= studentList.size() || id < 0) {
            throw new StudentNotFoundExeption("Student id " + id + " not found");
        }

        return studentList.get(id);
    }



}
