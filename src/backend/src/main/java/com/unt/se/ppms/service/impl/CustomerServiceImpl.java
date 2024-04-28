package com.unt.se.ppms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unt.se.ppms.entities.Cart;
import com.unt.se.ppms.entities.Cart.OrderStatus;
import com.unt.se.ppms.entities.Customer;
import com.unt.se.ppms.entities.Feedback;
import com.unt.se.ppms.exceptions.CustomerNotFoundException;
import com.unt.se.ppms.repository.CartRepository;
import com.unt.se.ppms.repository.CustomerRepository;
import com.unt.se.ppms.repository.FeedbackRepository;
import com.unt.se.ppms.repository.ProductsRepository;
import com.unt.se.ppms.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductsRepository productsRepository;
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	
	
	public String updateCustomer(int userId,Customer customer) throws CustomerNotFoundException {
		try{
			Customer customer1 = customerRepository.findById(userId)
		            .orElseThrow(() -> new RuntimeException("Customer not found"));
			if(customer1.getCustomerId() == userId)
			{
				customer1.setFullName(customer.getFullName());
				customer1.setEmailId(customer.getEmailId());
				customer1.setMobileNumber(customer.getMobileNumber());
				customer1.setZipcode(customer.getZipcode());
			customerRepository.save(customer1);
			return "Customer Details updated successfully";
			}	
			return "Customer does not match from the data";
		}catch(Exception e) {
			throw new CustomerNotFoundException("Customer Invalid");
		}
		
	}

	@Override
	public String addProductToCart(Cart cart) {
		Optional<Cart> item = cartRepository.getProductInCart(cart.getProductId(), cart.getUserId(), OrderStatus.NOT_ORDERED);
		if(item.isPresent()) {
			updateProductInCart(cart.getUserId(), cart.getProductId(), true);
		}else {
			cart.setOrderStatus(OrderStatus.NOT_ORDERED);
			cart.setProductPrice(productsRepository.findById(cart.getProductId()).get().getProductPrice());
			cartRepository.save(cart);
		}
		return "Item added to cart";
	}

	@Override
	public String removeProductFromCart(long productId, long userId) {
		Optional<Cart> item = cartRepository.getProductInCart(userId, productId, OrderStatus.NOT_ORDERED);
		if(item.isPresent()) {
			cartRepository.deleteById(item.get().getId());
		}
		return "Item removed from cart";
	}

	@Override
	public String updateProductInCart(long productId, long userId, boolean flag) {
		Optional<Cart> item = cartRepository.getProductInCart(userId, productId, OrderStatus.NOT_ORDERED);
		if(item.isPresent()) {
			if(item.get().getProductQuantity()>=1 && flag == true) {
				item.get().setProductQuantity(item.get().getProductQuantity()+1);
				cartRepository.save(item.get());
			}else if(item.get().getProductQuantity()>1 && flag == false) {
				item.get().setProductQuantity(item.get().getProductQuantity()-1);
				cartRepository.save(item.get());
			}else if(item.get().getProductQuantity()==1 && flag == false) {
				removeProductFromCart(productId, userId);
			}
		}
		return "Updated product in cart";
	}

	@Override
	public List<Cart> viewOrderedProducts(long userId) {
		return cartRepository.getAllProductsInCart(userId, OrderStatus.ORDERED);
	}

	@Override
	public List<Cart> viewProductsInCart(long userId) {
		return cartRepository.getAllProductsInCart(userId, OrderStatus.NOT_ORDERED);
	}

	@Override
	public String addOrUpdateFeedback(long productID, float rating) {
		Feedback feedback=feedbackRepository.getFeedbackByProductID(productID);
		if(feedback!=null) {
			int cnt= feedback.getRatingsCount();
			int updatedcnt= cnt+1;
			float r= (feedback.getRating()*cnt + rating) /updatedcnt;
			feedback.setRating(r);
			feedback.setRatingsCount(updatedcnt);
			feedbackRepository.save(feedback);
		}
		else
		{
			Feedback feedback1= new Feedback();
			feedback1.setProductID(productID);
			feedback1.setRating(rating);
			feedback1.setRatingsCount(1);
			feedbackRepository.save(feedback1);
		}
		return "Feedback changed";
	}

	@Override
	public Feedback viewFeedback(long productID) {
		  Feedback feedback = feedbackRepository.getFeedbackByProductID(productID);
		  if(feedback ==null) {
			  return null;
		  }
		  return feedback;
	}



}
