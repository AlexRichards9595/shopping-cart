package shoppingcart;

public class Item {

	private String item;
	private double price;
	private int quantity;

	public Item() {
	}

	public Item(String item, double price, int quantity) {
		this.item = item;
		this.price = price;
		this.quantity = quantity;

	}

	public String getItem() {
		return item;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

}
