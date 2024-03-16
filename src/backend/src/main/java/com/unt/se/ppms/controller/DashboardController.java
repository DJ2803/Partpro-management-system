package com.unt.se.ppms.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unt.se.ppms.dto.CategoryDataDTO;
import com.unt.se.ppms.dto.LocationDataDTO;
import com.unt.se.ppms.entities.Products;
import com.unt.se.ppms.entities.User;
import com.unt.se.ppms.entities.Vehicles;
import com.unt.se.ppms.service.DashboardService;



import com.unt.se.ppms.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/ppms/dashboard")
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;
	
	@GetMapping("/getUserDetails")
	public ResponseEntity<User> getUserDetails(@RequestParam String email) {
		try {
			User user = dashboardService.getUserDetails(email);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}catch(Exception e) {	
			System.out.println("No User");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
	}
	
	@GetMapping("/getProducts")
	public ResponseEntity<List<Products>> getAllProducts() {
		try {
			List<Products> products = dashboardService.getAllProducts();
			return new ResponseEntity<>(products, HttpStatus.OK);
		}catch(ResourceNotFoundException e) {	
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@GetMapping("/getProductDetails")
	public ResponseEntity<Products> getProductDetails(@RequestParam long productId) {
		try {
			Products product = dashboardService.getProductDetails(productId);
			return new ResponseEntity<>(product, HttpStatus.OK);
		}catch(Exception e) {	
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@GetMapping("/getCategories")
	public ResponseEntity<List<CategoryDataDTO>> getCategories() {
		try {
			List<CategoryDataDTO> categories = dashboardService.getAllCategories();
			return new ResponseEntity<>(categories, HttpStatus.OK);
		}catch(ResourceNotFoundException e) {	
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	
	@GetMapping("/getProductsByCategory")
	public ResponseEntity<List<Products>> getProductsByCategories(@RequestParam String category) {
		try {
			List<Products> products = dashboardService.getProductsByCategory(category);
			return new ResponseEntity<>(products, HttpStatus.OK);
		}catch(ResourceNotFoundException e) {	
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@GetMapping("/getLocation")
	public ResponseEntity<LocationDataDTO> getNearestLocation(@RequestParam String username) {
		try {
			LocationDataDTO locations = dashboardService.getNearestLocation(username);
			return new ResponseEntity<>(locations, HttpStatus.OK);
		}catch(ResourceNotFoundException e) {	
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@PostMapping("/addVehicleInfo/{userId}")
	public ResponseEntity<String> addVehicleInfo(@PathVariable int userId, @RequestBody Vehicles vehicleInfo) {
		try {
			String status = dashboardService.addVehicle(userId,vehicleInfo);
			return new ResponseEntity<String>(status, HttpStatus.OK);
		}catch(Exception e) {	
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
}
