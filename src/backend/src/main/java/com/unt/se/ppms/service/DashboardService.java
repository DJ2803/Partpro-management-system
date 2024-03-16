package com.unt.se.ppms.service;

import java.util.List;

import com.unt.se.ppms.dto.CategoryDataDTO;
import com.unt.se.ppms.dto.LocationDataDTO;
import com.unt.se.ppms.entities.Products;
import com.unt.se.ppms.entities.User;
import com.unt.se.ppms.entities.Vehicles;

public interface DashboardService {
	
	public List<Products> getAllProducts();

	public List<CategoryDataDTO> getAllCategories();
	
	public List<Products> getProductsByCategory(String category);
	
	public LocationDataDTO getNearestLocation(String userName);

	public User getUserDetails(String email);
	
	public String addVehicle(int userId, Vehicles vehicleInfo);

	public Products getProductDetails(long productId);

}
