package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Media {	
	private static int nbDigitalVideoDiscs = 0;
	
	private String director; 
	private int length;
		
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}	
	public void setDirector(String director) {
		this.director = director;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	public DigitalVideoDisc(String title) {
		super();
		this.setTitle(title); // Sử dụng setter từ lớp cha
		this.setId(nbDigitalVideoDiscs); // Sử dụng setter từ lớp cha
		nbDigitalVideoDiscs++;
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.setTitle(title);
		this.setCategory(category);
		this.setCost(cost);
		this.setId(nbDigitalVideoDiscs);
		nbDigitalVideoDiscs++;
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.setTitle(title);
		this.setCategory(category);
		this.setCost(cost);
		this.director = director;
		this.setId(nbDigitalVideoDiscs);
		nbDigitalVideoDiscs++;
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.setTitle(title);
		this.setCategory(category);
		this.director = director;
		this.length = length;
		this.setCost(cost);
		this.setId(nbDigitalVideoDiscs);
		nbDigitalVideoDiscs++;
	}	
}
