package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.entity.Employee;
import com.spring.service.EmployeeService;

@org.springframework.stereotype.Controller

public class EmployeeController {

	private EmployeeService employeeservice;

	@Autowired
	public EmployeeController(EmployeeService employeeservice) {
		this.employeeservice = employeeservice;

	}

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("employee", new Employee());
		return "Employee";
	}

	@PostMapping("/AddEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		if (employee.getId() == 0) { // if employee id is 0 then creating the
			// employee other updating the employee
			employeeservice.addEmployee(employee);
		} else {
			employeeservice.updateEmployee(employee);
		}
		return "redirect:/displayAll";
	}
    
	
	@GetMapping(value = "/displayAll")
	public String getAllEmployees(Model model) {
		model.addAttribute("listEmployees", this.employeeservice.getAllEmployees());
		return "AllEmployees";
	}
	
	@GetMapping("/display/{id}")
    public String getEmployeeById(@PathVariable("id") int id, Model model){
        model.addAttribute("employee", this.employeeservice.findEmployeeById(id));
        return "Employee";
}
}
