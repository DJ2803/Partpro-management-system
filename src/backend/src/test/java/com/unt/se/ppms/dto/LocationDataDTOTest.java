package com.unt.se.ppms.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LocationDataDTOTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link LocationDataDTO#setAddress(String)}
     *   <li>{@link LocationDataDTO#setContactNumber(long)}
     *   <li>{@link LocationDataDTO#setLocationId(long)}
     *   <li>{@link LocationDataDTO#setOperatingHrs(String)}
     *   <li>{@link LocationDataDTO#setReview(String)}
     *   <li>{@link LocationDataDTO#setZipcode(long)}
     *   <li>{@link LocationDataDTO#getAddress()}
     *   <li>{@link LocationDataDTO#getContactNumber()}
     *   <li>{@link LocationDataDTO#getLocationId()}
     *   <li>{@link LocationDataDTO#getOperatingHrs()}
     *   <li>{@link LocationDataDTO#getReview()}
     *   <li>{@link LocationDataDTO#getZipcode()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange
        LocationDataDTO locationDataDTO = new LocationDataDTO();

        // Act
        locationDataDTO.setAddress("42 Main St");
        locationDataDTO.setContactNumber(1L);
        locationDataDTO.setLocationId(1L);
        locationDataDTO.setOperatingHrs("Operating Hrs");
        locationDataDTO.setReview("Review");
        locationDataDTO.setZipcode(1L);
        String actualAddress = locationDataDTO.getAddress();
        long actualContactNumber = locationDataDTO.getContactNumber();
        long actualLocationId = locationDataDTO.getLocationId();
        String actualOperatingHrs = locationDataDTO.getOperatingHrs();
        String actualReview = locationDataDTO.getReview();

        // Assert that nothing has changed
        assertEquals("42 Main St", actualAddress);
        assertEquals("Operating Hrs", actualOperatingHrs);
        assertEquals("Review", actualReview);
        assertEquals(1L, actualContactNumber);
        assertEquals(1L, actualLocationId);
        assertEquals(1L, locationDataDTO.getZipcode());
    }
}
