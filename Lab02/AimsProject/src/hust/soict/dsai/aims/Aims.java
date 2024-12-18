package hust.soict.dsai.aims;

import java.util.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	public static Cart cart = new Cart();
	public static Store store = new Store();
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {	
		// Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		store.addMedia(dvd2);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		store.addMedia(dvd3);
		
		store.addMedia(new CompactDisc("Back in Black", "Rock", 12.99f, "AC/DC"));
		store.addMedia(new CompactDisc("Dark Side of the Moon", "Progressive Rock", 14.99f, "Pink Floyd"));
		store.addMedia(new CompactDisc("Abbey Road", "Rock", 13.99f, "The Beatles"));
		
		store.addMedia(new Book("The Hobbit", "Fantasy", 15.99f));
		store.addMedia(new Book("Moby Dick", "Adventure", 14.99f));
		store.addMedia(new Book("War and Peace", "Historical Fiction", 19.99f));
		

        
		// print total cost of the items in the cart
		/*
		System.out.print("Total Cost is: ");
		System.out.println(cart.totalCost());

		cart.removeItem(dvd1);
		cart.removeItem(dvd2);
		cart.removeItem(dvd3);
		System.out.print("Total Cost is: ");
		System.out.println(cart.totalCost());
		*/
		// Menu
        //clearConsole();
		//showMenu();
        
        StoreScreen storeScreen = new StoreScreen(store);
	}
	
	public static void clearConsole() {
	    for (int i = 0; i < 50; i++) { // Số lượng dòng trống tùy ý
	        System.out.println();
	    }
	}
	
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		
		int option;
        do {
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (option) {
                case 1 -> {
                	clearConsole();
                	store.printStore();
                	storeMenu();
                }
                case 2 ->{
                	clearConsole();
                	updateStore();
                }
                case 3 -> {
                	clearConsole();
                	cart.printCart();
                	cartMenu();
                }
                case 0 -> {
                	clearConsole();
                	System.out.println("Exiting AIMS...");
                	System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (option != 0);
	}
	
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		
		int option;
        do {
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (option) {
                case 1 -> {
                	seeMediaDetails();
                }
                case 2 ->{
                	addMediaToCart();
                }
                case 3 ->{
                	clearConsole();
                	playMedia();
                	storeMenu();
                }
                case 4 -> {
                	clearConsole();
                	cart.printCart();
                	cartMenu();
                }
                case 0 -> {
                	clearConsole();
                	System.out.println("Back to main menu...");
                	showMenu();
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (option != 0);
	}
	
	public static void updateStore() {
        System.out.println("Update store:");
        System.out.println("--------------------------------");
        System.out.println("1. Add a media");
        System.out.println("2. Remove a media");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (option) {
            case 1 -> {
                // Code to add a media (e.g., prompt user for media details and add to store)
            	clearConsole();
            	store.addMedia(null);
            	updateStore();
            }
            case 2 -> {
            	clearConsole();
                store.removeMedia(null);
                updateStore();
            }
            case 0 -> {
            	clearConsole();
            	System.out.println("Returning to main menu...");
            	showMenu();
            }
            default -> System.out.println("Invalid choice.");
        }
    }
	
	public static void seeMediaDetails() {
        System.out.println("Enter the title of the media: ");
        String title = scanner.nextLine();
        clearConsole();
        Media media = store.searchStore(title);

        System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		
		int option;
        do {
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (option) {
                case 1 -> {
                	clearConsole();
                	cart.addItem(media);
                	cart.printCart();
                	storeMenu();
                }
                case 2 ->{
                	if (media == null) {
                    	System.out.println("NOT FOUND.");
                        
                    } else if (media instanceof DigitalVideoDisc || media instanceof CompactDisc) {
                        if (media instanceof DigitalVideoDisc) {
                            ((DigitalVideoDisc) media).play();
                        } else if (media instanceof CompactDisc) {
                            ((CompactDisc) media).play();
                        }
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                }
                case 0 -> {
                	clearConsole();
                	storeMenu();
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (option != 0);
    }
	
	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		
		int option;
        do {
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (option) {
                case 1 -> {
                	clearConsole();
                	addMediaToCart();
                }
                case 2 ->{
                	clearConsole();
                	playMedia();
                }
                case 0 -> {
                	clearConsole();
                	storeMenu();
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (option != 0);
	}
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
		
		int option;
        do {
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (option) {
                case 1 -> filterMediasInCart();
                case 2 -> sortMediasInCart();
                case 3 -> removeMediaFromCart();
                case 4 -> playMedia();
                case 5 -> {
                	clearConsole();
                	placeOrder();
                	showMenu();
                }
                case 0 -> {
                	System.out.println("Returning to main menu...");
                	showMenu();
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (option != 0);
	}
	
	public static void addMediaToCart() {
        System.out.println("Enter the title of the media to add to cart: ");
        String title = scanner.nextLine();
        Media media = store.searchStore(title);

        if (media == null) {
        	clearConsole();
            System.out.println("Media not found in store.");
            cart.printCart();
        	cartMenu();
        } else {
        	clearConsole();
            cart.addItem(media);
            cart.printCart();
        	cartMenu();
        }
        storeMenu();
    }
	
	public static void removeMediaFromCart() {
        System.out.println("Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        Media media = cart.searchCart(title);

        if (media == null) {
        	clearConsole();
            System.out.println("Media not found in cart.");
            cart.printCart();
        	cartMenu();
        } else {
        	clearConsole();
            cart.removeItem(media);
        	cart.printCart();
        	cartMenu();
        }
        storeMenu();
    }
	
	public static void playMedia() {
        System.out.println("Enter the title of the media to play: ");
        String title = scanner.nextLine();
        Media media = store.searchStore(title);

        if (media == null) {
        	System.out.println("NOT FOUND.");
            
        } else if (media instanceof DigitalVideoDisc || media instanceof CompactDisc) {
            if (media instanceof DigitalVideoDisc) {
                ((DigitalVideoDisc) media).play();
            } else if (media instanceof CompactDisc) {
                ((CompactDisc) media).play();
            }
        } else {
            System.out.println("This media cannot be played.");
        }
        storeMenu();
    }
	
	public static void filterMediasInCart() {
        // Filtering logic (e.g., by title or by ID)
		System.out.println("Filter cart:");
        System.out.println("--------------------------------");
        System.out.println("1. By title.");
        System.out.println("2. By cost.");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 1-2");
    	int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (option) {
            case 1 -> {
                // Code to add a media (e.g., prompt user for media details and add to store)
            	clearConsole();
            	cart.sortByTitle();
            	cart.printCart();
            	cartMenu();
            }
            case 2 -> {
            	clearConsole();
            	cart.sortByCost();
            	cart.printCart();
            	cartMenu();
            }
            default -> System.out.println("Invalid choice.");
        }
    }

    public static void sortMediasInCart() {
        // Sorting logic (e.g., by title or by cost)
    	System.out.println("Sort cart:");
        System.out.println("--------------------------------");
        System.out.println("1. By title.");
        System.out.println("2. By cost.");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 1-2");
    	int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (option) {
            case 1 -> {
                // Code to add a media (e.g., prompt user for media details and add to store)
            	clearConsole();
            	cart.sortByTitle();
            	cart.printCart();
            	cartMenu();
            }
            case 2 -> {
            	clearConsole();
            	cart.sortByCost();
            	cart.printCart();
            	cartMenu();
            }
            default -> System.out.println("Invalid choice.");
        }
    }
    
    public static void placeOrder() {
        System.out.println("Order placed successfully!");
        cart.deleteCart();
    }
}
