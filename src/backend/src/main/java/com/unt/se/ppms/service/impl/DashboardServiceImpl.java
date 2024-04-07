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
//			return null;
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
//		double minDistance = Double.MAX_VALUE;
//        Location nearestLocation = new Location();
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
//		float[] custCoords = getCoordinates(Long.toString(customer.getZipcode()));
//		for(Location loc : allLocations) {
//			float[] coords = getCoordinates(Long.toString(loc.getZipcode()));
//			double distance = calculateDistance(custCoords[0], custCoords[1], coords[0], coords[1]);
//            
//            // Update nearest ZIP code if distance is shorter
//            if (distance < minDistance) {
//                minDistance = distance;
//                nearestLocation = loc;
//            }
//        }
	}
		
//	private static float[] getCoordinates(String zipcode) {
//		final Geocoder geocoder = new Geocoder();
//		GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(zipcode).getGeocoderRequest();
//		GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
//		List<Result> results = geocoderResponse.getResults();
//		System.out.println("results :  "+results);
//		float[] latLong = new float[2];
//		latLong[0] = ((Object) results.get(0)).getGeometry().getLocation().getLat().floatValue();
//		latLong[1] = ((Object) results.get(0)).getGeometry().getLocation().getLng().floatValue();
//		return latLong;
//	}
	
//	private static double calculateDistance(float lat1, float lon1, float lat2, float lon2) {
//        final int R = 6371; // Radius of the earth
//        
//        double latDistance = Math.toRadians(lat2 - lat1);
//        double lonDistance = Math.toRadians(lon2 - lon1);
//        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
//                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
//                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
//        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
//        double distance = R * c;
//
//        return distance * 0.621371; // Convert distance from kilometers to miles
//    }
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
