package com.service;

import java.util.List;

import com.model.Employee;

public interface EmployeeService {

	void save(Employee employee);
	
	Employee findById(long id);

	void delete(Long id);

	List<Employee> findAll();

	/*	

	void update(Employee employee);
*/
}
