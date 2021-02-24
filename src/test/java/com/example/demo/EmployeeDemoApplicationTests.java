package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeDemoApplicationTests 
{
    @Autowired
	private EmployeeService empService;
    
    @Autowired
    private EmployeeRepository empRepository;
    
    
    @Test
    public void addemployeeTest()
    {
    	Employee employee= new Employee();
    	employee.setEmp_id("101");
    	employee.setName("vbv");
    	employee.setAge(28);
    	employee.setDob("10/02/1993");
    	
    	when(empRepository.save(employee)).thenReturn(employee);
    	assertEquals(employee, empService.addEmployee(employee));
    	
    	
    }
}
