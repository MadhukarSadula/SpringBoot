package com.wipro.topgear;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import com.wipro.topgear.entity.Employee;
import com.wipro.topgear.service.EmpService;


@RestController
@RequestMapping("/employee")
public class Controller {

	@Autowired
	EmpService employeeservice;
	
	 @PostMapping(value = "/AddEmployee", consumes = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseStatus(value = HttpStatus.OK)
	    public void addEmployee(@RequestBody Employee employee) throws Exception {
	        employeeservice.addEmployee(employee);
	    }
	 
	 @GetMapping(value = "/AllEmployees")
	    public Iterable<Employee> AllEmployees() {
	        return employeeservice.getAllEmployees();
	    }
	 
	 @GetMapping(value = "/getEmployee/{id}")
	 public Employee getEmployee(@PathVariable("id") int id) throws Exception {
		 
		 return employeeservice.getEmployee(id);
	 }
	 
	 @PutMapping(value = "/updateEmployee/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	 @ResponseStatus(value = HttpStatus.OK)
	    public void updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) throws Exception {
	        employeeservice.updateEmployee(employee);
	    }
	 
	 @DeleteMapping(value = "/deleteEmployee/{id}")
	 @ResponseStatus(value = HttpStatus.OK)
	 public void deleteEmployee(@PathVariable("id") int id) throws Exception {
		 employeeservice.deleteEmployee(id);;
	    }


}
