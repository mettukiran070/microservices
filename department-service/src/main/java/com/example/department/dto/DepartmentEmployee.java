package com.example.department.dto;

import lombok.Data;

import java.util.List;

@Data
public class DepartmentEmployee {
    private Department department;

    private List<Employee> employees;

    public DepartmentEmployee(Department department, List<Employee> employees) {
        this.department = department;
        this.employees = employees;
    }
}
