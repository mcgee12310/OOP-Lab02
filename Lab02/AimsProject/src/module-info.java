/**
 * 
 */
/**
 * 
 */
module AimsProject {
	requires java.desktop;
	requires javafx.graphics;
	requires javafx.swing;
	requires javafx.fxml;
	requires javafx.controls;
	requires javafx.base;
	opens hust.soict.dsai.aims.media to javafx.base;
	opens hust.soict.dsai.aims.screen to javafx.fxml;
}