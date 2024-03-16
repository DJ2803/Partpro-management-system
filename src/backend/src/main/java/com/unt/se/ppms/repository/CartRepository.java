package com.unt.se.ppms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unt.se.ppms.entities.Cart;
import com.unt.se.ppms.entities.Cart.OrderStatus;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
	
	@Query("SELECT cart FROM Cart cart WHERE cart.userId = :userId AND orderStatus = :orderStatus")
	List<Cart> getAllProductsInCart(long userId, OrderStatus orderStatus);
	
	@Query("SELECT cart FROM Cart cart WHERE cart.userId = :userId AND cart.productId = :productId AND orderStatus = :orderStatus")
	Optional<Cart> getProductInCart(long userId, long productId, OrderStatus orderStatus);

}
