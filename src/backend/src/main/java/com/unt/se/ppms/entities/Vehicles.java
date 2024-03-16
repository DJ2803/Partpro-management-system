package com.unt.se.ppms.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	public long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public long getVehicleYear() {
		return vehicleYear;
	}

	public void setVehicleYear(long vehicleYear) {
		this.vehicleYear = vehicleYear;
	}

	public String getLicenseplate() {
		return licenseplate;
	}

	public void setLicenseplate(String licenseplate) {
		this.licenseplate = licenseplate;
	}

	public String getVehicleMaker() {
		return vehicleMaker;
	}

	public void setVehicleMaker(String vehicleMaker) {
		this.vehicleMaker = vehicleMaker;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getVehicleIdNumber() {
		return vehicleIdNumber;
	}

	public void setVehicleIdNumber(String vehicleIdNumber) {
		this.vehicleIdNumber = vehicleIdNumber;
	}

	public float getMileage() {
		return mileage;
	}

	public void setMileage(float mileage) {
		this.mileage = mileage;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getVehicleUsage() {
		return vehicleUsage;
	}

	public void setVehicleUsage(String vehicleUsage) {
		this.vehicleUsage = vehicleUsage;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
