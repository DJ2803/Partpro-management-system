package com.unt.se.ppms.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "supplier")
public class Supplier {

	@Id
	@Column(name="supplier_id")
	private int supplierId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "supplier_type")
	private String supplierType;
	
	
	@Column(name = "mobile_number")
	private long mobileNumber;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
        name = "supplier_location",
        joinColumns = @JoinColumn(name = "supplier_id"),
        inverseJoinColumns = @JoinColumn(name = "location_id")
    )
    private Set<Location> locations = new HashSet<>();
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
        name = "supplier_product",
        joinColumns = @JoinColumn(name = "supplier_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Products> products = new HashSet<>();
	
	

	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Supplier(int supplierId, String name, String supplierType, long mobileNumber,
			Set<Location> locations, Set<Products> products) {
		super();
		this.supplierId = supplierId;
		this.name = name;
		this.supplierType = supplierType;
		this.mobileNumber = mobileNumber;
		this.locations = locations;
		this.products = products;
	}
	
	
	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", name=" + name + ", supplierType=" + supplierType + ", mobileNumber=" + mobileNumber + ", locations=" + locations + ", products=" + products
				+ "]";
	}
	
	
	
}
