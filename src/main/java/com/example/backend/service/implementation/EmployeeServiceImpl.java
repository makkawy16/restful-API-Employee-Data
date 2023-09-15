package com.example.backend.service.implementation;

import com.example.backend.dto.EmployeeDto;
import com.example.backend.entity.Employee;
import com.example.backend.mapper.EmployeeMapper;
import com.example.backend.repository.EmployeeRepo;
import com.example.backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo employeeRepo;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmp = employeeRepo.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmp);
    }
}
