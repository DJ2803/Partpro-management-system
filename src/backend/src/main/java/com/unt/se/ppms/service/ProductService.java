package com.unt.se.ppms.service;

import com.unt.se.ppms.dto.InventoryDTO;
import com.unt.se.ppms.dto.ProductsDTO;
import com.unt.se.ppms.exceptions.ProductNotFoundException;

public interface ProductService {

	public String updateProductCount(InventoryDTO product);

	public String updateProductInfo(ProductsDTO product) throws ProductNotFoundException;
	
	public String addProduct(ProductsDTO product) throws ProductNotFoundException;

	public String deleteProduct(long productId);

}
