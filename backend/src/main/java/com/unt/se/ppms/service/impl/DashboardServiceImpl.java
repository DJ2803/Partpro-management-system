package com.unt.se.ppms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unt.se.ppms.entities.Customer;
import com.unt.se.ppms.entities.Products;
import com.unt.se.ppms.entities.User;
import com.unt.se.ppms.exceptions.ResourceNotFoundException;
import com.unt.se.ppms.repository.CustomerRepository;
import com.unt.se.ppms.repository.ProductCategoryRepository;
import com.unt.se.ppms.repository.ProductsRepository;
import com.unt.se.ppms.repository.UserRepository;
import com.unt.se.ppms.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductsRepository productsRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	
	
	@Override
	public User getUserDetails(String email) {
		User user = userRepository.findByEmailId(email);
		if (user.isEmpty()) {
          throw new ResourceNotFoundException("User not found");
      }
		return user;
	}
	

	@Override
	public List<Products> getAllProducts() {
		List<Products> products = new ArrayList<Products>();
		products = productsRepository.getAllProducts();
		if (products.isEmpty()) {
            throw new ResourceNotFoundException("No products found");
        }
        return products;
	}

	@Override
	public List<String> getAllCategories() {
		List<String> categories = new ArrayList<String>();
		categories = productCategoryRepository.getAllCategories();
		if (categories.isEmpty()) {
            throw new ResourceNotFoundException("No Category found");
        }
        return categories;
	}

	@Override
	public List<Products> getProductsByCategory(String category) {
		long category_id = productCategoryRepository.getIdByCategoryName(category);
		List<Products> products = productsRepository.findByCategory_CategoryId(category_id);
        if (products.isEmpty()) {
            throw new ResourceNotFoundException("No products found for the specified category");
        }
        return products;
        
	}

	@Override
	public List<String> getNearestLocations(String username) {
		Customer customer = customerRepository.getCustomerByUsername(username);
		List<String> locations = new ArrayList<>();
		return locations;
	}

}
