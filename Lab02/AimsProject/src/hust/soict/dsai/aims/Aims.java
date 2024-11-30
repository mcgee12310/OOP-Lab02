package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Aims {

	public static void main(String[] args) {

		// Create a new cart
		Cart anOrder = new Cart();

		// Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		anOrder.addItem(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addItem(dvd2);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		anOrder.addItem(dvd3);

		// print total cost of the items in the cart
		System.out.print("Total Cost is: ");
		System.out.println(anOrder.totalCost());

		anOrder.removeItem(dvd1);
		anOrder.removeItem(dvd2);
		anOrder.removeItem(dvd3);
		System.out.print("Total Cost is: ");
		System.out.println(anOrder.totalCost());
	}
}
