package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
@Service
public class EmployeeService implements EmployeeInterface
{
     @Autowired
     EmployeeRepository employeeRepository;
	
	@Override
	public Employee addEmployee(Employee employee) 
	{
		employeeRepository.save(employee);
		return employee;
	}

	@Override
	public List<Employee> getEmployee(String name) 
	{
	          List<Employee> employee=employeeRepository.findByName(name);
			return employee;
	          
	}

	@Override
	public List<Employee> getAllEmployee() 
	{
		List<Employee> emplist=employeeRepository.findAll();
		return emplist;
	}

	@Override
	public String deleteById(String emp_id) 
	{
		Optional<Employee> empOptional=employeeRepository.findById(emp_id);



		 if(empOptional.isPresent())
		 {
			 employeeRepository.deleteById(emp_id);
			 return "Employee"  +emp_id+"removed from employee as records!";
		 }


				return "Employee:  "+emp_id+"does not exits is employee  as record!";
			}
	

   
	 @Override
		public Employee updateEmployee(Employee employee) 
		{

			Optional<Employee> updateEmployee=employeeRepository.findById(employee.getEmp_id());
			if(updateEmployee.isPresent())
			{
				employeeRepository.save(employee);
				return employee;
			}
			return employee;

	
	

}
}
