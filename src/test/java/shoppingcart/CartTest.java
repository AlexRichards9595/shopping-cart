package shoppingcart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class CartTest {

	@Test
	public void shouldInstantiateACartObject() {
		Cart underTest = new Cart();

		assertNotNull(underTest);
	}

	@Test
	public void assertThatAnItemHasBeenAdded() {
		Cart underTest = new Cart();
		underTest.addItem(new Item("", 0, 0));
		int check = underTest.listSize();
		assertEquals(1, check);
	}

	@Test
	public void assertThatTwoOrdersHaveBeenAdded() {
		Cart underTest = new Cart();
		underTest.addItem(new Item("", 0, 0));
		underTest.addItem(new Item("", 0, 0));

		int check = underTest.listSize();

		assertEquals(2, check);
	}

	@Test
	public void assertThatGetTotalItemsIsOne() {
		Cart underTest = new Cart();
		underTest.addItem(new Item("shoes", 1.00, 1));
		int check = underTest.getTotalItems();

		assertEquals(1, check);
	}

	@Test
	public void assertThatGetTotalItemsIsTwo() {
		Cart underTest = new Cart();
		underTest.addItem(new Item("", 0, 2));
		int check = underTest.getTotalItems();

		assertEquals(2, check);
	}

	@Test
	public void assertThatGetTotalItemsIsThreeFromTwoOrders() {
		Cart underTest = new Cart();
		underTest.addItem(new Item("", 0, 2));
		underTest.addItem(new Item("", 0, 1));
		int check = underTest.getTotalItems();

		assertEquals(3, check);
	}

	@Test
	public void assertThatGetTotalPriceIsOne() {
		Cart underTest = new Cart();
		underTest.addItem(new Item("shoes", 1.00, 1));
		double check = underTest.getTotalPrice();

		assertEquals(1, check, .001);
	}

	@Test
	public void assertThatGetTotalPriceIsTwo() {
		Cart underTest = new Cart();
		underTest.addItem(new Item("", 2.00, 1));
		double check = underTest.getTotalPrice();

		assertEquals(2.00, check, .001);
	}

	@Test
	public void assertThatGetTotalPriceIsThreeFromTwoOrders() {
		Cart underTest = new Cart();
		underTest.addItem(new Item("", 1.00, 1));
		underTest.addItem(new Item("", 2.00, 1));
		double check = underTest.getTotalPrice();

		assertEquals(3, check, .001);
	}

	@Test
	public void assertThatGetTotalPriceIsFourFromOneItemOrderWithTwoQuantity() {
		Cart underTest = new Cart();
		underTest.addItem(new Item("", 2.00, 2));
		double check = underTest.getTotalPrice();

		assertEquals(4, check, .001);
	}

	@Test
	public void assertThatGetTotalPriceIsSixFromTwoItemOrdersWithDifferentQuantities() {
		Cart underTest = new Cart();
		underTest.addItem(new Item("", 2.00, 2));
		underTest.addItem(new Item("", 2.00, 1));
		double check = underTest.getTotalPrice();

		assertEquals(6, check, .001);
	}

	@Test
	public void assertThatAnOrderHasBeenRemoved() {
		Cart underTest = new Cart();
		underTest.addItem(new Item("shoes", 0, 2));
		underTest.addItem(new Item("shirt", 0, 1));
		underTest.removeItem("shoes");
		int check = underTest.listSize();
		assertEquals(1, check);

	}

	@Test
	public void assertThatAPartialOrderHasBeenRemoved() {
		Cart underTest = new Cart();
		underTest.addItem(new Item("shirt", 20.00, 2));
		underTest.addItem(new Item("shoes", 30.00, 1));
		underTest.addItem(new Item("hats", 10.00, 4));
		underTest.removePartialItem("hats", 2);
		int check = underTest.getTotalItems();
		assertEquals(5, check);

	}

}
