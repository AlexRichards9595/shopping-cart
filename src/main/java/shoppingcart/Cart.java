package shoppingcart;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private List<Item> items = new ArrayList<>();

	public void addItem(Item itemOrder) {
		items.add(itemOrder);
	}

	public int listSize() {
		return items.size();
	}

	public int getTotalItems() {
		int itemTotal = 0;
		for (Item item : items) {
			itemTotal += item.getQuantity();
		}
		return itemTotal;
	}

	public double getTotalPrice() {
		int priceTotal = 0;
		for (Item item : items) {
			priceTotal += (item.getPrice() * item.getQuantity());
		}
		return priceTotal;

	}

	public void removeItem(String item) {
		for (int i = items.size() - 1; i >= 0; i--) {
			if (items.get(i).getItem().equals(item)) {
				items.remove(i);
			}
		}
	}

	public void showOrder() {
		for (Item item : items) {
			System.out.println(
					"Item: " + item.getItem() + " Price: " + item.getPrice() + " Quantity: " + item.getQuantity());
		}
		System.out.println("Total Price: " + getTotalPrice());
	}

	public void removePartialItem(String item, int quantityToRemove) {
		for (int i = items.size() - 1; i >= 0; i--) {
			if (items.get(i).getItem().equals(item)) {
				int newQuantity = items.get(i).getQuantity() - quantityToRemove;
				if (newQuantity > 0) {
					items.set(i, new Item(item, items.get(i).getPrice(), newQuantity));
				} else {
					removeItem(item);
				}
			}
		}
	}

}
