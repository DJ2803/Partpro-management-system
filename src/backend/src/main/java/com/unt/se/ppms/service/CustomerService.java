package com.unt.se.ppms.service;

import java.util.List;

import com.unt.se.ppms.entities.Cart;
import com.unt.se.ppms.entities.Customer;
import com.unt.se.ppms.entities.Feedback;
import com.unt.se.ppms.exceptions.CustomerNotFoundException;

public interface CustomerService {
	
	public String updateCustomer(int userId, Customer customer) throws CustomerNotFoundException;
	
	public String addProductToCart(Cart cart);
	
	public String removeProductFromCart(long productId, long userId);
	
	public String updateProductInCart(long productId, long userId, boolean flag);
	
	public List<Cart> viewOrderedProducts(long userId);
	
	public List<Cart> viewProductsInCart(long userId);
	
	public String addOrUpdateFeedback(long productID, float rating);
	
	public Feedback viewFeedback(long productID);
}
