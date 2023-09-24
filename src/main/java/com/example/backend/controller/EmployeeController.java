package com.example.backend.controller;

import com.example.backend.dto.EmployeeDto;
import com.example.backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //handle HTTP requests
@RequestMapping("/api/employees")  //base URL
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    //Build add employee restful API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmp = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
    }


    //get employee
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeByID(@PathVariable("id") Long employeeID) {

        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeID);

        return ResponseEntity.ok(employeeDto);
    }

    //get all employees API

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }
}
