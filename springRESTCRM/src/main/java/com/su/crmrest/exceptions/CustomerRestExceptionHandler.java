package com.su.crmrest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc) {

        CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse();
        response(customerErrorResponse, HttpStatus.NOT_FOUND.value(),
                exc.getMessage(), System.currentTimeMillis());

        return new ResponseEntity<>(customerErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(Exception exc) {

        CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse();

        response(customerErrorResponse, HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(), System.currentTimeMillis());

        return new ResponseEntity<>(customerErrorResponse, HttpStatus.BAD_REQUEST);
    }

    private CustomerErrorResponse response(CustomerErrorResponse customerErrorResponse,
                                           int httpStatus, String message, long time) {

        customerErrorResponse.setStatus(httpStatus);
        customerErrorResponse.setMessage(message);
        customerErrorResponse.setTimeStamp(time);

        return customerErrorResponse;
    }

}
