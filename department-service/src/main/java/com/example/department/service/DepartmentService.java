package com.example.department.service;

import com.example.department.dto.Department;
import com.example.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department save(Department department) {
        return null;
    }

    public List<Department> list() {
        return null;
    }

    public Department getById(Integer id) {
        return null;
    }

    public Department update(Department department) {
        return null;
    }

    public void delete(Integer id) {

    }

}
