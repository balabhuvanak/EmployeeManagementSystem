package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

	Employee findByEmail(String email);

	List<Employee> findByDepartment(String department);

}
