package hust.soict.dsai.aims.media;

import java.util.*;

public class Track implements Playable {
	private String title; 
	private int length;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}

	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	
	@Override
	public boolean equals(Object obj) {	
        if (this == obj) {
            return true; // Same reference
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Null or different class
        }
        Track other = (Track) obj; // Cast to Track
        return Objects.equals(this.title, other.title) && this.length == other.length; // Compare title and length
    }
	
	public void play() {
		System.out.println("Playing Track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}

}
