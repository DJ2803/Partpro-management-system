package com.unt.se.ppms.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ProductCategoryTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ProductCategory#setCategoryId(long)}
     *   <li>{@link ProductCategory#setCategoryImage(String)}
     *   <li>{@link ProductCategory#setCategoryName(String)}
     *   <li>{@link ProductCategory#setDescription(String)}
     *   <li>{@link ProductCategory#setProducts(List)}
     *   <li>{@link ProductCategory#getCategoryId()}
     *   <li>{@link ProductCategory#getCategoryImage()}
     *   <li>{@link ProductCategory#getCategoryName()}
     *   <li>{@link ProductCategory#getDescription()}
     *   <li>{@link ProductCategory#getProducts()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange
        ProductCategory productCategory = new ProductCategory();

        // Act
        productCategory.setCategoryId(1L);
        productCategory.setCategoryImage("Category Image");
        productCategory.setCategoryName("Category Name");
        productCategory.setDescription("The characteristics of someone or something");
        ArrayList<Products> products = new ArrayList<>();
        productCategory.setProducts(products);
        long actualCategoryId = productCategory.getCategoryId();
        String actualCategoryImage = productCategory.getCategoryImage();
        String actualCategoryName = productCategory.getCategoryName();
        String actualDescription = productCategory.getDescription();

        // Assert that nothing has changed
        assertEquals("Category Image", actualCategoryImage);
        assertEquals("Category Name", actualCategoryName);
        assertEquals("The characteristics of someone or something", actualDescription);
        assertEquals(1L, actualCategoryId);
        assertSame(products, productCategory.getProducts());
    }
}
