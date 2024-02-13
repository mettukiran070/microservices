package com.example.employee.mapper;

import com.example.employee.dto.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

  Employee mapEntityToDTO(com.example.employee.models.Employee employee);

  com.example.employee.models.Employee mapDTOToEntity(Employee employee);

}
