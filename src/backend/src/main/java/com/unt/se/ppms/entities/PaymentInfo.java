package com.unt.se.ppms.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
@Entity
@Table(name = "payment_info")
public class PaymentInfo {
	
	public enum PaymentStatus{
		INITIAL ("Initial"),
		SUCCESS ("Success"),
		CANCELLED ("Cancelled");

PaymentStatus(String string) {
	this.str=string;
}

private String str;

public String getStr() {
	return str;
}

public void setStr(String str) {
	this.str = str;
}


	}
	
    
	@Id
    @Column(name = "payment_id")
    private String paymentId;
    
    public PaymentInfo(String paymentId, String payerId, String paymentStatus, Double amount, String currency) {
		super();
		this.paymentId = paymentId;
		this.payerId = payerId;
		this.paymentStatus = paymentStatus;
		this.amount = amount;
		this.currency = currency;
	}

	@Column(name="payer_id")
    private String payerId;
	
	@Column(name="order_id")
	private String orderId;
	
	@Column(name="order_Status")
	private String orderStatus;
    
    public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Column(name = "payment_status")
    private String paymentStatus;
    
    public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getPayerId() {
		return payerId;
	}

	public void setPayerId(String payerId) {
		this.payerId = payerId;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Column(name = "amount")
    private Double amount;
    
    @Column(name = "currency")
    private String currency;
    

	public PaymentInfo(Double amount, String currency) {
		super();
		this.amount = amount;
		this.currency = currency;
	}
	
	

	public PaymentInfo() {
		// TODO Auto-generated constructor stub
	}
    
    
}
	