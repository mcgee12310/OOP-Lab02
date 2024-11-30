package hust.soict.dsai.aims.cart;

import java.util.*;

import hust.soict.dsai.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private List<Media> itemsOrdered = new ArrayList<Media>();
	
	public float totalCost() {
		float totalCost = 0;
        for (Media item : itemsOrdered) {
            totalCost += item.getCost();
        }
        return totalCost;
    }
	
    public void addItem(Media item) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(item);
            System.out.println(item.getTitle() + " has been added to the cart.");
        } else {
            System.out.println("The cart is full. Cannot add " + item.getTitle() + ".");
        }
    }

    public void removeItem(Media item) {
        if (itemsOrdered.remove(item)) {
            System.out.println(item.getTitle() + " has been removed from the cart.");
        } else {
            System.out.println(item.getTitle() + " is not in the cart.");
        }
    }
    
    public void printCart() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            System.out.println("Cart:");
            for (Media item : itemsOrdered) {
                System.out.println("- " + item.getTitle());
            }
        }
    }
    
    public Media searchCart(String title) {
        for (Media item : itemsOrdered) {
            if (item.getTitle().equalsIgnoreCase(title)) {
            	System.out.println("- " + item.getTitle());
            	return item;
            }
        }
        System.out.println("NOT FOUND");
        return null;
    }
    
    public void deleteCart() {
    	itemsOrdered.clear();
    }
    
    // Sort by title 
    public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    // Sort by cost
    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }
	
}
