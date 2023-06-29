package com.example.employee.controller;

import com.example.employee.dto.Employee;
import com.example.employee.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> save(@RequestBody Employee employee) {
        employeeService.save(employee);
        return null;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> list() {
        employeeService.list();
        return null;
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getById(Integer id) {
        employeeService.getById(id);
        return null;
    }

    @PutMapping("/employees")
    public ResponseEntity<Employee> update(Employee employee) {
        employeeService.update(employee);
        return null;
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity delete(Integer id) {
        employeeService.delete(id);
        return null;
    }

}
