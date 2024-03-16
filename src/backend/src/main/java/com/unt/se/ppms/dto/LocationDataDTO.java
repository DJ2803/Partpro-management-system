package com.unt.se.ppms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationDataDTO {

	
public long locationId;
public long contactNumber;
public String review;
public String operatingHrs;
public String address;
private long zipcode;
public long getLocationId() {
	return locationId;
}
public void setLocationId(long locationId) {
	this.locationId = locationId;
}
public long getContactNumber() {
	return contactNumber;
}
public void setContactNumber(long contactNumber) {
	this.contactNumber = contactNumber;
}
public String getReview() {
	return review;
}
public void setReview(String review) {
	this.review = review;
}
public String getOperatingHrs() {
	return operatingHrs;
}
public void setOperatingHrs(String operatingHrs) {
	this.operatingHrs = operatingHrs;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public long getZipcode() {
	return zipcode;
}
public void setZipcode(long zipcode) {
	this.zipcode = zipcode;
}

}
