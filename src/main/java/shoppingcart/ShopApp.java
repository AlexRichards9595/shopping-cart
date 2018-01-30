package shoppingcart;

import java.util.Scanner;

public class ShopApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Cart myOrder = new Cart();

		String done = "n";

		while (!done.equalsIgnoreCase("y")) {
			System.out.println("What would you like to do");
			System.out.println("1. Add");
			System.out.println("2. Remove");
			String addOrRemove = input.nextLine();

			if (addOrRemove.equalsIgnoreCase("add") || addOrRemove.equals("1")) {
				System.out.println("Please enter the item name.");
				String newItem = input.nextLine();
				System.out.println("Please enter the price.");
				double itemPrice = input.nextDouble();
				System.out.println("Please enter the quantity of the item.");
				int itemQuantity = input.nextInt();
				input.nextLine();
				myOrder.addItem(new Item(newItem, itemPrice, itemQuantity));
				myOrder.showOrder();
			}

			else if (addOrRemove.equalsIgnoreCase("remove") || addOrRemove.equals("2")) {
				System.out.println("What would you like to remove? (variety or none)");
				String toRemove = input.nextLine();
				System.out.println("Would you like to remove entire item or partial? (e/p)");
				String entireOrPartial = input.nextLine();
				if (entireOrPartial.equalsIgnoreCase("e")) {
					System.out.println("You are choosing to remove " + toRemove);
					myOrder.removeItem(toRemove);
				} else {
					System.out.println("Enter the quantity that you would like to remove of this item.");
					int quantityToRemove = input.nextInt();
					input.nextLine();
					myOrder.removePartialItem(toRemove, quantityToRemove);
				}
				System.out.println("Current Cart:");
				myOrder.showOrder();
			}
			System.out.println();
			System.out.println("Are you done?(y/n)");
			done = input.nextLine();
			System.out.println();

		}

		myOrder.showOrder();

		input.close();
	}

}
