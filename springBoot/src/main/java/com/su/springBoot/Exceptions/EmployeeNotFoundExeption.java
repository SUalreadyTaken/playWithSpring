package com.su.springBoot.Exceptions;

public class EmployeeNotFoundExeption extends RuntimeException {

    public EmployeeNotFoundExeption(String message) {
        super(message);
    }

    public EmployeeNotFoundExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeNotFoundExeption(Throwable cause) {
        super(cause);
    }

}
