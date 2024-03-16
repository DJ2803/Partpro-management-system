package com.unt.se.ppms.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {Cart.class})
@ExtendWith(SpringExtension.class)
class CartTest {
    @Autowired
    private Cart cart;

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Cart#Cart()}
     *   <li>{@link Cart#setId(long)}
     *   <li>{@link Cart#setOrderStatus(Cart.OrderStatus)}
     *   <li>{@link Cart#setProductId(long)}
     *   <li>{@link Cart#setProductPrice(double)}
     *   <li>{@link Cart#setProductQuantity(long)}
     *   <li>{@link Cart#setUserId(long)}
     *   <li>{@link Cart#getId()}
     *   <li>{@link Cart#getOrderStatus()}
     *   <li>{@link Cart#getProductId()}
     *   <li>{@link Cart#getProductPrice()}
     *   <li>{@link Cart#getProductQuantity()}
     *   <li>{@link Cart#getUserId()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        Cart actualCart = new Cart();
        actualCart.setId(1L);
        actualCart.setOrderStatus(Cart.OrderStatus.NOT_ORDERED);
        actualCart.setProductId(1L);
        actualCart.setProductPrice(10.0d);
        actualCart.setProductQuantity(1L);
        actualCart.setUserId(1L);
        long actualId = actualCart.getId();
        Cart.OrderStatus actualOrderStatus = actualCart.getOrderStatus();
        long actualProductId = actualCart.getProductId();
        double actualProductPrice = actualCart.getProductPrice();
        long actualProductQuantity = actualCart.getProductQuantity();

        // Assert that nothing has changed
        assertEquals(10.0d, actualProductPrice);
        assertEquals(1L, actualId);
        assertEquals(1L, actualProductId);
        assertEquals(1L, actualProductQuantity);
        assertEquals(1L, actualCart.getUserId());
        assertEquals(Cart.OrderStatus.NOT_ORDERED, actualOrderStatus);
    }

    /**
     * Method under test: {@link Cart#Cart(long, long, long)}
     */
    @Test
    void testNewCart() {
        // Arrange and Act
        Cart actualCart = new Cart(1L, 1L, 1L);

        // Assert
        assertEquals(1L, actualCart.getProductId());
        assertEquals(1L, actualCart.getProductQuantity());
        assertEquals(1L, actualCart.getUserId());
    }
}
