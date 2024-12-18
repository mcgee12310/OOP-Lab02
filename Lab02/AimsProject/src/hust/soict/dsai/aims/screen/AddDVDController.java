package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AddDVDController {

    

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfCategory;
    
    @FXML
    private TextField tfDirector;

    @FXML
    private TextField tfLenght;
    
    @FXML
    private TextField tfCost;

    @FXML
    void OkPressed(ActionEvent event) {
        try {
            // Parse input fields and validate user input
        	String title = tfTitle.getText().trim();
            String category = tfCategory.getText().trim();
            String director = tfDirector.getText().trim();
            float cost = Float.parseFloat(tfCost.getText().trim());
            int length = Integer.parseInt(tfLenght.getText().trim());

            // Create a new DigitalVideoDisc object
            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);

            // Add the DVD to the store
            Aims.store.addMedia(dvd);
            
         // Show success message
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Store Update");
            alert.setHeaderText("Book Added Successfully");
            alert.setContentText("The book '" + dvd.getTitle() + "' has been added to the store.");
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
