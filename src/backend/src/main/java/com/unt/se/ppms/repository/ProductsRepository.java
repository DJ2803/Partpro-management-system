package com.unt.se.ppms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.unt.se.ppms.entities.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long>{
	
	@Query("SELECT p FROM Products p")
    List<Products> getAllProducts();

	List<Products> findByCategory_CategoryId(long categoryId);

	Products getProductByProductId(long productId);
	
	boolean deleteProductByProductId(Long productId);

}
