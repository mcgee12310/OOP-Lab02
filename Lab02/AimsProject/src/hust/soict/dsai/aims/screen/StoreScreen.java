package hust.soict.dsai.aims.screen;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class StoreScreen extends JFrame {
public static AddDVDscreen addDVDscreen;
public static AddCDscreen addCDscreen;
public static AddBookscreen addBookscreen;
public static CartScreen cartScreen;
private Store store;
 JPanel createNorth()
 {
	 JPanel north = new JPanel();
	 north.setLayout( new BoxLayout(north, BoxLayout.Y_AXIS));
	 north.add(createMenuBar());
	 north.add(createHeader());
	 return north;
	 
 }
 JMenuBar createMenuBar()
 {
	 JMenu menu =new JMenu("Options");
	 JMenu smUpdateStore = new JMenu("Update Store");
	 
	 JMenuItem addDVD =new JMenuItem("Add DVD");
	 addDVD.addActionListener(new MenuItemListener());
	 smUpdateStore.add(addDVD);
	 
	 JMenuItem addCD=new JMenuItem("Add CD");
	 addCD.addActionListener(new MenuItemListener());
	 smUpdateStore.add(addCD);
	 
	 JMenuItem addBook=new JMenuItem("Add Book");
	 addBook.addActionListener(new MenuItemListener());
	 smUpdateStore.add(addBook);

	 menu.add(smUpdateStore);
	 menu.add(new JMenuItem("View store"));
	 
	 JMenuItem viewcart=new JMenuItem("View cart");
	 viewcart.addActionListener(new MenuItemListener());
	 menu.add(viewcart);
	 JMenuBar menuBar = new JMenuBar();
	 menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	 menuBar.add(menu);
	 return menuBar;
 }
 JPanel createHeader()
 {
	 JPanel header = new JPanel();
	 header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
	 
	 JLabel title = new JLabel("AIMS");
	 title.setFont(new Font(title.getFont().getName(),Font.PLAIN, 50));
	 title.setForeground(Color.CYAN);
	 
	 JButton cart = new JButton("View cart");
	 cart.addActionListener(new ButtonListener());
	 cart.setPreferredSize(new Dimension(100,50));
	 cart.setMaximumSize(new Dimension(100,50));
	 
	 header.add(Box.createRigidArea(new Dimension(10,10)));
	 header.add(title);
	 header.add(Box.createHorizontalGlue());
	 header.add(cart);
	 header.add(Box.createRigidArea(new Dimension(10,10)));
	 
	 return header;
 }
 JPanel  createCenter()
 {
	 JPanel center = new JPanel();
	 center.setLayout(new GridLayout(3,3,2,2));
	 
	 ArrayList<Media> mediaInStore = store.getItemsInStore();
	 for(int i=0; i<mediaInStore.size(); i++)
	 {
		 MediaStore cell = new MediaStore(mediaInStore.get(i));
		 center.add(cell);
	 }
	 return center;
 }
 public StoreScreen(Store store)
 {
	 this.store = store;
	 Container cp = getContentPane();
	 cp.setLayout(new BorderLayout());
	 
	 cp.add(createNorth(), BorderLayout.NORTH);
	 cp.add(createCenter(), BorderLayout.CENTER);
	 setVisible(true);
	 setTitle("Store");
	 setSize(1024,768);
 }
 private class ButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		   String button = e.getActionCommand();
           if(button.equals("View cart"))
           {   setVisible(false);
           cartScreen =new CartScreen(Aims.cart);
           cartScreen.setSize(1024,768);
           }
		
	}}
public class MenuItemListener implements ActionListener {
	     @Override   
		 public void actionPerformed(ActionEvent e) {
	        	String menuitem = e.getActionCommand();
	        	if(menuitem.equals("Add DVD"))
	        		  {  setVisible(false);
	        		  	addDVDscreen= new AddDVDscreen();
	        		  	addDVDscreen.setSize(934,595);
	        		    
	        		  }
	        	else if(menuitem.equals("Add CD"))
	        	{
	        		setVisible(false);
	        		addCDscreen=new AddCDscreen();
	        		addCDscreen.setSize(934,595);
	        	
	        	}
	        	else if(menuitem.equals("Add Book"))
	        	{
	        		setVisible(false);
	        		addBookscreen=new AddBookscreen();
	        		addBookscreen.setSize(934,595);
	        	}
	        	else if(menuitem.equals("View cart"))
	        	{    setVisible(false);
	        		cartScreen =new CartScreen(Aims.cart);
	        		cartScreen.setSize(1024,768);
	        	}
	        	
	        }
	        }	
 
}
