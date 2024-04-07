package com.unt.se.ppms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryDTO {

	private long productId;
	private String productName;
	private int productCount;
	private long locationId;
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public long getLocationId() {
		return locationId;
	}
	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}


}
