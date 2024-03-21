package com.baeldung.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CartIsPurchasedTest {

    @Test
    public void testWhenPurchasedIsTrue() {
        // Arrange
        Cart cart = new Cart();
        cart.setPurchased(true);

        // Act
        boolean result = cart.isPurchased();

        // Assert
        Assertions.assertTrue(result);
    }

    @Test
    public void testWhenPurchasedIsFalse() {
        // Arrange
        Cart cart = new Cart();
        cart.setPurchased(false);

        // Act
        boolean result = cart.isPurchased();

        // Assert
        Assertions.assertFalse(result);
    }

    @Test
    public void testWhenPurchasedIsNotSet() {
        // Arrange
        Cart cart = new Cart();

        // Act
        boolean result = cart.isPurchased();

        // Assert
        Assertions.assertFalse(result);
    }
}
