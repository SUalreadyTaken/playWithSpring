package com.su.springrest.execptions;

public class StudentNotFoundExeption extends RuntimeException {

    public StudentNotFoundExeption(String message) {
        super(message);
    }

    public StudentNotFoundExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundExeption(Throwable cause) {
        super(cause);
    }

}
