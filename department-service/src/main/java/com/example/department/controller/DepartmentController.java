package com.example.department.controller;

import com.example.department.dto.Department;
import com.example.department.dto.DepartmentEmployee;
import com.example.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
        log.info("Recieved request for department creation {}", department);
        Department response = departmentService.save(department);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/departments")
    public ResponseEntity<List<Department>> list(Pageable page) {
        log.info("Requested to list all departments {}", page);
        List<Department> response = departmentService.list(page);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> getById(@PathVariable(name = "id", required = true) Long id) {
        log.info("Requested to get department by id {}", id);
        Department response = departmentService.getById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/departments")
    public ResponseEntity<Department> update(@RequestBody Department department) {
        log.info("Requested to update the department {}", department);
        departmentService.getById(department.id());
        Department response = departmentService.update(department);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity deleteById(@PathVariable(name = "id", required = true) Long id) {
        log.info("Requested to delete the department by id {}", id);
        departmentService.getById(id);
        departmentService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/departments/{id}/employees")
    public ResponseEntity<DepartmentEmployee> getEmployessByDepartmentId(@PathVariable(name = "id", required = true) Long id) {
        log.info("Requested to list employees by department id {}", id);
        departmentService.getById(id);
        DepartmentEmployee response = departmentService.getAllEmployeesByDepartmentId(id);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
