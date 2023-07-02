package com.example.department.dto;

import java.util.Date;
import java.util.Optional;

public record Department(Long id, String name, String email, String phoneNumber, Date createdAt) {
}
