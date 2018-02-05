package com.springhibernet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springhibernet.dao.EmployeeDAOImpl;
import com.springhibernet.model.Employee;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeDAOImpl employeeDAOImpl;

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public void createStudent(@RequestBody Employee employee) {
		employeeDAOImpl.createEmployee(employee);
	}

	@RequestMapping(value = "/employee/{id}", produces = "application/json", method = RequestMethod.GET)
	public Employee getStudentById(@PathVariable("id") long id) {
		return employeeDAOImpl.getEmployeeById(id);
	}

	@RequestMapping(value = "/employees", produces = "application/json", method = RequestMethod.GET)
	public List<Employee> getAllStudents() {
		return employeeDAOImpl.getAllEmployee();	
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public void updateStudent(@RequestBody Employee employee) {
		employeeDAOImpl.updateEmployee(employee);
	}

	@RequestMapping(value = "/delete/{id}", produces = "application/json")
	public void deleteStudent(@PathVariable("id") long id) {
		employeeDAOImpl.deleteEmployee(id);
	}
}
