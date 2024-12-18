package hust.soict.dsai.aims.screen;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel{
   private Media media;
   public MediaStore(Media media) {
	    this.media = media;
	    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	    
	    JLabel title = new JLabel(media.getTitle());
	    title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20)); 
	    title.setAlignmentX(CENTER_ALIGNMENT);
	    
	    JLabel cost = new JLabel("" + media.getCost() + " $"); 
	    cost.setAlignmentX(CENTER_ALIGNMENT);
	    
	    JPanel container = new JPanel();
	    container.setLayout(new FlowLayout(FlowLayout.CENTER));
	    
	    JButton addToCartButton = new JButton("Add to Cart");
	    addToCartButton.addActionListener(e -> handleAddToCartButton(media, Aims.cart)); // Call handleAddToCartButton
	    container.add(addToCartButton); 
	    
	    if (media instanceof Playable) {
	        JButton playButton = new JButton("Play");
	        playButton.addActionListener(e -> handlePlayButton(media)); // Call handlePlayButton
	        container.add(playButton);
	    }

	    this.add(Box.createVerticalGlue());
	    this.add(title); 
	    this.add(cost);
	    this.add(Box.createVerticalGlue());
	    this.add(container);
	    
	    this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	   
   
   private void handlePlayButton(Media media) {
	    if (media instanceof Playable) {
	        Playable playableMedia = (Playable) media;

	        JDialog dialog = new JDialog();
	        dialog.setTitle("Playing Media");
	        dialog.setSize(300, 200);
	        dialog.setLayout(new BorderLayout());

	        JLabel message = new JLabel("Now Playing: " + ((Media) playableMedia).getTitle(), SwingConstants.CENTER);
	        message.setFont(new Font("Arial", Font.PLAIN, 18));
	        dialog.add(message, BorderLayout.CENTER);

	        JButton okButton = new JButton("OK");
	        okButton.addActionListener(e -> dialog.dispose());
	        dialog.add(okButton, BorderLayout.SOUTH);

	        dialog.setLocationRelativeTo(null); // Center on screen
	        dialog.setVisible(true);
	    } else {
	        JOptionPane.showMessageDialog(null, 
	            "This media type cannot be played!", 
	            "Error", 
	            JOptionPane.ERROR_MESSAGE);
	    }
	}
   
   private void handleAddToCartButton(Media media, Cart cart) {
	   cart.addItem(media);
	}
}
