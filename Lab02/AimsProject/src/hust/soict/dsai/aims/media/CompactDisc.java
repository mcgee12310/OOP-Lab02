package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();

	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public boolean ifExisted(Track addTrack) {
		for (Track track : tracks) {
			if(addTrack.getTitle() == track.getTitle()) {
				return true;
			}
		}
		return false;
	}
	
	public void addTrack(Track removeTrack) {
		if (ifExisted(removeTrack)) { // Kiểm tra xem track đã tồn tại chưa
			System.out.println("Track already exists: " + removeTrack.getTitle());
		} else {
			tracks.add(removeTrack);
			System.out.println("Track added: " + removeTrack.getTitle());
		}
	}
	
	public void removeTrack(Track addTrack) {
		if (ifExisted(addTrack)) {
			tracks.remove(addTrack);
			System.out.println("Track removed: " + addTrack.getTitle());
		} else {
			System.out.println("Track not found: " + addTrack.getTitle());
		}
	}
	
	public void printTracks() {
		if (tracks.isEmpty()) {
			System.out.println("No tracks available.");
		} else {
			System.out.println("Tracks:");
			for (Track track : tracks) {
				System.out.println("- Title: " + track.getTitle() + ", Length: " + track.getLength());
			}
		}
	}
	
	public int getLength() {
		int totalLength = 0;
		for (Track track : tracks) {
			totalLength += track.getLength();
		}
		return totalLength;
	}
	
	public void play() {
        System.out.println("Playing Compact Disc: " + this.getTitle());
        System.out.println("Total CD length: " + this.getLength());
        for (Track track : tracks) {
            track.play(); // Call the play() method of each track
        }
    }

	public CompactDisc() {
		// TODO Auto-generated constructor stub
	}

}
