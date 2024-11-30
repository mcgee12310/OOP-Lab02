package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Store {
	public static final int MAX_DVDs = 1000005;;
	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc [MAX_DVDs];
	public static int qtyDVD = 0;
	
	public void addDVD(DigitalVideoDisc disc) {
        if (qtyDVD < MAX_DVDs) {
        	itemsInStore[qtyDVD] = disc;
        	qtyDVD++;
            System.out.println("The DVD has been added to the store.");
        } 
        else {
            System.out.println("The store is full.");
        }
    }
	
	public void removeDVD(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyDVD; i++) {
            if (itemsInStore[i] == disc) {
                for (int j = i; j < qtyDVD - 1; j++) {
                	itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyDVD - 1] = null;
                qtyDVD--;
                System.out.println("The DVD has been removed from the store.");
                break;
            }
        }
    }
	
	public void printStore() {
    	System.out.println("***********************STORE***********************");
    	System.out.println("Store's items:");
    	
    	int id = 1;
    	for (DigitalVideoDisc disc : itemsInStore) {   
    		if(disc == null) break;
    		System.out.println(id + ". DVD - " + disc.getTitle() + " - " + disc.getCategory() + " - " + disc.getDirector() + " - " + disc.getLength() + ": " + disc.getCost() + " $");
    		id++;    		
	    }
    	    
    	System.out.println("***************************************************");	
    }
    
    public void searchStore(String title) {
    	System.out.println("***********************CART***********************");
    	System.out.println("Searching Items: " + title);
    	
    	int id = 1;
    	for (DigitalVideoDisc disc : itemsInStore) {   
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
