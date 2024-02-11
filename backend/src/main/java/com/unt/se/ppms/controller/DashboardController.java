package com.unt.se.ppms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unt.se.ppms.entities.Products;
import com.unt.se.ppms.entities.User;
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
		}catch(ResourceNotFoundException e) {	
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
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
	
	@GetMapping("/getCategories")
	public ResponseEntity<List<String>> getCategories() {
		try {
			List<String> categories = dashboardService.getAllCategories();
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
	public ResponseEntity<List<String>> getNearestLocations(@RequestParam String username) {
		try {
			List<String> locations = dashboardService.getNearestLocations(username);
			return new ResponseEntity<>(locations, HttpStatus.OK);
		}catch(ResourceNotFoundException e) {	
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
}
