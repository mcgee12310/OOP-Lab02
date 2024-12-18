package hust.soict.dsai.aims.cart;

import java.util.*;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	public ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	
	public float totalCost() {
		float totalCost = 0;
        for (Media item : itemsOrdered) {
            totalCost += item.getCost();
        }
        return totalCost;
    }
	
	public void addItem(Media item) {
	    if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
	        System.out.println("The cart is full. Cannot add " + item.getTitle() + ".");
	        return;
	    }
	    
	    if (itemsOrdered.contains(item)) { // Kiểm tra xem item đã có trong giỏ hàng hay chưa
	        System.out.println(item.getTitle() + " is already in the cart.");
	        return;
	    }
	    
	    itemsOrdered.add(item); // Thêm vào nếu chưa tồn tại
	    System.out.println(item.getTitle() + " has been added to the cart.");
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
                System.out.println("- " + item.getTitle() + " - " + item.getCategory() + " - " + item.getCost());
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
    
    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
	
    public ObservableList<Media> searchID(int id) {
        ObservableList<Media> result = FXCollections.observableArrayList();
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                result.add(media);
            }
        }
        return result;
    }
    
    public ObservableList<Media> searchTitle(String title) {
        ObservableList<Media> result = FXCollections.observableArrayList();
        for (Media media : itemsOrdered) {
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(media);
            }
        }
        return result;
    }
}
