package com.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.dto.EmployeeRequestDto;
import com.dto.EmployeeResponseDto;
import com.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    public EmployeeResponseDto saveEmployee(@Valid @RequestBody EmployeeRequestDto dto) {
        return employeeService.save(dto);
    }

    @GetMapping("/{id}")
    public EmployeeResponseDto getEmployeeById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    @GetMapping("/email/{email}")
    public EmployeeResponseDto getEmployeeByEmail(@PathVariable String email) {
        return employeeService.findByEmail(email);
    }

    @GetMapping("/department/{department}")
    public List<EmployeeResponseDto> getEmployeesByDepartment(@PathVariable String department) {
        return employeeService.findByDepartment(department);
    }

    @GetMapping
    public List<EmployeeResponseDto> getAllEmployees() {
        return employeeService.findAll();
    }

    @PutMapping("/{id}")
    public EmployeeResponseDto updateEmployee(
            @PathVariable Long id,
            @RequestBody EmployeeRequestDto dto) {

        return employeeService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.delete(id);
        return "Employee deleted successfully";
    }

}