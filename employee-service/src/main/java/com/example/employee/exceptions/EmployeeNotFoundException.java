package com.example.employee.exceptions;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@Slf4j
public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(String msg) {
        super(msg);
        log.error("Employee Not Found {}", msg);
    }

    public EmployeeNotFoundException(Throwable throwable) {
        super(throwable);
        log.error("Employee Not Found {}", throwable);
    }

    public EmployeeNotFoundException(String msg, Throwable throwable) {
        super(msg, throwable);
        log.error("Employee Not Found {}, {}", msg, throwable);
    }
}
