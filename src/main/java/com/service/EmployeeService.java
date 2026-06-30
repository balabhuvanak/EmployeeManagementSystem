package com.service;

import java.util.List;

import com.dto.EmployeeRequestDto;
import com.dto.EmployeeResponseDto;

public interface EmployeeService {

    EmployeeResponseDto save(EmployeeRequestDto dto);

    EmployeeResponseDto findById(Long id);

    EmployeeResponseDto findByEmail(String email);

    List<EmployeeResponseDto> findByDepartment(String department);

    List<EmployeeResponseDto> findAll();

    EmployeeResponseDto update(Long id, EmployeeRequestDto dto);

    void delete(Long id);
    
    List<EmployeeResponseDto> findByName(String name);

    List<EmployeeResponseDto> findBySalaryGreaterThan(Double salary);

    List<EmployeeResponseDto> findByDepartmentAndSalaryGreaterThan(String department, Double salary);


}