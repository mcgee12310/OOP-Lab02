package hust.soict.dsai.test.cart;

import java.util.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        // Create Media objects
        Media dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f);
        Media dvd2 = new DigitalVideoDisc("Star Wars", "Sci-Fi", 24.95f);
        Media dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);

        // Add items to the cart
        cart.addItem(dvd1);
        cart.addItem(dvd2);
        cart.addItem(dvd3);

        // Display cart contents
        cart.sortByTitle();
        cart.printCart();
        cart.sortByCost();
        cart.printCart();

        // Calculate total cost
        System.out.println("Total cost: " + cart.totalCost());

        // Remove an item
        cart.removeItem(dvd2);
        cart.printCart();

        // Search for an item
        cart.searchCart("Aladdin");
        

		List<Media> mediae = new ArrayList<Media>();
		// create some media here
		// for example: cd, dvd, book
		mediae.add(dvd1);
		mediae.add(dvd2);
		mediae.add(dvd3);
		for (Media m : mediae) {
			System.out.println(m.toString());
		}
    }
}