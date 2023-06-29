package com.example.employee.service;

import com.example.employee.dto.Employee;
import com.example.employee.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee) {
        return null;
    }

    public List<Employee> list() {
        return null;
    }

    public Employee getById(Integer id) {
        return null;
    }

    public Employee update(Employee employee) {
        return null;
    }

    public void delete(Integer id) {

    }
}
