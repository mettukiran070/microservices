package com.example.department.exceptions.handler;

import com.example.department.exceptions.DepartmentException;
import com.example.department.exceptions.DepartmentNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DepartmentExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ DepartmentNotFoundException.class })
    public ResponseEntity<Object> handlingDepartmentNotFoundException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ DepartmentException.class })
    public ResponseEntity<Object> handlingDepartmentException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
