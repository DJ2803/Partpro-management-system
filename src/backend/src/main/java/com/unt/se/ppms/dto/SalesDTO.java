package com.unt.se.ppms.dto;

public class SalesDTO {

	private long customerID;
	
	private double totalAmount;
	
	private String productIDString;

	public long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getProductIDString() {
		return productIDString;
	}

	public void setProductIDString(String productIDString) {
		this.productIDString = productIDString;
	}
	
	
}
