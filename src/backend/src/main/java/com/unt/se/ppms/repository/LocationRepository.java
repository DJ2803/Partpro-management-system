package com.unt.se.ppms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unt.se.ppms.entities.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
	
	@Query("SELECT DISTINCT l FROM Location l")
	List<Location> getAllLocations();
	
	Location findByZipcode(long zipcode);
	

}
