package com.unt.se.ppms.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unt.se.ppms.entities.Cart;
import com.unt.se.ppms.entities.Customer;
import com.unt.se.ppms.entities.Feedback;
import com.unt.se.ppms.exceptions.CustomerNotFoundException;
import com.unt.se.ppms.service.CustomerService;

@RestController
@RequestMapping("/ppms/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	
	
	@PutMapping("/update/{userId}")
	public ResponseEntity<String> updateCustomerDetails(@PathVariable  int userId, @RequestBody Customer customer) throws CustomerNotFoundException{
		try {
			String str = customerService.updateCustomer(userId,customer);
			return new ResponseEntity<>(str, HttpStatus.OK);
		}catch(CustomerNotFoundException e) {
			throw new CustomerNotFoundException(e.getMessage());
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PostMapping("/{userId}/addorUpdateFeedback")
	public ResponseEntity<String> addorUpdateFeedback(@RequestParam Long productId, @RequestParam float rating){
		try {
			String str = customerService.addOrUpdateFeedback(productId, rating);
			return new ResponseEntity<>(str, HttpStatus.OK);
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
	}
	
	@GetMapping("/{userId}/viewFeedback/{productID}")
	public ResponseEntity<Feedback> viewFeedback(@PathVariable long productID){
		try {
			Feedback feedback = customerService.viewFeedback(productID);
			return new ResponseEntity<Feedback>(feedback, HttpStatus.OK);
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@PostMapping("/{userId}/cart/addproduct")
	public ResponseEntity<String> addProductToCart(@PathVariable long userId, @RequestBody Cart cart){
		try {
			String str = customerService.addProductToCart(cart);
			return new ResponseEntity<>(str, HttpStatus.OK);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while adding item "+e.getMessage());
		}
	}
	
	@PutMapping("/{userId}/cart/update/{productId}/{flag}")
	public ResponseEntity<String> updateProductInCart(@PathVariable long userId, @PathVariable long productId, @PathVariable boolean flag){
		try {
			String str = customerService.updateProductInCart(productId, userId, flag);
			return new ResponseEntity<>(str, HttpStatus.OK);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Updation failed "+e.getMessage());
		}
	}
	
	@GetMapping("/{userId}/cart/viewproducts")
	public ResponseEntity<List<Cart>> viewProductsInCart(@PathVariable long userId){
		try {
			List<Cart> items = customerService.viewProductsInCart(userId);
			return new ResponseEntity<>(items, HttpStatus.OK);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@GetMapping("/{userId}/cart/vieworderedproducts")
	public ResponseEntity<List<Cart>> viewOrderedProducts(@PathVariable long userId){
		try {
			List<Cart> items = customerService.viewOrderedProducts(userId);
			return new ResponseEntity<>(items, HttpStatus.OK);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@DeleteMapping("/{userId}/cart/remove/{productId}")
	public ResponseEntity<String> removeProductFromCart(@PathVariable long userId, @PathVariable long productId){
		try {
			String str = customerService.removeProductFromCart(productId, userId);
			return new ResponseEntity<>(str, HttpStatus.OK);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while removing item "+e.getMessage());
		}
	}

}
