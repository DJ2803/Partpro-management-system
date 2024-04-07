package com.unt.se.ppms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.unt.se.ppms.entities.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long>{
	
	
	@Transactional
    @Modifying
    @Query("UPDATE Inventory p SET p.productQuantity = p.productQuantity + :quantityToAdd WHERE p.products.productId = :productId")
    int updateProductQuantityByProductId(Long productId, int quantityToAdd);
	
	Inventory findByProducts_ProductId(Long productId);

}
