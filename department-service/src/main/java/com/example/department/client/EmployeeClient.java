package com.example.department.client;

import com.example.department.dto.Employee;
import com.example.department.dto.EmployeeCriteria;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "employee-service", url = "http://localhost:8081", path = "/api")
public interface EmployeeClient {

    @GetMapping(value = "/employees", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> getEmployeesByDepartmentId(@SpringQueryMap EmployeeCriteria criteria);
}
