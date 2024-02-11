package com.unt.se.ppms.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "location")
public class Location {

	@Id
	@Column(name = "location_id")
	private long locationId;
	
	@Column(name = "contact_number")
	private long contactNumber;
	
	@Column
	private long zipcode;
	
	@Column(name = "customer_review")
	private String customerReview;
	
	@Column(name = "operating_hours")
	private String operatingHours;
	
	@ManyToMany(mappedBy = "locations")
    private Set<Employee> employers = new HashSet<>();
	
	@ManyToMany(mappedBy = "locations")
    private Set<Supplier> suppliers = new HashSet<>();
	
	@OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inventory> inventories = new ArrayList<>();
	
}
