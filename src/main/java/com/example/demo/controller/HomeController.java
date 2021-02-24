package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeInterface;

@RestController
@RequestMapping("/employee-service")
public class HomeController 
{

	@Autowired
	EmployeeInterface empInterface;
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	

	@PostMapping("/addEmployee")
	public Employee addemployee(@Validated @RequestBody Employee employee,BindingResult result)
	{
		log.info("***************************"+"INSIDE DATA"+"******************");
		
		
		/*
		 * String respMessage; HttpStatus httpstatus; if(result.hasErrors()) {
		 * respMessage="invalid employee"+result.getFieldError(); new
		 * ResponseEntity<String>(respMessage,HttpStatus.BAD_REQUEST); }
		 */
		Employee employee2=empInterface.addEmployee(employee);
		
		//httpstatus=HttpStatus.CREATED;
		
		return employee2;
		
		
		
	}
	
	@GetMapping("/getEmployee/{emp_id}")
	public ResponseEntity<Object> getemployee(@PathVariable ("emp_id")String emp_id)
	{
		log.info("***************************"+"INSIDE Get Method"+"******************");
		
          List<Employee> employee=empInterface.getEmployee(emp_id);		
		if(employee !=null)
		{
			return new  ResponseEntity<Object>(employee,HttpStatus.OK);
					
		}
		return new ResponseEntity<Object> ("Employee:"+emp_id+"does not exits!",HttpStatus.NOT_FOUND);
			
		}
	
	@GetMapping("/getallemployee")
	public ResponseEntity<List<Employee>> getAllflight()
	{
		log.info("***************************"+"INSIDE Get All DATA"+"******************");
		
         List<Employee> employee=empInterface.getAllEmployee();	
			

        return new ResponseEntity<List<Employee>>(employee,HttpStatus.OK);
		}
		
	
	  @PutMapping("/updateemployee") 
	  private ResponseEntity<Object> updateflight(@RequestBody Employee employeeupdate) {
	  
		  Employee flight=empInterface.updateEmployee(employeeupdate);
	  
	  if(flight!=null) { return new ResponseEntity<Object>(flight,HttpStatus.OK);
	  
	  } return new
	  ResponseEntity<Object>("Employee"+employeeupdate.getEmp_id()+"DOES NOT EXITS!" ,HttpStatus.NOT_FOUND);
	  
	  }
	 
	  @DeleteMapping("/deleteemployee/{emp_id}")
      public ResponseEntity<String> deletedata(@PathVariable ("emp_id") String emp_id)
      {
    	 
    	 log.info("******************************"+"DELETEDATA"+"**********************");
    	 

 	  String resMessage=empInterface.deleteById(emp_id);
 		if(resMessage !=null)
 		{
 			
 			
 			return new ResponseEntity<String>(resMessage,HttpStatus.OK);
 			
 	 			
 		}
 		return new ResponseEntity<String>("Employee"+emp_id+"DOES NOT EXITS!!",HttpStatus.NOT_FOUND);
 		 
      }
      


}
