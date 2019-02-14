package com.su.springMVC.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode constraintAnnotation) {
        coursePrefix = constraintAnnotation.value();
    }

    // just check if the courseCode starts with given value
    @Override
    public boolean isValid(String courseCode, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = false;

        if(courseCode != null) {
            result = courseCode.startsWith(coursePrefix);
        } else {
            // just add @NotNull to variable... easier dont have to implement empty/null error message
            result = true;
        }

        return result;
    }
}
