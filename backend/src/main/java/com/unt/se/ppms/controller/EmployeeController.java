package com.unt.se.ppms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.unt.se.ppms.entities.Employee;
import com.unt.se.ppms.exceptions.EmployeeNotFoundException;
import com.unt.se.ppms.service.EmployeeService;

@RestController
@RequestMapping("/ppms/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(Employee employee) throws EmployeeNotFoundException{
		try {
			String str = employeeService.updateEmployee(employee);
			return new ResponseEntity<>(str, HttpStatus.OK);
		}catch(EmployeeNotFoundException e) {
			throw new EmployeeNotFoundException(e.getMessage());
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

}
