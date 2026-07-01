package com.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	@NotBlank
	private String name;
	@Email
	@NotBlank
	private String email;
	@NotNull
	@Positive
    private Double salary;
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Employee(Long id, @NotBlank String name, @Email @NotBlank String email, @NotNull @Positive Double salary,
			Department department) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.department = department;
	}
	public Employee(@NotBlank String name, @Email @NotBlank String email, @NotNull @Positive Double salary,
			Department department) {
		
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.department = department;
	}
	public Employee() {
		
	}
	
	
	

}
