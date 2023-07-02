package com.example.employee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class EmployeeException extends RuntimeException {

    public EmployeeException(String msg) {
        super(msg);
    }

    public EmployeeException(Throwable throwable) {
        super(throwable);
    }

    public EmployeeException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}
