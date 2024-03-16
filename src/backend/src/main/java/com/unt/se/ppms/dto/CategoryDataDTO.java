package com.unt.se.ppms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDataDTO {

	
public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryImage() {
		return categoryImage;
	}
	public void setCategoryImage(String categoryImage) {
		this.categoryImage = categoryImage;
	}
public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
public long categoryId;
public String categoryName;
public String categoryImage;
public String description;

}
