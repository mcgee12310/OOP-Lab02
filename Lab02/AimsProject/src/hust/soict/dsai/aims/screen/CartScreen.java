package hust.soict.dsai.aims.screen;

import java.io.IOException;

import javax.swing.*;

import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.cart.Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame{
	private Cart cart;
	public CartScreen(final Cart cart)
	{   super();
	
		this.cart=cart;
		
		final JFXPanel fxPanel = new JFXPanel();
		
		this.add(fxPanel);
		
		this.setTitle("Cart");
		this.setVisible(true);
		Platform.runLater(new Runnable() {
			public void run()
			{
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("Cart.fxml"));
					CartScreenController controller = new CartScreenController(cart);
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


}
