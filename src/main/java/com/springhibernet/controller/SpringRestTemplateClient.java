package com.springhibernet.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.springhibernet.model.Employee;

public class SpringRestTemplateClient {

	public static final String REST_BASE_URI = "http://localhost:8080/SpringRestHibernate";

	static RestTemplate restTemplate = new RestTemplate();

	public static void createEmployee() {

		Employee employee = new Employee();
		employee.setId(5);
		employee.setEmployeeName("Poonam");
		employee.setEmployeeSalary(1000);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Employee> entity = new HttpEntity<>(employee, headers);
		restTemplate.postForObject(REST_BASE_URI + "/create", entity,
				Employee.class);
	}

	private static void getEmployee(int id) {
		Employee employee = restTemplate.getForObject(REST_BASE_URI
				+ "/employee/" + id, Employee.class);
		System.out.println("Id   :" + employee.getId() + "  Name  : "
				+ employee.getEmployeeName() + " Salary : "
				+ employee.getEmployeeSalary());
	}

	public static void getAllEmployee() {

		List<Map<String, Object>> employeeList = restTemplate.getForObject(
				REST_BASE_URI + "/employees", List.class);
		if (employeeList != null) {

			for (Map<String, Object> map : employeeList) {
				System.out.println("Id : id=" + map.get("id")
						+ "   employeeName=" + map.get("employeeName")
						+ "   employeeSalary=" + map.get("employeeSalary"));
			}

		} else {
			System.out.println("No exist!!");
		}
	}

	/** PUT **/
	public static void updateEmployee() {
		Employee employee = new Employee();
		employee.setId(5);
		employee.setEmployeeName("Suraj");
		employee.setEmployeeSalary(2000);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Employee> entity = new HttpEntity<>(employee, headers);

		restTemplate.put(REST_BASE_URI + "/update", entity, Employee.class);
	}

	/** DELETE **/
	public static void deleteEmployee(int id) {
		restTemplate.delete(REST_BASE_URI + "/delete/" + id);
	}

	public static void main(String args[]) {
		createEmployee();
		getAllEmployee();
		getEmployee(2);
		updateEmployee();
		deleteEmployee(5);
	}
}
