package hust.soict.dsai.aims.media;

import java.util.*;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	
	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public void addAuthor(String authorName) {
		if(authors.contains(authorName)) {
			System.out.println("The author had been added.");
		}
		else {
			authors.add(authorName);
			System.out.println("The author had been added.");
		}
	} 
	
	public void removeAuthor(String authorName) {
		if(authors.contains(authorName)) {
			authors.remove(authorName);
			System.out.println("The author had been removed.");
		}
		else {			
			System.out.println("The author had been removed.");
		}
	} 
	
	public void printAuthors() {
		authors.forEach(author -> System.out.println("- " + author));
	} 

	public Book() {
		// TODO Auto-generated constructor stub	
	}
}
