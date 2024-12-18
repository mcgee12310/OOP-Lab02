package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.media.CompactDisc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AddCDController {

    @FXML
    private TextField tfCost;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfCategory;

    @FXML
    private TextField tfArtist;

    // Action when "OK" is pressed
    @FXML
    void OkPressed(ActionEvent event) {
        try {
            // Validate and parse cost input
            float cost = Float.parseFloat(tfCost.getText());

            // Create a new CompactDisc object
            CompactDisc cd = new CompactDisc(tfTitle.getText(), tfCategory.getText(), cost, tfArtist.getText());

            // Add the new CD to the store
            Aims.store.addMedia(cd);

            new StoreScreen(Aims.store);

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
