package com.example.employee.service;

import com.example.employee.dto.Employee;
import com.example.employee.exceptions.EmployeeNotFoundException;
import com.example.employee.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee) {
        com.example.employee.models.Employee employeeObj = convertDtoToEntity(employee);
        com.example.employee.models.Employee savedEmployee = employeeRepository.save(employeeObj);
        return convertEntityToDto(savedEmployee);
    }

    public List<Employee> list(Pageable page) {
        return employeeRepository.findAll(page)
                .stream()
                .map(employee -> convertEntityToDto(employee))
                .collect(Collectors.toList());
    }

    public Employee getById(Long id) {
        return employeeRepository.findById(id)
                .map(employee -> convertEntityToDto(employee))
                .orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found with " + id));
    }

    public Employee update(Employee employee) {
        return save(employee);
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    private com.example.employee.models.Employee convertDtoToEntity(Employee employee) {
        com.example.employee.models.Employee.EmployeeBuilder builder = com.example.employee.models.Employee.builder()
                .name(employee.name())
                .dateOfBirth(employee.dateOfBirth())
                .location(employee.location())
                .departmentNumber(employee.departmentNumber())
                .createdAt(Date::new);
        if (employee.id() != null) {
            builder.id(employee.id()).createdAt(employee.createdAt());
        }
        return builder.build();
    }

    private Employee convertEntityToDto(com.example.employee.models.Employee employee) {
        return new Employee(
                employee.getId(),
                employee.getName(), employee.getDateOfBirth(),
                employee.getLocation(),
                employee.getDepartmentNumber(),
                employee.getCreatedAt()
        );
    }
}
