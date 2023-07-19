package com.example.employee.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
@Slf4j
public class EmployeeException extends RuntimeException {

    public EmployeeException(String msg) {
        super(msg);
        log.error("Employee Exception {}", msg);
    }

    public EmployeeException(Throwable throwable) {
        super(throwable);
        log.error("Employee Exception {}", throwable);
    }

    public EmployeeException(String msg, Throwable throwable) {
        super(msg, throwable);
        log.error("Employee Exception {}, {}", msg, throwable);
    }
}
