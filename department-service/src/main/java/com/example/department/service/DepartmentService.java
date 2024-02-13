package com.example.department.service;

import com.example.department.client.EmployeeClient;
import com.example.department.dto.Department;
import com.example.department.dto.DepartmentEmployee;
import com.example.department.dto.Employee;
import com.example.department.dto.EmployeeCriteria;
import com.example.department.exceptions.DepartmentNotFoundException;
import com.example.department.mapper.DepartmentMapper;
import com.example.department.repository.DepartmentRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentService {

  private final DepartmentRepository departmentRepository;
  private final DepartmentMapper departmentMapper;
  @Autowired
  private final EmployeeClient employeeClient;

  public Department save(Department department) {
    com.example.department.models.Department departmentObj = departmentMapper.mapDTOToEntity(
        department);
    com.example.department.models.Department savedDepartment = departmentRepository.save(
        departmentObj);
    return departmentMapper.mapEntityToDTO(savedDepartment);
  }

  public List<Department> list(Pageable page) {
    return departmentRepository.findAll(page)
        .stream()
        .map(departmentMapper::mapEntityToDTO)
        .collect(Collectors.toList());
  }

  public Department getById(Long id) {
    return departmentRepository.findById(id)
        .map(departmentMapper::mapEntityToDTO)
        .orElseThrow(() -> new DepartmentNotFoundException("Department Not Found with " + id));
  }

  public Department update(Department department) {
    return save(department);
  }

  public void delete(Long id) {
    departmentRepository.deleteById(id);
  }

  public DepartmentEmployee getAllEmployeesByDepartmentId(Long id) {
    Department department = this.getById(id);
    ResponseEntity<List<Employee>> employeeResponse = this.employeeClient.getEmployeesByDepartmentId(
        EmployeeCriteria.builder().departmentNumber(id).build());
    return new DepartmentEmployee(department, employeeResponse.getBody());
  }
}
