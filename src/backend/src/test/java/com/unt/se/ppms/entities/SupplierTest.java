package com.unt.se.ppms.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {Supplier.class})
@ExtendWith(SpringExtension.class)
class SupplierTest {
    @Autowired
    private Supplier supplier;

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Supplier#Supplier()}
     *   <li>{@link Supplier#toString()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange, Act and Assert
        assertEquals("Supplier [supplierId=0, name=null, supplierType=null, mobileNumber=0, locations=[], products=[]]",
                (new Supplier()).toString());
    }

    /**
     * Method under test:
     * {@link Supplier#Supplier(int, String, String, long, Set, Set)}
     */
    @Test
    void testNewSupplier() {
        // Arrange
        HashSet<Location> locations = new HashSet<>();

        // Act
        Supplier actualSupplier = new Supplier(1, "Name", "Supplier Type", 1L, locations, new HashSet<>());

        // Assert
        assertEquals("Name", actualSupplier.getName());
        assertEquals("Supplier Type", actualSupplier.getSupplierType());
        assertEquals(1, actualSupplier.getSupplierId());
        assertEquals(1L, actualSupplier.getMobileNumber());
        assertTrue(actualSupplier.getLocations().isEmpty());
        assertTrue(actualSupplier.getProducts().isEmpty());
    }

    /**
     * Method under test:
     * {@link Supplier#Supplier(int, String, String, long, Set, Set)}
     */
    @Test
    void testNewSupplier2() {
        // Arrange
        Location location = new Location();
        location.setAddress("42 Main St");
        location.setContactNumber(1L);
        location.setCustomerReview("Customer Review");
        location.setEmployers(new HashSet<>());
        location.setInventories(new ArrayList<>());
        location.setLocationId(1L);
        location.setOperatingHours("Operating Hours");
        location.setSuppliers(new HashSet<>());
        location.setZipcode(1L);

        HashSet<Location> locations = new HashSet<>();
        locations.add(location);

        // Act
        Supplier actualSupplier = new Supplier(1, "Name", "Supplier Type", 1L, locations, new HashSet<>());

        // Assert
        assertEquals("Name", actualSupplier.getName());
        assertEquals("Supplier Type", actualSupplier.getSupplierType());
        assertEquals(1, actualSupplier.getSupplierId());
        assertEquals(1, actualSupplier.getLocations().size());
        assertEquals(1L, actualSupplier.getMobileNumber());
        assertTrue(actualSupplier.getProducts().isEmpty());
    }

    /**
     * Method under test:
     * {@link Supplier#Supplier(int, String, String, long, Set, Set)}
     */
    @Test
    void testNewSupplier3() {
        // Arrange
        Location location = new Location();
        location.setAddress("42 Main St");
        location.setContactNumber(1L);
        location.setCustomerReview("Customer Review");
        location.setEmployers(new HashSet<>());
        location.setInventories(new ArrayList<>());
        location.setLocationId(1L);
        location.setOperatingHours("Operating Hours");
        location.setSuppliers(new HashSet<>());
        location.setZipcode(1L);

        Location location2 = new Location();
        location2.setAddress("17 High St");
        location2.setContactNumber(0L);
        location2.setCustomerReview("42");
        location2.setEmployers(new HashSet<>());
        location2.setInventories(new ArrayList<>());
        location2.setLocationId(2L);
        location2.setOperatingHours("42");
        location2.setSuppliers(new HashSet<>());
        location2.setZipcode(0L);

        HashSet<Location> locations = new HashSet<>();
        locations.add(location2);
        locations.add(location);

        // Act
        Supplier actualSupplier = new Supplier(1, "Name", "Supplier Type", 1L, locations, new HashSet<>());

        // Assert
        assertEquals("Name", actualSupplier.getName());
        assertEquals("Supplier Type", actualSupplier.getSupplierType());
        assertEquals(1, actualSupplier.getSupplierId());
        assertEquals(1L, actualSupplier.getMobileNumber());
        assertEquals(2, actualSupplier.getLocations().size());
        assertTrue(actualSupplier.getProducts().isEmpty());
    }

