package com.unt.se.ppms.service;

import com.unt.se.ppms.dto.EmployeeDTO;
import com.unt.se.ppms.entities.Employee;
import com.unt.se.ppms.entities.Inventory;
import com.unt.se.ppms.exceptions.EmployeeNotFoundException;

public interface EmployeeService {
	
	public String updateEmployee(Employee employee) throws EmployeeNotFoundException;
	
	public String addOrUpdateProduct(Long productId, Integer quantity);
	
	public EmployeeDTO findEmployeeByUserName(String userName);
	
	public EmployeeDTO findAssistantEmployee();
	
}
