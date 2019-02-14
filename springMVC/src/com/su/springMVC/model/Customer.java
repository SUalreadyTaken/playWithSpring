package com.su.springMVC.model;

import com.su.springMVC.validation.CourseCode;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Customer {

    private String firstName;
    // should not get size error (size 1) because initBinder trims all white spaces name to null
    @NotNull(message = "is required ... null error")
    @Size(min = 1, message = "is required... size error")
    private String lastName;

    @NotNull(message = "is required .. null error")
    @Min(value = 0)
    private Integer age;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "no more than 5 chars/digits")
    private String postalCode;

    @NotNull(message = "is required .. null error")
    @CourseCode(value = "ABC", message = "course come must start with ABC ... my message ")
    private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Customer() {
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
