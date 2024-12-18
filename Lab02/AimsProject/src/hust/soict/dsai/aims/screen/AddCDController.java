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

            // Show success alert using JavaFX
            showAlert(Alert.AlertType.INFORMATION, "Update Store", "CD Added Successfully", 
                      "The CD '" + cd.getTitle() + "' has been added to the store.");

            // Refresh Store Screen
            refreshStoreScreen();

        } catch (NumberFormatException e) {
            // Handle invalid cost input
            showAlert(Alert.AlertType.ERROR, "Input Error", "Invalid Cost", "Please enter a valid number for the cost.");
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "Unexpected Error", "Something went wrong.");
        }
    }

    // Helper method to show alerts
    private void showAlert(Alert.AlertType type, String title, String header, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    // Helper method to refresh the StoreScreen
    private void refreshStoreScreen() {
        // Assuming you have a method to refresh the store UI dynamically
        StoreScreen storeScreen = new StoreScreen(Aims.store);
        storeScreen.setVisible(true);
    }
}
