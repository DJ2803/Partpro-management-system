package com.unt.se.ppms.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unt.se.ppms.dto.InventoryDTO;
import com.unt.se.ppms.dto.ProductsDTO;
import com.unt.se.ppms.repository.ProductsRepository;
import com.unt.se.ppms.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@ContextConfiguration(classes = {ProductController.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {
	
	@Autowired
	private ProductController productController;
	
	  @Autowired
	    private MockMvc mockMvc;
	  
	@MockBean
	private ProductService productService;
	
	@MockBean
	private ProductsRepository productsRepository;
	


	
	@Test
	void testUpdateProduct() throws Exception {
		ProductsDTO productDTO = new ProductsDTO(); 
		productDTO.setProductDescription("test prroduct");
		productDTO.setProductName("test");
		when(productService.updateProductInfo(productDTO))
        .thenReturn("Product Details updated successfully");
		  String jsonContent = new ObjectMapper().writeValueAsString(productDTO);
		  String content = (new ObjectMapper()).writeValueAsString(productDTO);
	        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/ppms/product/updateProduct", 1L)
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(content);
	        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(productController)
	                .build()
	                .perform(requestBuilder);
	        actualPerformResult.andExpect(MockMvcResultMatchers.status().isOk());
	        
	    }
	
	
	@Test 
	void  testDeleteProduct() throws Exception {
		long productId = 1L;
	when(productService.deleteProduct(productId)).thenReturn("Product deleted successfully");
    // Act & Assert
    mockMvc.perform(MockMvcRequestBuilders.delete("/ppms/product/deleteProduct/{productId}", productId)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("Product deleted successfully"));
	
	}
	
	 @Test
	  public void testAddProduct() throws Exception {
	        // Arrange
	        ProductsDTO productDTO = new ProductsDTO(); // Initialize with required values
	        String expectedResult = "Product Details addded successfully";
	        when(productService.addProduct(productDTO)).thenReturn(expectedResult);

	        // Act & Assert
	        mockMvc.perform(MockMvcRequestBuilders.post("/ppms/product/addProduct")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(new ObjectMapper().writeValueAsString(productDTO)))
	                .andExpect(MockMvcResultMatchers.status().isOk());
	    }
	 
	 @Test
	    public void testUpdateProductCount() throws Exception {
	        // Arrange
	        InventoryDTO inventoryDTO = new InventoryDTO(); // Setup InventoryDTO with required data
	        String expectedResponse = "Inventory updated successfully";
	        when(productService.updateProductCount(inventoryDTO)).thenReturn(expectedResponse);

	        // Act & Assert
	        mockMvc.perform(MockMvcRequestBuilders.post("/ppms/product/updateProductsInInventory")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(new ObjectMapper().writeValueAsString(inventoryDTO)))
	                .andExpect(MockMvcResultMatchers.status().isOk());
	               
	    }
	

	}
	

