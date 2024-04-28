package com.unt.se.ppms.dto;

public class OnlineSalesDTO {

	public long saleID;
	
	public float totalPrice;
	
	public String employeeName;
	
	public String customerName;
	
	public String productName;

	public OnlineSalesDTO() {
		
	}
	public OnlineSalesDTO(String string, int i, int j) {
		// TODO Auto-generated constructor stub
	}

	public long getSaleID() {
		return saleID;
	}

	public void setSaleID(long saleID) {
		this.saleID = saleID;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}
