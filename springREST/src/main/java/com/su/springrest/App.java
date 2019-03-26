package com.su.springrest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.su.springrest.entity.Student;

import java.io.File;

public class App {
    public static void main( String[] args ) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String projectLocation = System.getProperty("user.dir") + "/springREST";
            Student student = objectMapper.readValue(new File(projectLocation + "/data/sample-lite.json"), Student.class);
            System.out.println("First name >> " + student.getFirstName());
            System.out.println("Last name >> " + student.getLastName());

        } catch (Exception e) {
            System.out.println("Exception >> " + e);
        }



    }
}
