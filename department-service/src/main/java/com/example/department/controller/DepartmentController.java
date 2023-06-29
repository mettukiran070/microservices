package com.example.department.controller;

import com.example.department.dto.Department;
import com.example.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/departments")
    public ResponseEntity<Department> save(@RequestBody Department department) {
        departmentService.save(department);
        return null;
    }

    @GetMapping("/departments")
    public ResponseEntity<List<Department>> list() {
        departmentService.list();
        return null;
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> getById(Integer id) {
        departmentService.getById(id);
        return null;
    }

    @PutMapping("/departments")
    public ResponseEntity<Department> update(@RequestBody Department department) {
        departmentService.update(department);
        return null;
    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity deleteById(Integer id) {
        departmentService.delete(id);
        return null;
    }
}
