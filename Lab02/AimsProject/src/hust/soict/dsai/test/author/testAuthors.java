package hust.soict.dsai.test.author;

import hust.soict.dsai.aims.media.Book;

public class testAuthors {
	public static void main(String[] args) {
		Book book = new Book();

        // Thêm tác giả vào danh sách
        System.out.println("=== Testing addAuthor() ===");
        book.addAuthor("Author 1");
        book.addAuthor("Author 2");
        book.addAuthor("Author 3");
        book.addAuthor("Author 1"); // Tác giả đã tồn tại

        // Kiểm tra danh sách tác giả sau khi thêm
        System.out.println("\nList of authors after adding:");  
        book.printAuthors();

        // Xóa tác giả khỏi danh sách
        System.out.println("\n=== Testing removeAuthor() ===");
        book.removeAuthor("Author 2"); // Tồn tại, nên xóa được
        book.removeAuthor("Author 4"); // Không tồn tại

        // Kiểm tra danh sách tác giả sau khi xóa
        System.out.println("\nList of authors after removing:");
        book.printAuthors();
    }
}
