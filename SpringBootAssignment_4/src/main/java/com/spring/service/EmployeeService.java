package com.spring.service;

import java.util.List;

import com.spring.entity.Employee;

public interface EmployeeService {

	public Employee findEmployeeById(int id);
	public void addEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	
}
