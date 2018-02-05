package com.springhibernet.dao;

import java.util.List;

import com.springhibernet.model.Employee;

public interface EmployeeDAOInterface
{
    public void createEmployee(Employee employee);
    
    public Employee getEmployeeById(long id);
    public List<Employee> getAllEmployee();
    
    public void updateEmployee(Employee employee);
    
    public void deleteEmployee(long id);
}
