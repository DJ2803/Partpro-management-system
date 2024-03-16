package com.unt.se.ppms.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

class ProductsTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Products#setBarCode(String)}
     *   <li>{@link Products#setCategory(ProductCategory)}
     *   <li>{@link Products#setInventories(List)}
     *   <li>{@link Products#setOnlineSales(List)}
     *   <li>{@link Products#setProductDescription(String)}
     *   <li>{@link Products#setProductId(long)}
     *   <li>{@link Products#setProductImage(String)}
     *   <li>{@link Products#setProductName(String)}
     *   <li>{@link Products#setProductPrice(float)}
     *   <li>{@link Products#setSuppliers(Set)}
     *   <li>{@link Products#getBarCode()}
     *   <li>{@link Products#getCategory()}
     *   <li>{@link Products#getInventories()}
     *   <li>{@link Products#getOnlineSales()}
     *   <li>{@link Products#getProductDescription()}
     *   <li>{@link Products#getProductId()}
     *   <li>{@link Products#getProductImage()}
     *   <li>{@link Products#getProductName()}
     *   <li>{@link Products#getProductPrice()}
     *   <li>{@link Products#getSuppliers()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange
        Products products = new Products();

        // Act
        products.setBarCode("Bar Code");
        ProductCategory category = new ProductCategory();
        category.setCategoryId(1L);
        category.setCategoryImage("Category Image");
        category.setCategoryName("Category Name");
        category.setDescription("The characteristics of someone or something");
        category.setProducts(new ArrayList<>());
        products.setCategory(category);
        ArrayList<Inventory> inventories = new ArrayList<>();
        products.setInventories(inventories);
        ArrayList<OnlineSales> onlineSales = new ArrayList<>();
        products.setOnlineSales(onlineSales);
        products.setProductDescription("Product Description");
        products.setProductId(1L);
        products.setProductImage("Product Image");
        products.setProductName("Product Name");
        products.setProductPrice(10.0f);
        HashSet<Supplier> suppliers = new HashSet<>();
        products.setSuppliers(suppliers);
        String actualBarCode = products.getBarCode();
        ProductCategory actualCategory = products.getCategory();
        List<Inventory> actualInventories = products.getInventories();
        List<OnlineSales> actualOnlineSales = products.getOnlineSales();
        String actualProductDescription = products.getProductDescription();
        long actualProductId = products.getProductId();
        String actualProductImage = products.getProductImage();
        String actualProductName = products.getProductName();
        float actualProductPrice = products.getProductPrice();

        // Assert that nothing has changed
        assertEquals("Bar Code", actualBarCode);
        assertEquals("Product Description", actualProductDescription);
        assertEquals("Product Image", actualProductImage);
        assertEquals("Product Name", actualProductName);
        assertEquals(10.0f, actualProductPrice);
        assertEquals(1L, actualProductId);
        assertSame(category, actualCategory);
        assertSame(inventories, actualInventories);
        assertSame(onlineSales, actualOnlineSales);
        assertSame(suppliers, products.getSuppliers());
    }
}
