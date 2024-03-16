package com.unt.se.ppms.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cart")
public class Cart {
	
	public enum OrderStatus{
		NOT_ORDERED,
		ORDERED
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "user_id")
	private long userId;
	
	@Column(name = "product_id")
	private long productId;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(long productQuantity) {
		this.productQuantity = productQuantity;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Column(name = "product_quantity")
	private long productQuantity;
	
	@Column(name = "product_price")
	private double productPrice;
	
	@Column(name = "order_status")
	private OrderStatus orderStatus;

	public Cart(long userId, long productId, long productQuantity) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.productQuantity = productQuantity;
	}

	public Cart() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