    /**
     * Method under test:
     * {@link Supplier#Supplier(int, String, String, long, Set, Set)}
     */
    @Test
    void testNewSupplier4() {
        // Arrange
        HashSet<Location> locations = new HashSet<>();

        ProductCategory category = new ProductCategory();
        category.setCategoryId(1L);
        category.setCategoryImage("Category Image");
        category.setCategoryName("Category Name");
        category.setDescription("The characteristics of someone or something");
        category.setProducts(new ArrayList<>());

        Products products = new Products();
        products.setBarCode("Bar Code");
        products.setCategory(category);
        products.setInventories(new ArrayList<>());
        products.setOnlineSales(new ArrayList<>());
        products.setProductDescription("Product Description");
        products.setProductId(1L);
        products.setProductImage("Product Image");
        products.setProductName("Product Name");
        products.setProductPrice(10.0f);
        products.setSuppliers(new HashSet<>());

        HashSet<Products> products2 = new HashSet<>();
        products2.add(products);

        // Act
        Supplier actualSupplier = new Supplier(1, "Name", "Supplier Type", 1L, locations, products2);

        // Assert
        assertEquals("Name", actualSupplier.getName());
        assertEquals("Supplier Type", actualSupplier.getSupplierType());
        assertEquals(1, actualSupplier.getSupplierId());
        assertEquals(1, actualSupplier.getProducts().size());
        assertEquals(1L, actualSupplier.getMobileNumber());
        assertTrue(actualSupplier.getLocations().isEmpty());
    }

    /**
     * Method under test:
     * {@link Supplier#Supplier(int, String, String, long, Set, Set)}
     */
    @Test
    void testNewSupplier5() {
        // Arrange
        HashSet<Location> locations = new HashSet<>();

        ProductCategory category = new ProductCategory();
        category.setCategoryId(1L);
        category.setCategoryImage("Category Image");
        category.setCategoryName("Category Name");
        category.setDescription("The characteristics of someone or something");
        category.setProducts(new ArrayList<>());

        Products products = new Products();
        products.setBarCode("Bar Code");
        products.setCategory(category);
        products.setInventories(new ArrayList<>());
        products.setOnlineSales(new ArrayList<>());
        products.setProductDescription("Product Description");
        products.setProductId(1L);
        products.setProductImage("Product Image");
        products.setProductName("Product Name");
        products.setProductPrice(10.0f);
        products.setSuppliers(new HashSet<>());

        ProductCategory category2 = new ProductCategory();
        category2.setCategoryId(2L);
        category2.setCategoryImage("42");
        category2.setCategoryName("42");
        category2.setDescription("Description");
        category2.setProducts(new ArrayList<>());

        Products products2 = new Products();
        products2.setBarCode("42");
        products2.setCategory(category2);
        products2.setInventories(new ArrayList<>());
        products2.setOnlineSales(new ArrayList<>());
        products2.setProductDescription("42");
        products2.setProductId(2L);
        products2.setProductImage("42");
        products2.setProductName("42");
        products2.setProductPrice(0.5f);
        products2.setSuppliers(new HashSet<>());

        HashSet<Products> products3 = new HashSet<>();
        products3.add(products2);
        products3.add(products);

        // Act
        Supplier actualSupplier = new Supplier(1, "Name", "Supplier Type", 1L, locations, products3);

        // Assert
        assertEquals("Name", actualSupplier.getName());
        assertEquals("Supplier Type", actualSupplier.getSupplierType());
        assertEquals(1, actualSupplier.getSupplierId());
        assertEquals(1L, actualSupplier.getMobileNumber());
        assertEquals(2, actualSupplier.getProducts().size());
        assertTrue(actualSupplier.getLocations().isEmpty());
    }
}
