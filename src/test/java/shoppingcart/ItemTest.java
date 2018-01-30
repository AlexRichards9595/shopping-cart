package shoppingcart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ItemTest {
	@Test
	public void shouldInstantiateAItemObject() {
		Item underTest = new Item();

		assertNotNull(underTest);
	}

	@Test
	public void shouldInstantiateAnItemWithPriceAndQuantity() {
		Item underTest = new Item("", 0, 0);

		assertNotNull(underTest);
	}

	@Test
	public void shouldReturnItemAsShoes() {
		Item underTest = new Item("shoes", 0, 0);
		String check = underTest.getItem();

		assertEquals("shoes", check);

	}

	@Test
	public void shouldReturnPriceAsOne() {
		Item underTest = new Item("", 1, 1);
		double check = underTest.getPrice();

		assertEquals(1, check, .001);
	}

	@Test
	public void shouldReturnQuantityAsOne() {
		Item underTest = new Item("", 1, 1);
		int check = underTest.getQuantity();

		assertEquals(1, check);
	}
}
