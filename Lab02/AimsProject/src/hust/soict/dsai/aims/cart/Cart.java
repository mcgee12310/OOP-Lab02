package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc [MAX_NUMBERS_ORDERED];
	public static int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added.");
        } 
        else {
            System.out.println("The cart is full");
        }
    }
	
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
	    for (DigitalVideoDisc disc : dvdList) {
	        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
	            itemsOrdered[qtyOrdered] = disc;
	            qtyOrdered++;
	            System.out.println("The disc has been added.");
	        } else {
	            System.out.println("The cart is full. No more discs can be added.");
	            break;
	        }
	    }
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = dvd1;
            qtyOrdered++;
            System.out.println("The disc has been added.");
        } 
        else {
            System.out.println("The cart is full");
        }
		
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = dvd2;
            qtyOrdered++;
            System.out.println("The disc has been added.");
        } 
        else {
            System.out.println("The cart is full");
        }
    }
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc has been removed.");
                break;
            }
        }
    }

    public float totalCost() {
        float totalCost = 0;
        for (int i = 0; i < qtyOrdered; i++) {
        	totalCost += itemsOrdered[i].getCost();
        }
        return totalCost;
    }
    
    public void printCart() {
    	System.out.println("***********************CART***********************");
    	System.out.println("Ordered Items:");
    	
    	int id = 1;
    	for (DigitalVideoDisc disc : itemsOrdered) {   
    		if(disc == null) break;
    		System.out.println(id + ". DVD - " + disc.getTitle() + " - " + disc.getCategory() + " - " + disc.getDirector() + " - " + disc.getLength() + ": " + disc.getCost() + " $");
    		id++;
    		
	    }
    	
    	System.out.println("Total cost: " + totalCost());
    	System.out.println("***************************************************");	
    }
    
    public void searchCart(String title) {
    	System.out.println("***********************CART***********************");
    	System.out.println("Searching Items: " + title);
    	
    	int id = 1;
    	for (DigitalVideoDisc disc : itemsOrdered) {   
    		if(disc == null) {
    			System.out.println("NOT FOUND");
    			break;
    		}
    		if(disc.getTitle() == title) {
    			System.out.println(id + ". DVD - " + disc.getTitle() + " - " + disc.getCategory() + " - " + disc.getDirector() + " - " + disc.getLength() + ": " + disc.getCost() + " $");
    			break;
    		}    		
    		id++;    		
	    }
    	System.out.println("***************************************************");	
    }
}
