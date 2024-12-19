package hust.soict.dsai.javafx;

import java.io.IOException;

import javax.swing.JFrame;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Painter extends JFrame {
	public Painter()
	{ 
		super();		
		final JFXPanel fxPanel = new JFXPanel();	
		this.add(fxPanel);
		
		this.setTitle("Painter");
		this.setVisible(true);
		Platform.runLater(new Runnable() {
			public void run()
			{
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("painter.fxml"));
					PainterController controller =
							  new PainterController();
					loader.setController(controller);
					Parent root= loader.load();
					fxPanel.setScene(new Scene(root));
					
				}catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		});

	} 
	
	public static void main(String[] args) {
		new Painter();
	}

}
