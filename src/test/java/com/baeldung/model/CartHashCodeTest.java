
package com.baeldung.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;

public class CartHashCodeTest {

	@Test
	@Tag("valid")
	public void testEmptyCartNotPurchased() {
		Cart cart = new Cart();
		cart.setPurchased(false);
		int expectedHashCode = 1237;
		assertEquals(expectedHashCode, cart.hashCode());
	}

	@Test
	@Tag("valid")
	public void testEmptyCartPurchased() {
		Cart cart = new Cart();
		cart.setPurchased(true);
		int expectedHashCode = 1231;
		assertEquals(expectedHashCode, cart.hashCode());
	}

	@Test
	@Tag("valid")
	public void testCartWithBooksNotPurchased() {
		Cart cart = new Cart();
		Book book = new Book("Author", "Title", "ISBN");
		cart.add(book);
		cart.setPurchased(false);
		int expectedHashCode = 31 * 1 + cart.getBooks().hashCode() + 1237;
		assertEquals(expectedHashCode, cart.hashCode());
	}

	@Test
	@Tag("valid")
	public void testCartWithBooksPurchased() {
		Cart cart = new Cart();
		Book book = new Book("Author", "Title", "ISBN");
		cart.add(book);
		cart.setPurchased(true);
		int expectedHashCode = 31 * 1 + cart.getBooks().hashCode() + 1231;
		assertEquals(expectedHashCode, cart.hashCode());
	}

	@Test
	@Tag("boundary")
	public void testCartWithNullBookList() {
		Cart cart = new Cart();
		cart.setBooks(null);
		int expectedHashCode = 1237;
		assertEquals(expectedHashCode, cart.hashCode());
	}

}