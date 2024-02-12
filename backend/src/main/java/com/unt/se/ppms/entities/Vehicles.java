package com.unt.se.ppms.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "vehicles")
public class Vehicles {
	
	@Id
	@Column(name = "vehicle_id")
	private long vehicleId;
	
	@Column(name = "vehicle_year")
	private long vehicleYear;
	
	@Column(name = "license_plate")
	private String licenseplate;
	
	@Column(name = "vehicle_maker")
	private String vehicleMaker;
	
	@Column(name = "vehicle_model")
	private String vehicleModel;
	
	@Column(name = "vehicle_id_number")
	private String vehicleIdNumber;
	
	@Column
	private float mileage;
	
	@Column(name = "vehicle_type")
	private String vehicleType;
	
	@Column
	private String color;
	
	@Column(name = "vehicle_usage")
	private String vehicleUsage;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
