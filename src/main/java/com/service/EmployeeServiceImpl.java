package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EmployeeRepository;
import com.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private final EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
	    this.employeeRepository = employeeRepository;
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
	if(employeeRepository.existsByEmail(employee.getEmail())) {
		throw new RuntimeException("Email already exists");
	}
			employeeRepository.save(employee);
	}
	
	@Override
	public Employee findById(Long id) {

	    return employeeRepository.findById(id)
	            .orElse(null);
	}


	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}


	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	
	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);
	}

	@Override
	public Employee findByEmail(String email) {
		// TODO Auto-generated method stub
		return employeeRepository.findByEmail(email);
	}

	@Override
	public List<Employee> findByDepartment(String department) {
		// TODO Auto-generated method stub
		return employeeRepository.findByDepartment(department);
	}

}
