package com.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.model.Employee;
import com.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
	    this.employeeService = employeeService;
	}
	
	@PostMapping("/save")
	public String saveEmployee(@RequestBody Employee employee) {	
		employeeService.save(employee);
		return "Employee saved successfully";
		
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
	    return employeeService.findById(id);

	}
	
	@GetMapping("/email/{email}")
	public Employee getEmployeeByEmail(@PathVariable String email) {
	    return employeeService.findByEmail(email);

	}
	
	@GetMapping("/department/{department}")
	public List<Employee> getEmployeesByDepartment(@PathVariable String department) {
	    return employeeService.findByDepartment(department);

	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable Long id) {
	    employeeService.delete(id);
	    return "Employee deleted successfully";
	}
	
	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeeService.findAll();
		
	}	
	
	@PutMapping("/{id}")
	public String updateEmployee(
	        @PathVariable Long id,
	        @RequestBody Employee employee) {

	    employee.setId(id);

	    employeeService.update(employee);

	    return "Employee updated successfully";
	}
	

}
