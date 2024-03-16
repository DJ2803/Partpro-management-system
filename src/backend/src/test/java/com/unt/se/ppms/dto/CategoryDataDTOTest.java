package com.unt.se.ppms.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CategoryDataDTOTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CategoryDataDTO#setCategoryId(long)}
     *   <li>{@link CategoryDataDTO#setCategoryImage(String)}
     *   <li>{@link CategoryDataDTO#setCategoryName(String)}
     *   <li>{@link CategoryDataDTO#setDescription(String)}
     *   <li>{@link CategoryDataDTO#getCategoryId()}
     *   <li>{@link CategoryDataDTO#getCategoryImage()}
     *   <li>{@link CategoryDataDTO#getCategoryName()}
     *   <li>{@link CategoryDataDTO#getDescription()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange
        CategoryDataDTO categoryDataDTO = new CategoryDataDTO();

        // Act
        categoryDataDTO.setCategoryId(1L);
        categoryDataDTO.setCategoryImage("Category Image");
        categoryDataDTO.setCategoryName("Category Name");
        categoryDataDTO.setDescription("The characteristics of someone or something");
        long actualCategoryId = categoryDataDTO.getCategoryId();
        String actualCategoryImage = categoryDataDTO.getCategoryImage();
        String actualCategoryName = categoryDataDTO.getCategoryName();

        // Assert that nothing has changed
        assertEquals("Category Image", actualCategoryImage);
        assertEquals("Category Name", actualCategoryName);
        assertEquals("The characteristics of someone or something", categoryDataDTO.getDescription());
        assertEquals(1L, actualCategoryId);
    }
}
