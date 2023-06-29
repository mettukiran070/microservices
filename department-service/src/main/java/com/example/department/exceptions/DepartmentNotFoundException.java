package com.example.department.exceptions;

public class DepartmentNotFoundException extends RuntimeException {

    public DepartmentNotFoundException(String msg) {
        super(msg);
    }

    public DepartmentNotFoundException(Throwable throwable) {
        super(throwable);
    }

    public DepartmentNotFoundException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}
