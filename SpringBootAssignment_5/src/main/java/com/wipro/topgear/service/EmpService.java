package com.wipro.topgear.service;
import com.wipro.topgear.entity.*;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;



@Service

public class EmpService {
	Map<Integer, Employee> employees = new HashMap<Integer, Employee>();

	public void addEmployee(Employee employee) throws Exception {

		if (employees.containsKey(employee.getId())) {
			throw new Exception("Employee already exists");
		}

		else {
			employees.put(employee.getId(), employee);
		}

	}

	public Employee getEmployee(int id) throws Exception {

		if (employees.containsKey(id)) {

			return employees.get(id);
		} else {

			throw new Exception("Employee not found");
		}
	}

	public Iterable<Employee> getAllEmployees() {
		return employees.values();
	}

	public void deleteEmployee(int id) throws Exception {

		if (employees.containsKey(id)) {

			employees.remove(id);
		} else {

			throw new Exception("Employee not found");
		}
	}
	
	public void updateEmployee(Employee employee) throws Exception {
        if(employees.containsKey(employee.getId())) {
            employees.replace(employee.getId(), employee);
        }
        else {
            throw new Exception("employee not found");
        }
    }



}
