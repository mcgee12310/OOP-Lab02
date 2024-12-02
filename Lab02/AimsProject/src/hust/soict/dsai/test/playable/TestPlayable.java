package hust.soict.dsai.test.playable;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;

public class TestPlayable {
	
	public static void main(String[] args) {
        // Test Track
        Track track1 = new Track("Track 1", 300);
        Track track2 = new Track("Track 2", 250);
        track1.play();
        track2.play();

        System.out.println();

        // Test DigitalVideoDisc
        DigitalVideoDisc dvd = new DigitalVideoDisc("Movie 1", "Action", "Director 1", 120, 19.99f);
        dvd.play();

        System.out.println();

        // Test CompactDisc
        CompactDisc cd = new CompactDisc("Thriller", "Pop", 15.99f, "Michael Jackson");
        cd.setTitle("CD 1");
        cd.addTrack(track1);
        cd.addTrack(track2);
        cd.play();
    }

	public TestPlayable() {
		// TODO Auto-generated constructor stub
	}

}
