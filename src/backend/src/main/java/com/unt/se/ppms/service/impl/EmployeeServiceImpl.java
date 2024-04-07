package com.unt.se.ppms.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unt.se.ppms.dto.EmployeeDTO;
import com.unt.se.ppms.dto.InventoryDTO;
import com.unt.se.ppms.entities.Employee;
import com.unt.se.ppms.entities.Inventory;
import com.unt.se.ppms.entities.Products;
import com.unt.se.ppms.exceptions.EmployeeNotFoundException;
import com.unt.se.ppms.repository.EmployeeRepository;
import com.unt.se.ppms.repository.InventoryRepository;
import com.unt.se.ppms.repository.LocationRepository;
import com.unt.se.ppms.repository.ProductsRepository;
import com.unt.se.ppms.service.EmployeeService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	 @Autowired
	  private InventoryRepository inventoryRepository;
	 
	 @Autowired
	    private ProductsRepository productsRepository ;
	 
	 @Autowired
	    private LocationRepository locationRepository ;
	
	@Override
	public String updateEmployee(Employee employee) throws EmployeeNotFoundException {
		try {
			employeeRepository.save(employee);
			return "Employee updated successfully";
		}catch(Exception e) {
			throw new EmployeeNotFoundException("Employee Invalid");
		}
	}
	
	@Override
	public String addOrUpdateProduct(Long productId, Integer quantity) {
        Inventory inventory = inventoryRepository.findByProducts_ProductId(productId);
        if (inventory != null) {
            // Update existing product quantity
            inventory.setProductQuantity(inventory.getProductQuantity() + quantity);
            inventoryRepository.save(inventory);
        } else {
            // Create new inventory entry
            inventory = new Inventory();
		Products product= productsRepository.getProductByProductId(productId);
           inventory.setProducts(product);
           inventory.setStockStatus(true);
           inventory.setLocation(locationRepository.getById((long) 1));
            inventory.setProductQuantity(quantity);
            inventoryRepository.save(inventory);
        }

        return "Innventory Changed";
    }

	@Override
	public EmployeeDTO findEmployeeByUserName(String userName) {
		Employee e= employeeRepository.getEmployeeByUserName(userName);
		EmployeeDTO dto= new EmployeeDTO();
		if(e.getUserName().equalsIgnoreCase(userName)) {
			dto.setDesignation(e.getDesignation());
			dto.setEmailId(e.getEmailId());
			dto.setEmployee_id(e.getEmployeeId());
			dto.setUsername(e.getUserName());
			dto.setEmployee_type(e.getEmployeeType());
			dto.setPassword(e.getPassword()); 
			dto.setMobileNo(e.getMobileNumber());
			dto.setEmployeeName(e.getEmployeeName());
		}
		return dto;
	}

	@Override
	public EmployeeDTO findAssistantEmployee() {
	List<Employee> e=	employeeRepository.findAllAssistants();
	 if (e.isEmpty()) {
	        return null;
	    } 
	 
	 Random random = new Random();
	   Employee emp= e.get(random.nextInt(e.size()));
	    
	EmployeeDTO dto= new EmployeeDTO();
	dto.setEmployeeName(emp.getEmployeeName());
	dto.setDesignation(emp.getDesignation());
	dto.setEmailId(emp.getEmailId());
	dto.setEmployee_id(emp.getEmployeeId());
	dto.setUsername(emp.getUserName());
	dto.setEmployee_type(emp.getEmployeeType());
	dto.setPassword(emp.getPassword()); 
	dto.setMobileNo(emp.getMobileNumber());
	return dto;
	}

}
