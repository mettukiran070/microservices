package com.example.department.service;

import com.example.department.dto.Department;
import com.example.department.exceptions.DepartmentNotFoundException;
import com.example.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department save(Department department) {
        com.example.department.models.Department departmentObj = convertDtoToEntity(department);
        com.example.department.models.Department savedDepartment = departmentRepository.save(departmentObj);
        return convertEntityToDto(savedDepartment);
    }

    public List<Department> list(Pageable page) {
        return departmentRepository.findAll(page)
                .stream()
                .map(department -> convertEntityToDto(department))
                .collect(Collectors.toList());
    }

    public Department getById(Long id) {
        return departmentRepository.findById(id)
                .map(department -> convertEntityToDto(department))
                .orElseThrow(() -> new DepartmentNotFoundException("Department Not Found with " + id));
    }

    public Department update(Department department) {
        return save(department);
    }

    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }

    private com.example.department.models.Department convertDtoToEntity(Department department) {
        com.example.department.models.Department.DepartmentBuilder builder = com.example.department.models.Department.builder()
                .name(department.name())
                .email(department.email())
                .phoneNumber(department.phoneNumber())
                .createdAt(new Date());
        if (department.id() != null) {
            builder.id(department.id()).createdAt(department.createdAt());
        }
        return builder.build();
    }

    private Department convertEntityToDto(com.example.department.models.Department department) {
        return new Department(
                department.getId(),
                department.getName(),
                department.getEmail(),
                department.getPhoneNumber(),
                department.getCreatedAt()
        );
    }
}
