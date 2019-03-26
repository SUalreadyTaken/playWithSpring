package com.su.springBoot.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundExeption exc) {

        EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse();
        response(employeeErrorResponse, HttpStatus.NOT_FOUND.value(),
                exc.getMessage(), System.currentTimeMillis());

        return new ResponseEntity<>(employeeErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(Exception exc) {

        EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse();

        response(employeeErrorResponse, HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(), System.currentTimeMillis());

        return new ResponseEntity<>(employeeErrorResponse, HttpStatus.BAD_REQUEST);
    }

    private EmployeeErrorResponse response(EmployeeErrorResponse employeeErrorResponse,
                                           int httpStatus, String message, long time) {

        employeeErrorResponse.setStatus(httpStatus);
        employeeErrorResponse.setMessage(message);
        employeeErrorResponse.setTimeStamp(time);

        return employeeErrorResponse;
    }

}
