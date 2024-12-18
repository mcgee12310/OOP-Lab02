package hust.soict.dsai.aims.screen;

import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {

    private Float total;
	@FXML
	private Label lblTotal;
    @FXML
    private TextField tfFilter;
    private Cart cart;
    @FXML
    private Button btnPlay;
    @FXML
    private RadioButton rbtnFilterID;
    @FXML
    private RadioButton rbtnFilterTitle;
    @FXML
    private Button btnRemove;
    @FXML
    private ToggleGroup filter;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;
    public CartScreenController(Cart cart)
    {
    	super();
    	this.cart= cart;
    }
    @FXML
    private void initialize(){  //Khoi tao
    	colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
    	colMediacategory.setCellValueFactory(new PropertyValueFactory<>("category"));
    	colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
    	tblMedia.setItems(this.cart.getItemsOrdered());
    	setTotal();
    	btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
        		new ChangeListener<Media>()
        		{

					@Override
					public void changed(ObservableValue<? extends Media> arg0, Media arg1, Media arg2) {
						// TODO Auto-generated method stub
						if( arg2 != null)
                            updateButtonBar(arg2); 
                        					}
					private void updateButtonBar(Media arg2) {
                        btnRemove.setVisible( true);
                        if( arg2 instanceof Playable)
                            btnPlay.setVisible( true);
                         else
                            btnPlay.setVisible( false);
                        
                		};

                   });
        tfFilter.textProperty().addListener(new ChangeListener<String>()
        		{

					@Override
					public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
						// TODO Auto-generated method stub
						showFilteredMedia(arg2);
						
					} 
					private void showFilteredMedia(String newValue){
					    // Check if the search field is empty
					    if (newValue.length() == 0) {
					        // Reset to show all media items
					        tblMedia.setItems(cart.getItemsOrdered());
					        setTotal(); // Update the total cost
					    } else {
					        // Check if filter by ID is selected
					        if (rbtnFilterID.isSelected()) {
					            try {
					                // Parse the ID and filter items by ID
					                int id = Integer.parseInt(newValue);
					                tblMedia.setItems(cart.searchID(id)); // Ensure this returns ObservableList<Media>
					                setTotal(); // Update the total cost
					            } catch (NumberFormatException e) {
					                // Handle invalid ID input (not a valid integer)
					                System.out.println("Invalid ID entered: " + newValue);
					                // Optionally, show a message to the user
					            }
					        }
					        
					        // Check if filter by Title is selected
					        if (rbtnFilterTitle.isSelected()) {
					            // Filter items by title
					            tblMedia.setItems(cart.searchTitle(newValue)); // Ensure this returns ObservableList<Media>
					            setTotal(); // Update the total cost
					        }
					    }
					}
        	
        		}
        		);
       
        

}
private void setTotal()
{    //tinh tong
	ObservableList<Media> Items = Aims.cart.getItemsOrdered();
     float total = 0;
     for(Media m : Items)
      total=total+m.getCost();
     DecimalFormat df = new DecimalFormat("#.00");

     if (total == 0) lblTotal.setText(" 0$");
     else lblTotal.setText(df.format(total)+"$");
}
@FXML
void btnRemovePressed(ActionEvent event)
    //remove button
	{ Media media=tblMedia.getSelectionModel().getSelectedItem();
	  cart.removeItem(media);
      setTotal();

		
	}
@FXML
void btnPlayPressed(ActionEvent event)
  //play button
{     Media media=tblMedia.getSelectionModel().getSelectedItem();
			if(media instanceof DigitalVideoDisc) {
				 
			    DigitalVideoDisc dvd = (DigitalVideoDisc)media;
				  JFrame frame = new JFrame("JOptionPane showMessageDialog example");
				  if(dvd.getLength()>0)
					  JOptionPane.showMessageDialog(frame,
				                "DVD length: " + dvd.getLength(),
				                dvd.getTitle()+ " is playing",
				                JOptionPane.INFORMATION_MESSAGE);
				  else
					  JOptionPane.showMessageDialog(frame,
				                "ERROR: DVD length is non-positive!",
				                dvd.getTitle()+ " ERROR",
				                JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				  CompactDisc cd = (CompactDisc)media;
				  JFrame frame = new JFrame("JOptionPane showMessageDialog example");
				  if(cd.getLength()>0)
					  JOptionPane.showMessageDialog(frame,
				                "CD length: " + cd.getLength(),
				                cd.getTitle()+ " is playing",
				                JOptionPane.INFORMATION_MESSAGE);
				  else
					  JOptionPane.showMessageDialog(frame,
				                "ERROR: CD length is non-positive!",
				                cd.getTitle()+ " ERROR",
				                JOptionPane.ERROR_MESSAGE);
			}
   }
@FXML 
void PlaceOrderPressed(ActionEvent event)
//PlaceOrder button
{ 	cart.itemsOrdered.clear();
    setTotal();
    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
		  JOptionPane.showMessageDialog(frame,
	                "Cart was Ordered",
	                "Ordered Information",
	                JOptionPane.INFORMATION_MESSAGE);
	
}
@FXML
void AddBookPressed(ActionEvent event) {
  //Add Book	
  StoreScreen.cartScreen.setVisible(false);
  AddBookscreen addBookscreen=new AddBookscreen();
  addBookscreen.setSize(934,595);
}

@FXML
void AddCDPressed(ActionEvent event) {
	//Add CD
	StoreScreen.cartScreen.setVisible(false);
	AddCDscreen addCDscreen=new AddCDscreen();
	addCDscreen.setSize(934,595);

}

@FXML
void AddDVDPressed(ActionEvent event) {
	//Add DVD
		StoreScreen.cartScreen.setVisible(false);
		AddDVDscreen addDVDscreen=new AddDVDscreen();
		addDVDscreen.setSize(934,595);

}

@FXML
void ViewStorePressed(ActionEvent event) {
	  new StoreScreen(Aims.store);
	  StoreScreen.cartScreen.setVisible(false);


}

}
	

