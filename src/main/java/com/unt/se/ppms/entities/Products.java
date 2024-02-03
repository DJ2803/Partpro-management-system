package com.unt.se.ppms.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Products {
	
	@Id
	@Column(name = "product_id")
	private long productId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "product_price")
	private float productPrice;
	
	@Column(name = "barcode")
	private String barCode;
	
	@Column(name = "product_description")
	private String productDescription;
	
	@ManyToMany(mappedBy = "products")
    private Set<Supplier> suppliers = new HashSet<>();
	
	@OneToMany(mappedBy = "products", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inventory> inventories = new ArrayList<>();
	
	@OneToMany(mappedBy = "products", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OnlineSales> onlineSales = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private ProductCategory category;

}
