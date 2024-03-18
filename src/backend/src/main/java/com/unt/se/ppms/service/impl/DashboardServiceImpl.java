package com.unt.se.ppms.service.impl;

import com.unt.se.ppms.dto.CategoryDataDTO;
import com.unt.se.ppms.dto.LocationDataDTO;
import com.unt.se.ppms.entities.*;
import com.unt.se.ppms.exceptions.ResourceNotFoundException;
import com.unt.se.ppms.repository.*;
import com.unt.se.ppms.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private ProductsRepository productsRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	
	@Autowired
	private LocationRepository locationRepository;
	
	
	@Override
	public User getUserDetails(String email) {
		User user = loginRepository.findByEmailId(email).get();
		if (user == null) {
			System.out.println("user not found");
          throw new ResourceNotFoundException("User not found");
      }
		System.out.println("user details : "+user.toString());
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
	public List<CategoryDataDTO> getAllCategories() {
		List<ProductCategory> categories = new ArrayList<ProductCategory>();
		categories = productCategoryRepository.getAllCategories();
		ArrayList<CategoryDataDTO> categoryList = new ArrayList<CategoryDataDTO>();
		for(ProductCategory pc:categories) {
			CategoryDataDTO category = new CategoryDataDTO();
			category.setCategoryId(pc.getCategoryId());
			category.setCategoryImage(pc.getCategoryImage());
			category.setCategoryName(pc.getCategoryName());
			category.setDescription(pc.getDescription());
			categoryList.add(category);
		}
        return categoryList;
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
	public LocationDataDTO getNearestLocation(String username) {
		Customer customer = customerRepository.getCustomerByUsername(username);
		LocationDataDTO result = new LocationDataDTO();
		if(customer != null) {
			Location loc = locationRepository.findByZipcode(customer.getZipcode());
			if(loc != null) {
				result.setAddress(loc.getAddress());
				result.setContactNumber(loc.getContactNumber());
				result.setOperatingHrs(loc.getOperatingHours());
				result.setLocationId(loc.getLocationId());
				result.setReview(loc.getCustomerReview());
				result.setZipcode(loc.getZipcode());
			}
		}	
		return result;
	}
		

	@Override
	public String addVehicle(int userId, Vehicles vehicles) {
		try{
			 Customer customer = customerRepository.findById(userId)
			            .orElseThrow(() -> new RuntimeException("Customer not found"));
			 vehicles.setCustomer(customer);
			vehicleRepository.save(vehicles);
			return "vehicle added successfully";
		}catch(Exception e) {
			return "vehicle addition failed";
		}		
	}


	@Override
	public Products getProductDetails(long productId) {
		// TODO Auto-generated method stub
		Products product = productsRepository.getProductByProductId(productId);
		return product;
	}

}
