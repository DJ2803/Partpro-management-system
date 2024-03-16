package com.unt.se.ppms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unt.se.ppms.entities.ProductCategory;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer>{
	
	@Query("SELECT pc FROM ProductCategory pc")
	List<ProductCategory> getAllCategories();

	@Query("SELECT pc.categoryId FROM ProductCategory pc WHERE pc.categoryName = :categoryName")
	long getIdByCategoryName(String categoryName);

}
