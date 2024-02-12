package com.unt.se.ppms.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_category")
public class ProductCategory {
	
	@Id
	@Column(name = "category_id")
	private long categoryId;
	
	@Column(name = "category_name")
	private String categoryName;
	
	@Column(name = "category_image")
	private String categoryImage;
	
	@Column
	private String description;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Products> products = new ArrayList<>();

}
