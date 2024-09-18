package com.unt.se.ppms.dto;

import java.util.List;

public class test {
    	public double totalAmount;

	public List<Long> prodIds;
	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<Long> getProdIds() {
		return prodIds;
	}

	public void setProdIds(List<Long> prodIds) {
		this.prodIds = prodIds;
	}
}
