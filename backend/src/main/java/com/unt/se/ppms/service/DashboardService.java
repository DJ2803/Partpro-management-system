package com.unt.se.ppms.service;

import java.util.List;
import com.unt.se.ppms.entities.Products;
import com.unt.se.ppms.entities.User;

public interface DashboardService {
	
	public List<Products> getAllProducts();

	public List<String> getAllCategories();
	
	public List<Products> getProductsByCategory(String category);
	
	public List<String> getNearestLocations(String userName);

	public User getUserDetails(String email);

}
