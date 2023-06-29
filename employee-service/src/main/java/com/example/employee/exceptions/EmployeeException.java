package com.example.employee.exceptions;

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
