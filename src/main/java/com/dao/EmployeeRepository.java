package com.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmail(String email);

    boolean existsByEmail(String email);

    List<Employee> findByName(String name);

    List<Employee> findBySalaryGreaterThan(Double salary);

    List<Employee> findByDepartment_Name(String departmentName);

    List<Employee> findByDepartment_NameAndSalaryGreaterThan(
            String departmentName,
            Double salary);

}