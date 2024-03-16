package com.unt.se.ppms.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

class LocationTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Location#setAddress(String)}
     *   <li>{@link Location#setContactNumber(long)}
     *   <li>{@link Location#setCustomerReview(String)}
     *   <li>{@link Location#setEmployers(Set)}
     *   <li>{@link Location#setInventories(List)}
     *   <li>{@link Location#setLocationId(long)}
     *   <li>{@link Location#setOperatingHours(String)}
     *   <li>{@link Location#setSuppliers(Set)}
     *   <li>{@link Location#setZipcode(long)}
     *   <li>{@link Location#getAddress()}
     *   <li>{@link Location#getContactNumber()}
     *   <li>{@link Location#getCustomerReview()}
     *   <li>{@link Location#getEmployers()}
     *   <li>{@link Location#getInventories()}
     *   <li>{@link Location#getLocationId()}
     *   <li>{@link Location#getOperatingHours()}
     *   <li>{@link Location#getSuppliers()}
     *   <li>{@link Location#getZipcode()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange
        Location location = new Location();

        // Act
        location.setAddress("42 Main St");
        location.setContactNumber(1L);
        location.setCustomerReview("Customer Review");
        HashSet<Employee> employers = new HashSet<>();
        location.setEmployers(employers);
        ArrayList<Inventory> inventories = new ArrayList<>();
        location.setInventories(inventories);
        location.setLocationId(1L);
        location.setOperatingHours("Operating Hours");
        HashSet<Supplier> suppliers = new HashSet<>();
        location.setSuppliers(suppliers);
        location.setZipcode(1L);
        String actualAddress = location.getAddress();
        long actualContactNumber = location.getContactNumber();
        String actualCustomerReview = location.getCustomerReview();
        Set<Employee> actualEmployers = location.getEmployers();
        List<Inventory> actualInventories = location.getInventories();
        long actualLocationId = location.getLocationId();
        String actualOperatingHours = location.getOperatingHours();
        Set<Supplier> actualSuppliers = location.getSuppliers();

        // Assert that nothing has changed
        assertEquals("42 Main St", actualAddress);
        assertEquals("Customer Review", actualCustomerReview);
        assertEquals("Operating Hours", actualOperatingHours);
        assertEquals(1L, actualContactNumber);
        assertEquals(1L, actualLocationId);
        assertEquals(1L, location.getZipcode());
        assertSame(inventories, actualInventories);
        assertSame(employers, actualEmployers);
        assertSame(suppliers, actualSuppliers);
    }
}
