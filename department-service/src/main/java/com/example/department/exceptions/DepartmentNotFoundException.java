package com.example.department.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DepartmentNotFoundException extends RuntimeException {

    public DepartmentNotFoundException(String msg) {
        super(msg);
        log.error("Department Not Found, {}", msg);
    }

    public DepartmentNotFoundException(Throwable throwable) {
        super(throwable);
        log.error("Department Not Found, {}", throwable);
    }

    public DepartmentNotFoundException(String msg, Throwable throwable) {
        super(msg, throwable);
        log.error("Department Not Found, {}, {}", msg, throwable);
    }
}
