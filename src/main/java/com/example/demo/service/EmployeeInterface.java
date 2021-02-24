package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeInterface 
{

	Employee addEmployee(Employee employee);
	List<Employee> getEmployee(String name);
	List<Employee> getAllEmployee();
	String deleteById(String emp_id);
	Employee updateEmployee(Employee employee);
}
