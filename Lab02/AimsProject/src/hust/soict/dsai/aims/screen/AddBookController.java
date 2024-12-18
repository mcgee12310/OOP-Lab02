package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.media.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AddBookController {

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfCategory;

    @FXML
    private TextField tfCost;

    @FXML
    void OkPressed(ActionEvent event) {
        try {
            // Retrieve and parse user input
            String title = tfTitle.getText().trim();
            String category = tfCategory.getText().trim();
            float cost = Float.parseFloat(tfCost.getText().trim());

            // Create a new book and add to the store
            Book book = new Book(title, category, cost);
            Aims.store.addMedia(book);

            // Show success message
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Store Update");
            alert.setHeaderText("Book Added Successfully");
            alert.setContentText("The book '" + book.getTitle() + "' has been added to the store.");
            alert.showAndWait();

            // Clear input fields
            tfTitle.clear();
            tfCategory.clear();
            tfCost.clear();

        } catch (NumberFormatException e) {
            // Handle invalid input for cost
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Invalid Input");
            alert.setContentText("Please enter a valid number for the cost.");
            alert.showAndWait();
        }
    }
}
