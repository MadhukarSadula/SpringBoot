package com.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.spring.entity.Employee;

@Transactional
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {



	@PersistenceContext	
	private EntityManager entityManager;

	
	public Employee findEmployeeById(int id) {

		Employee employee= entityManager.find(Employee.class, id);
		return employee;
	}

	
	public void addEmployee(Employee employee) {
		entityManager.persist(employee);

	}

	
	public Employee updateEmployee(Employee employee) {
		Employee emp = findEmployeeById(employee.getId());
		emp.setName(employee.getName());
		emp.setLocation(employee.getLocation());
		emp.setEmail(employee.getEmail());
        return emp;
	}
	
	public List<Employee> getAllEmployees() {
		 
		List<Employee> EmployeeList;
		EmployeeList= entityManager.createQuery("from Employee").getResultList();;
		return EmployeeList;
    }
}
