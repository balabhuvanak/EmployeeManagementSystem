package com.dto;

public class EmployeeRequestDto {

    private String name;
    private String email;
    private Double salary;
    private Long departmentId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}

	 public EmployeeRequestDto() {
	    }
	 public EmployeeRequestDto(String name, String email, Long departmentId, Double salary) {
		super();
		this.name = name;
		this.email = email;
		this.departmentId = departmentId;
		this.salary = salary;
	 }
	 
	 
    
}