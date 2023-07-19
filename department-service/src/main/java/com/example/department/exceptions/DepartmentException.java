package com.example.department.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DepartmentException extends RuntimeException {

    public DepartmentException(String msg) {
        super(msg);
        log.error("Department Exception {}", msg);
    }

    public DepartmentException(Throwable throwable) {
        super(throwable);
        log.error("Department Exception {}", throwable);
    }

    public DepartmentException(String msg, Throwable throwable) {
        super(msg, throwable);
        log.error("Department Exception {}, {}", msg, throwable);
    }
}
