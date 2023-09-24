package com.example.backend.service;

import com.example.backend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto  createEmployee (EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeID);
    List<EmployeeDto> getAllEmployees();
}
