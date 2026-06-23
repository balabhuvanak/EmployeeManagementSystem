package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EmployeeRepository;
import com.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
	
			employeeRepository.save(employee);
	}
	
	@Override
	public Employee findById(long id) {

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

	/*
	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);
	}

	
	
*/

}
