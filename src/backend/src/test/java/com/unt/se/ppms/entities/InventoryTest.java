package com.unt.se.ppms.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class InventoryTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Inventory#setInventoryId(long)}
     *   <li>{@link Inventory#setLocation(Location)}
     *   <li>{@link Inventory#setProductQuantity(long)}
     *   <li>{@link Inventory#setProducts(Products)}
     *   <li>{@link Inventory#setStockStatus(boolean)}
     *   <li>{@link Inventory#getInventoryId()}
     *   <li>{@link Inventory#getLocation()}
     *   <li>{@link Inventory#getProductQuantity()}
     *   <li>{@link Inventory#getProducts()}
     *   <li>{@link Inventory#isStockStatus()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange
        Inventory inventory = new Inventory();

        // Act
        inventory.setInventoryId(1L);
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
        inventory.setLocation(location);
        inventory.setProductQuantity(1L);
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
        inventory.setProducts(products);
        inventory.setStockStatus(true);
        long actualInventoryId = inventory.getInventoryId();
        Location actualLocation = inventory.getLocation();
        long actualProductQuantity = inventory.getProductQuantity();
        Products actualProducts = inventory.getProducts();

        // Assert that nothing has changed
        assertEquals(1L, actualInventoryId);
        assertEquals(1L, actualProductQuantity);
        assertTrue(inventory.isStockStatus());
        assertSame(location, actualLocation);
        assertSame(products, actualProducts);
    }
}
