package com.example.department.mapper;

import com.example.department.dto.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

  Department mapEntityToDTO(com.example.department.models.Department department);

  com.example.department.models.Department mapDTOToEntity(Department department);

}
