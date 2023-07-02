package com.example.employee.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(String msg) {
        super(msg);
    }

    public EmployeeNotFoundException(Throwable throwable) {
        super(throwable);
    }

    public EmployeeNotFoundException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}
