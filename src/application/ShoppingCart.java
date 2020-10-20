package application;

//GUI from Fortnite Tournament Program
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Optional;
import application.Categories.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ShoppingCart extends Stage{

	private Button btnRemove, btnCheckOut, btnSort; //Declare all buttons
	private ObservableList<Item> list; //Declare Observable list
	private ListView<Item> listview; //Declare list view
	private Alert alert; //Declare alert
	private Stage primaryStage; 

	public ShoppingCart(Stage ps) {

		Alert error = new Alert(AlertType.ERROR);
		error.setHeaderText(null);
		error.setTitle("Error");
		
		alert = new Alert(AlertType.NONE);
		alert.setHeaderText(null);

		primaryStage = ps;

		list = FXCollections.observableArrayList(DashBoard.getItems()); //Gets the Array list of Items and converts to Observable list
		listview = new ListView<Item>();
		listview.setPrefSize(700, 400);
		listview.setItems(list);
		listview.setStyle("-fx-font-family: Consolas"); //Sets mono-spaced font
		
		for(Item s : list)
		{
			s.setName(s.getName().replaceAll("\n", " "));
		}
		
		btnRemove = new Button("REMOVE");
		btnRemove.setPrefSize(100, 40);
		btnRemove.setOnAction(e -> {		

			//If no item is selected alert user 
			if(listview.getSelectionModel().getSelectedItem() == null) 
			{
				error.setContentText("No item selected.");
				error.showAndWait();
			}
			else //Removes selected item
			{
				DashBoard.getItems().remove(listview.getSelectionModel().getSelectedItem());
				list.remove(listview.getSelectionModel().getSelectedItem());					
			}
		});

		btnCheckOut = new Button("CHECKOUT");	
		btnCheckOut.setPrefSize(100, 40);
		btnCheckOut.setOnAction(e -> //Shows payment total and redirects to billing screen if user chooses to
		{
			if(list.isEmpty()) //Shows alert if there are no items in the cart
			{
				Alert errorA = new Alert(AlertType.ERROR);
				errorA.setHeaderText(null);
				errorA.setTitle("Shopping Cart Empty");
				errorA.setContentText("Your shopping cart is empty please select an item first.");
				errorA.show();
			}
			else
			{
				DecimalFormat df = new DecimalFormat("$,##0.00");
				double subtotal = 0;
				double tax = 0;
				
				for(Item s : DashBoard.getItems())
				{
					subtotal += s.getPrice();
				}
				tax = subtotal * 0.13;
				Alert checkOut = new Alert(AlertType.CONFIRMATION);
				checkOut.setTitle("Checkout?");
				checkOut.setHeaderText(null);
				checkOut.getButtonTypes().clear();
				checkOut.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
				checkOut.setContentText("Subtotal: " + df.format(subtotal) +"\nHST: " + df.format(tax) + "\n-----------------------------------------------"
						+ "\nTotal: " + df.format(subtotal + tax) +"\nCheckout?");
				Optional<ButtonType> result = checkOut.showAndWait();
				
				if(result.get() == ButtonType.YES)
				{
					try {
						new BillingInfo(primaryStage);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					hide();
				}
				else 
				{
					e.consume();
				}
			}
		});

		//Sorts all items in the Array by price or name based on what user selects
		btnSort = new Button("SORT");
		btnSort.setPrefSize(100, 40);
		btnSort.setOnAction(e -> {	
			ButtonType btnName = new ButtonType("Name");
			ButtonType btnRating = new ButtonType("Price");
			Alert sort = new Alert(AlertType.CONFIRMATION);
			sort.setHeaderText(null);
			sort.setContentText("How would you like the list to be sorted?");
			sort.setTitle("Sort List");
			sort.getButtonTypes().clear();
			sort.getButtonTypes().addAll(btnName, btnRating);
			
			Optional<ButtonType> result = sort.showAndWait();
			
			//Sorts array list of players based on what user chooses
			if(result.get() == btnName)
			{
				Item.sort = Item.SORT_BY_NAME;
				Collections.sort(list);
			}
			else
			{
				Item.sort = Item.SORT_BY_PRICE;
				Collections.sort(list, Collections.reverseOrder());
			}	
		});

		TitledPane listPane = new TitledPane(String.format("%-65s%-1s", "NAME","PRICE"), listview);
		listPane.setFont(Font.font("Consolas", FontWeight.BOLD, 16));
		listPane.setCollapsible(false);

		FlowPane root = new FlowPane();
		root.setStyle("-fx-background-color: orange");
		root.setPadding(new Insets(20, 10, 20, 10));
		root.setHgap(10);
		root.setVgap(15);
		root.setAlignment(Pos.TOP_CENTER);
		root.getChildren().addAll(listPane, btnRemove, btnCheckOut, btnSort);

		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		setResizable(false);
		getIcons().add(new Image("file:taskbar_logo.png"));
		setTitle("Cart");
		setScene(scene);
		show();
		setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent e) {
				primaryStage.show();
			}
		});
}
}
