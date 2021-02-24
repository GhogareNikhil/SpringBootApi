package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.anyString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding.Verifier;

class EmployeeServiceTest {

	@InjectMocks
   EmployeeService employeeservice;
	
	@Mock
	EmployeeRepository empRepository;
	
	@BeforeEach
	void setUp() throws Exception
	{
          MockitoAnnotations.initMocks(this);		
	}
	
	
	@Test
	public void saveEmployeeTest()
	{
		
		Employee employee= new Employee();
    	employee.setEmp_id("102");
    	employee.setName("vbv");
    	employee.setAge(28);
    	employee.setDob("10/02/1993");
    	
    	when(empRepository.save(employee)).thenReturn(employee);
    	assertEquals(employee,employeeservice.addEmployee(employee));
		
	}

	

		@Test
		public void getEmployeebyNameTest() 
		{
			String name= "nikhil";
			Employee employee= new Employee();
	    	employee.setEmp_id("101");
	    	employee.setName("vbv");
	    	employee.setAge(28);
	    	employee.setDob("10/02/1993");
			when(empRepository.findByName(name)).thenReturn(Stream.of(employee).collect(Collectors.toList()));
			assertEquals(1, employeeservice.getEmployee(name).size());
			
		}
		
		@Test
		public void getEmployeeTest()
		{
			Employee employee= new Employee();
	    	employee.setEmp_id("101");
	    	employee.setName("vbv");
	    	employee.setAge(28);
	    	employee.setDob("10/02/1993");
	    	
	    	Employee employee1= new Employee();
	    	employee1.setEmp_id("102");
	    	employee1.setName("akshay");
	    	employee1.setAge(26);
	    	employee1.setDob("22/06/1995");
			
			when(empRepository.findAll()).thenReturn(Stream.of(employee, employee1).collect(Collectors.toList()));
			assertEquals(2,employeeservice.getAllEmployee().size());
		}
		
		
		@Test
		public void deleteEmployeeTest()
		{
			
			String emp_id="101";
			Employee employee= new Employee();
	    	employee.setEmp_id("101");
	    	employee.setName("vbv");
	    	employee.setAge(28);
	    	employee.setDob("10/02/1993");
	    	
	    	
	    	Employee employee1= new Employee();
	    	employee1.setEmp_id("102");
	    	employee1.setName("akshay");
	    	employee1.setAge(26);
	    	employee1.setDob("22/06/1995");
	    	
	    	
	    	
	    	employeeservice.deleteById(emp_id);
		
		 
	    	
		}
		
		
		
	}


