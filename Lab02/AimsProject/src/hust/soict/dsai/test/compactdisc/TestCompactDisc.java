package hust.soict.dsai.test.compactdisc;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;

public class TestCompactDisc {
	public static void main(String[] args) {
		// Tạo đối tượng CompactDisc
		CompactDisc cd = new CompactDisc();
		
		// Tạo các Track
		Track track1 = new Track("Track 1", 300);
		Track track2 = new Track("Track 2", 200);
		Track track3 = new Track("Track 1", 300); // Trùng với track1

		// Thêm Track vào danh sách
		System.out.println("=== Adding Tracks ===");
		cd.addTrack(track1);
		cd.addTrack(track2);
		cd.addTrack(track3); // Không thêm được vì trùng track1
		
		// Hiển thị danh sách Track
		System.out.println("\n=== Displaying Tracks ===");
		cd.printTracks();
		System.out.println("\nTotal length of the CD: " + cd.getLength() + " seconds.");

		// Xóa Track khỏi danh sách
		System.out.println("\n=== Removing Tracks ===");
		cd.removeTrack(track1); // Xóa thành công
		cd.removeTrack(track3); // Không tìm thấy
		
		// Hiển thị danh sách sau khi xóa
		System.out.println("\n=== Displaying Tracks After Removal ===");
		cd.printTracks();
		System.out.println("\nTotal length of the CD: " + cd.getLength() + " seconds.");
	}

}
