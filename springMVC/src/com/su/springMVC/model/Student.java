package com.su.springMVC.model;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String firstName;
    private String lastName;
    private String gender;
    private List<String> habbits;
    private List<String> habbitOptions;

    public Student() {
        this.habbitOptions = new ArrayList<>();
        habbitOptions.add("nothing");
        habbitOptions.add("smoke");
        habbitOptions.add("drink");
    }

    public List<String> getHabbitOptions() {
        return habbitOptions;
    }

    public void setHabbits(List habbits) {
        this.habbits = new ArrayList<>(habbits);
    }

    public List getHabbits() {
        return this.habbits;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
