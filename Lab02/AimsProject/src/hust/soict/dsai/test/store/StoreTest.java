package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
	public static void main(String[] args) {
		//Create a new store
		Store store = new Store();
		
		//Create new dvd objects and add them to the cart 
		DigitalVideoDisc dvd1 = new DigitalVideoDisc ("The Lion King", "Animation", "Roger Allers", 87, 19.95f); 
		store.addDVD(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc ("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f); 
		store.addDVD(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		store.addDVD(dvd3);
		
		store.printStore();
		
		store.removeDVD(dvd1);
		store.printStore();
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Soul of Cinder", "Game", "Miyazaki", 99);
		store.addDVD(dvd4);
		store.printStore();
	}
}	
