package hust.soict.dsai.aims.media;

import java.util.*;

public abstract class Media {
	
	private int id;
	private String title; 
	private String category; 
	private float cost; 
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Same reference
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Null or different class
        }
        Media other = (Media) obj; // Cast to Media
        return Objects.equals(this.title, other.title); // Compare titles
    }
	
	// Comparators
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = Comparator
        .comparing(Media::getTitle)
        .thenComparing(Comparator.comparing(Media::getCost).reversed());

    public static final Comparator<Media> COMPARE_BY_COST_TITLE = Comparator
        .comparing(Media::getCost).reversed()
        .thenComparing(Media::getTitle);

	public Media() {
		// TODO Auto-generated constructor stub
	}

}
