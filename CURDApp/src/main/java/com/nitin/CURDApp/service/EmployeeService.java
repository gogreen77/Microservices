package com.nitin.CURDApp.service;

import java.util.List;

import com.nitin.CURDApp.entity.Employee;

public interface EmployeeService {
	public List<Employee> retrieveEmployees();
	public Employee getEmployee(Long employeeId);
	public Employee saveEmployee(Employee employee);
	public void deleteEmployee(Long employeeId);
	public void updateEmployee(Employee employee);
}
