package com.service;

import java.util.List;

import com.model.Employee;

public interface EmployeeService {

	void save(Employee employee);
	
	Employee findById(Long id);

	void delete(Long id);

	List<Employee> findAll();
	
	void update(Employee employee);

	Employee findByEmail(String email);
	
	List<Employee> findByDepartment(String department);

}
