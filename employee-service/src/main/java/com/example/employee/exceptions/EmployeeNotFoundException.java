package com.example.employee.exceptions;

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
