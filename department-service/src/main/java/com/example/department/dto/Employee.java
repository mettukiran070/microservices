package com.example.department.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Long id;
    private String name;
    private Date dateOfBirth;
    private String location;
    private Integer departmentNumber;
    private Date createdAt;
}
