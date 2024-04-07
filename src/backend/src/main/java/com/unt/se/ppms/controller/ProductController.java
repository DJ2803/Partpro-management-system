package com.unt.se.ppms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unt.se.ppms.dto.ProductsDTO;
import com.unt.se.ppms.dto.InventoryDTO;
import com.unt.se.ppms.service.ProductService;
import com.unt.se.ppms.exceptions.ProductNotFoundException;

@RestController
@RequestMapping("/ppms/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PutMapping("/updateProduct")
	public ResponseEntity<String> updateProduct(@RequestBody ProductsDTO product) {
		try {
			String status = productService.updateProductInfo(product);
			return new ResponseEntity<String>(status, HttpStatus.OK);
		}catch(Exception e) {	
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	@PostMapping("/addProduct")
	public ResponseEntity<String> addProduct(@RequestBody ProductsDTO product) {
		try {
			String status = productService.addProduct(product);
			return new ResponseEntity<String>(status, HttpStatus.OK);
		}catch(Exception e) {	
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@PostMapping("/updateProductsInInventory")
	public ResponseEntity<String> updateProductCount(@RequestBody InventoryDTO inventory) throws ProductNotFoundException {
		try {
			String status = productService.updateProductCount(inventory);
			return new ResponseEntity<String>(status, HttpStatus.OK);
		}catch(Exception e) {	
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@DeleteMapping("/deleteProduct/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable long productId) {
		try {
			String status = productService.deleteProduct(productId);
			return new ResponseEntity<String>(status, HttpStatus.OK);
		}catch(Exception e) {	
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
}
