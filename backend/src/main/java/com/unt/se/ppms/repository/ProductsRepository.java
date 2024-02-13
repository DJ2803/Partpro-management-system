package com.unt.se.ppms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unt.se.ppms.entities.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long>{
	
	@Query("SELECT p FROM Products p")
    List<Products> getAllProducts();

	//@Query("SELECT p FROM Products p WHERE p.category.categoryId = :categoryId")
	List<Products> findByCategory_CategoryId(long categoryId);

}
