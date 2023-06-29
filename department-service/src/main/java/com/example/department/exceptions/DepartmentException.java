package com.example.department.exceptions;

public class DepartmentException extends RuntimeException {

    public DepartmentException(String msg) {
        super(msg);
    }

    public DepartmentException(Throwable throwable) {
        super(throwable);
    }

    public DepartmentException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}
