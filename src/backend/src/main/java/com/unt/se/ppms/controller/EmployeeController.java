package com.unt.se.ppms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unt.se.ppms.dto.EmployeeDTO;
import com.unt.se.ppms.dto.InventoryStatusDTO;
import com.unt.se.ppms.entities.Employee;
import com.unt.se.ppms.entities.Inventory;
import com.unt.se.ppms.entities.Products;
import com.unt.se.ppms.exceptions.EmployeeNotFoundException;
import com.unt.se.ppms.repository.InventoryRepository;
import com.unt.se.ppms.repository.LocationRepository;
import com.unt.se.ppms.repository.ProductsRepository;
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
	
	@PostMapping("/addOrUpdateProduct")
    public ResponseEntity<String>  addOrUpdateProduct(@RequestParam Long productId, @RequestParam Integer quantity) {
        
		try {
			String in =employeeService.addOrUpdateProduct(productId, quantity);
			return new ResponseEntity<String> (in,HttpStatus.OK);
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
    }
	
	@GetMapping("getInventoryByStatus")
	public ResponseEntity<List<InventoryStatusDTO>> getInventoryDetails(){
		try {
			List<InventoryStatusDTO> list =employeeService.getInventoryDetailsByStockStatus();
			return new ResponseEntity<List<InventoryStatusDTO>>(list,HttpStatus.OK);
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@GetMapping("/findByUserName")
    public ResponseEntity<EmployeeDTO>  findByUserName(@RequestParam String userName) {
        
		try {
			EmployeeDTO in =employeeService.findEmployeeByUserName(userName);
			return new ResponseEntity<EmployeeDTO> (in,HttpStatus.OK);
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
    }
	
	
	@GetMapping("/getAssistant")
    public ResponseEntity<EmployeeDTO>  getAssistant() {
        
		try {
			EmployeeDTO in =employeeService.findAssistantEmployee();
			return new ResponseEntity<EmployeeDTO> (in,HttpStatus.OK);
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
    }



	   

}
