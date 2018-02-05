package com.springhibernet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springhibernet.model.Employee;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeDAOImpl implements EmployeeDAOInterface {

	@PersistenceContext
	private EntityManager entityManager;

	public void createEmployee(Employee employee) {
		entityManager.persist(employee);
	}

	public Employee getEmployeeById(long id) {
		return entityManager.find(Employee.class, id);
	}

	public List<Employee> getAllEmployee() {
		return entityManager.createQuery("select emp from Employee emp")
				.getResultList();
	}

	public void updateEmployee(Employee employee) {
		entityManager.merge(employee);
	}

	public void deleteEmployee(long id) {
		Employee employee = entityManager.find(Employee.class, id);
		entityManager.remove(employee);
	}	
}
