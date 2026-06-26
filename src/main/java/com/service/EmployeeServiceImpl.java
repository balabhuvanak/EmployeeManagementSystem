package com.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.dao.EmployeeRepository;
import com.dto.EmployeeRequestDto;
import com.dto.EmployeeResponseDto;
import com.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponseDto save(EmployeeRequestDto dto) {

        if (employeeRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        Employee employee = convertToEntity(dto);

        Employee savedEmployee = employeeRepository.save(employee);

        return convertToResponseDto(savedEmployee);
    }

    @Override
    public EmployeeResponseDto findById(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        return convertToResponseDto(employee);
    }

    @Override
    public EmployeeResponseDto findByEmail(String email) {

        Employee employee = employeeRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        return convertToResponseDto(employee);
    }

    @Override
    public List<EmployeeResponseDto> findByDepartment(String department) {

        List<Employee> employees = employeeRepository.findByDepartment(department);

        return employees.stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeResponseDto> findAll() {

        return employeeRepository.findAll()
                .stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeResponseDto update(Long id, EmployeeRequestDto dto) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setDepartment(dto.getDepartment());
        employee.setSalary(dto.getSalary());

        Employee updatedEmployee = employeeRepository.save(employee);

        return convertToResponseDto(updatedEmployee);
    }

    @Override
    public void delete(Long id) {

        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee not found");
        }

        employeeRepository.deleteById(id);
    }



    private Employee convertToEntity(EmployeeRequestDto dto) {

        Employee employee = new Employee();

        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setDepartment(dto.getDepartment());
        employee.setSalary(dto.getSalary());

        return employee;
    }

    private EmployeeResponseDto convertToResponseDto(Employee employee) {

        return new EmployeeResponseDto(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getDepartment(),
                employee.getSalary());
    }

}