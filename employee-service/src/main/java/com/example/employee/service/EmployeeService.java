package com.example.employee.service;

import com.example.employee.dto.Employee;
import com.example.employee.dto.EmployeeCriteria;
import com.example.employee.exceptions.EmployeeNotFoundException;
import com.example.employee.mapper.EmployeeMapper;
import com.example.employee.repository.EmployeeRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {

  private final EmployeeRepository employeeRepository;
  private final EmployeeMapper employeeMapper;

  public Employee save(Employee employee) {
    com.example.employee.models.Employee employeeObj = employeeMapper.mapDTOToEntity(employee);
    com.example.employee.models.Employee savedEmployee = employeeRepository.save(employeeObj);
    return employeeMapper.mapEntityToDTO(savedEmployee);
  }

  public List<Employee> list(EmployeeCriteria criteria, Pageable page) {
    if (!(criteria != null && criteria.getDepartmentNumber() != null
        && criteria.getDepartmentNumber() > 1)) {
      return employeeRepository.findAll(page)
          .stream()
          .map(employeeMapper::mapEntityToDTO)
          .collect(Collectors.toList());
    }
    return employeeRepository.findByDepartmentNumber(criteria.getDepartmentNumber(), page).stream()
        .map(employeeMapper::mapEntityToDTO)
        .collect(Collectors.toList());
  }

  public Employee getById(Long id) {
    return employeeRepository.findById(id)
        .map(employeeMapper::mapEntityToDTO)
        .orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found with " + id));
  }

  public Employee update(Employee employee) {
    return save(employee);
  }

  public void delete(Long id) {
    employeeRepository.deleteById(id);
  }
}
