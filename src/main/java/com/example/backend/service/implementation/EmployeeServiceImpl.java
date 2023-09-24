package com.example.backend.service.implementation;

import com.example.backend.dto.EmployeeDto;
import com.example.backend.entity.Employee;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.mapper.EmployeeMapper;
import com.example.backend.repository.EmployeeRepo;
import com.example.backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public EmployeeDto getEmployeeById(Long employeeID) {
        Employee employee = employeeRepo.findById(employeeID)
                .orElseThrow(() -> new ResourceNotFoundException("ID is not Exist"));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employeeList = employeeRepo.findAll();
        return employeeList.stream().map((it)-> EmployeeMapper.mapToEmployeeDto(it))
                .collect(Collectors.toList());
    }
}
