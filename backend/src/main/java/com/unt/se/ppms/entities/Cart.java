package com.unt.se.ppms.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "user_id")
	private long userId;
	
	@Column(name = "product_id")
	private long productId;
	
	@Column(name = "product_quantity")
	private long productQuantity;
	
}
