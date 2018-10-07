package com.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.EmployeeDAO;
import com.spring.entity.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDao;
	
	@Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDao) {
        this.employeeDao = employeeDao;
    }

	
	public Employee findEmployeeById(int id) {
		
		return this.employeeDao.findEmployeeById(id);
	}

	
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
		
	}

	
	public Employee updateEmployee(Employee employee) {
		return employeeDao.updateEmployee(employee);
	}

	
	public List<Employee> getAllEmployees() {
		
		return employeeDao.getAllEmployees();
	}
    
	
}
