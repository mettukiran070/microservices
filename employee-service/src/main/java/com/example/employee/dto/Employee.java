package com.example.employee.dto;

import java.util.Date;
import java.util.Optional;

public record Employee(Long id, String name, Date dateOfBirth, String location, Integer departmentNumber, Date createdAt) {
}
