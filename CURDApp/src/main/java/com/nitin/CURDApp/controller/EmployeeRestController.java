package com.nitin.CURDApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nitin.CURDApp.entity.Employee;
import com.nitin.CURDApp.service.EmployeeService;

@RestController
public class EmployeeRestController {
	 
	 @Autowired
	 private EmployeeService employeeService;
	
	 @GetMapping("/api/employees")
	 public List<Employee> getEmployees() {
	  List<Employee> employees = employeeService.retrieveEmployees();
	  return employees;
	 }
	  
	 @GetMapping("/api/employees/{employeeId}")
	 public Employee getEmployee(@PathVariable(name="employeeId")Long employeeId) {
	  return employeeService.getEmployee(employeeId);
	 }
	  
	 @PostMapping("/api/employees")
	 public Employee saveEmployee(Employee employee){
	return  employeeService.saveEmployee(employee);
	 }
	  
	 @DeleteMapping("/api/employees/{employeeId}")
	 public void deleteEmployee(@PathVariable(name="employeeId")Long employeeId){
		 System.out.println("deleteEmployee Start=="+employeeId);
	  employeeService.deleteEmployee(employeeId);
	  System.out.println("Employee Deleted Successfully");
	 }
	  
	 @PutMapping("/api/employees/{employeeId}")
	 public void updateEmployee(@RequestBody Employee employee,
	   @PathVariable(name="employeeId")Long employeeId){
	  Employee emp = employeeService.getEmployee(employeeId);
	  if(emp != null){
	   employeeService.updateEmployee(employee);
	  }
	   
	 }
}
