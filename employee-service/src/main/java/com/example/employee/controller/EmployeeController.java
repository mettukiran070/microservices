package com.example.employee.controller;

import com.example.employee.dto.Employee;
import com.example.employee.dto.EmployeeCriteria;
import com.example.employee.service.EmployeeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {

  private final EmployeeService employeeService;

  @PostMapping("/employees")
  public ResponseEntity<Employee> save(@RequestBody Employee employee) {
    log.info("Recieved request for employee creation {}", employee);
    Employee response = employeeService.save(employee);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @GetMapping("/employees")
  public ResponseEntity<List<Employee>> list(EmployeeCriteria criteria, Pageable page) {
    log.info("Requested to list all employees {}, {}", criteria, page);
    List<Employee> response = employeeService.list(criteria, page);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/employees/{id}")
  public ResponseEntity<Employee> getById(@PathVariable Long id) {
    log.info("Requested to get Employee by id {}", id);
    Employee response = employeeService.getById(id);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PutMapping("/employees")
  public ResponseEntity<Employee> update(@RequestBody Employee employee) {
    log.info("Requested to update the employee {}", employee);
    employeeService.getById(employee.id());
    Employee response = employeeService.update(employee);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @DeleteMapping("/employees/{id}")
  public ResponseEntity delete(@PathVariable Long id) {
    log.info("Requested to delete the employee by id {}", id);
    employeeService.getById(id);
    employeeService.delete(id);
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }

}
