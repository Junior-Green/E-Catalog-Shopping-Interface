package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Optional;
import application.Categories.Item;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.stage.FileChooser.ExtensionFilter;

public class BillingInfo extends Stage{
	DecimalFormat df = new DecimalFormat("$,##0.00");
	double subtotal = 0d; //Stores subtotal
	double tax = 0d;//Stores tax from subtotal value
					
	//Stores years for combo box selection
	int yearCount = 2020; 
	Integer[] years = new Integer[80];
	
	FileChooser save = new FileChooser(); //Initialize file chooser
	Stage primaryStage;
	TextField[] fields = new TextField[10]; //Intializes an array of text fields
	public BillingInfo(Stage ps) throws FileNotFoundException
	{
		save.getExtensionFilters().add(new ExtensionFilter("Word Document", "*.doc"));
		
		for(Item s : DashBoard.getItems())//Calculates subtotal from all Items in Array list
		{
			subtotal += s.getPrice();
		}
		tax = subtotal * 0.13;
		
		//Combo mox which lets user choose the month of expiration
		ComboBox<String> month = new ComboBox<String>();
		month.getItems().addAll("01","02","03","04","05","06","07","08","09","10","11","12");
		month.setPrefWidth(80);
		month.setPromptText("Month");
		month.setVisibleRowCount(3);
		
		//Combo box which lets user choose the province
		ComboBox<String> provinces = new ComboBox<String>();
		provinces.getItems().addAll("NL","PE","NS","NB","QC","ON","MB","SK","AB","BC","YT","NT","NU");
		provinces.setPrefWidth(100);
		provinces.setPromptText("Province");
		provinces.setVisibleRowCount(3);
		
		for(int i = 0; i < years.length; i++)
		{
			years[i] = yearCount;
			yearCount++;
		}
		//Combo box which lets user choose the year of expiration
		ComboBox<Integer> year = new ComboBox<Integer>();
		year.getItems().addAll(years);
		year.setPrefWidth(80);
		year.setPromptText("Year");
		year.setVisibleRowCount(3);
		
		//Initialize an error alert which is used if any text fields weren't filled out
		Alert error = new Alert(AlertType.ERROR);
		error.setTitle("Invalid Information");
		error.setHeaderText(null);
		error.setContentText("All text fields are required to be filled out");
		
		//Button used when user is ready to checkout after all fields have been filled out
		Button enter = new Button("CHECKOUT");
		enter.setPrefSize(100,40);
		enter.setStyle("-fx-text-fill: white; -fx-control-inner-background: orange; -fx-font-weight: bold;");
		enter.setBackground(new Background(new BackgroundFill(Color.ORANGE, new CornerRadii(5), Insets.EMPTY)));
		enter.setOnMouseEntered(e -> {		
			this.getScene().setCursor(Cursor.HAND);
		});
		enter.setOnMouseExited(e -> {
			this.getScene().setCursor(Cursor.DEFAULT);
		});
		enter.setOnAction(e -> {
			Boolean okay = true;
			for(int i = 0; i < fields.length; i++) //Checks to see if every text field has been filled out
			{
				if(i == 5)
				continue;
				else if(fields[i].getText().equals(""))
				{
					error.show();
					fields[i].requestFocus();
					okay = false;
					break;
				}
			}
			if(okay)
			{
				//If text field does not match required pattern show alert
				if(!fields[2].getText().matches("\\d{4}-\\d{4}-\\d{4}-\\d{4}"))
				{
	
					Alert wrong = new Alert(AlertType.ERROR);
					wrong.setTitle("Incorrect Information");
					wrong.setHeaderText(null);
					wrong.setContentText("Invalid card number");
					wrong.show();
					fields[2].requestFocus();					
				}
				//If text field does not match required pattern show alert
				else if(!fields[3].getText().matches("\\d{3}"))
				{
					Alert wrong = new Alert(AlertType.ERROR);
					wrong.setTitle("Incorrect Information");
					wrong.setHeaderText(null);
					wrong.setContentText("Wrong CVV Number");
					wrong.show();
					fields[3].requestFocus();
				}
				//If combo box is not filled out
				else if (month.getValue() == null || year.getValue() == null)
				{
					Alert wrong = new Alert(AlertType.ERROR);
					wrong.setTitle("Missing Information");
					wrong.setHeaderText(null);
					wrong.setContentText("Please fill out expiry date");
					wrong.show();
				}
				//If text field does not match required patter show alert
				else if(!fields[9].getText().matches("[A-Z]{1}\\d{1}[A-Z]{1}\\s\\d{1}[A-Z]{1}\\d{1}"))
				{
					Alert wrong = new Alert(AlertType.ERROR);
					wrong.setTitle("Incorrect Information");
					wrong.setHeaderText(null);
					wrong.setContentText("Incorrect postal code format");
					wrong.show();
					fields[9].requestFocus();
				}
				//If combo box is not filled out
				else if (provinces.getValue() == null)
				{
					Alert wrong = new Alert(AlertType.ERROR);
					wrong.setTitle("Missing Information");
					wrong.setHeaderText(null);
					wrong.setContentText("Please choose a province");
					wrong.show();
				}
				//If text field does not match required pattern
				else if(!fields[6].getText().matches("\\w+@\\w+[.]{1}\\w{2,}"))
				{
					Alert wrong = new Alert(AlertType.ERROR);
					wrong.setTitle("Invalid Information");
					wrong.setHeaderText(null);
					wrong.setContentText("Please enter in a valid email address.");
					wrong.show();
					fields[6].requestFocus();
				}
				//If text field does not match required pattern show alert
				else if(!fields[7].getText().matches("\\d{3}-\\d{3}-\\d{4}"))
				{
					Alert wrong = new Alert(AlertType.ERROR);
					wrong.setTitle("Incorrect Information");
					wrong.setHeaderText(null);
					wrong.setContentText("Please enter in a valid phone number");
					wrong.show();
					fields[7].requestFocus();
				}
				else //If none of the above errors occur proceed with payment
				{		
					Alert saveA = new Alert(AlertType.INFORMATION);
					saveA.setGraphic(new ImageView(new Image("file:checkmark.png")));
					saveA.setTitle("Payment Successful");
					saveA.setHeaderText(null);
					saveA.setContentText("Please choose a location to save your invoice");
					saveA.show();
					saveA.setOnCloseRequest(e1 -> {

						try //Gets file to write to and writes reciept
						{
							File saveTo = save.showSaveDialog(this);
							if(saveTo != null)
							{
								BufferedWriter out = new BufferedWriter(new FileWriter(saveTo));							
								out.write("ORDER SUMMARY");
								out.newLine();
								out.write(String.format("%-30s%s", "Item(s) Subtotal:", "CDN" + df.format(subtotal)));
								out.newLine();
								out.write(String.format("%-30s%s", "Shipping & Handling:", "FREE"));
								out.newLine();
								out.newLine();
								out.write(String.format("%-30s%s", "Total before tax:", "CDN" + df.format(subtotal)));
								out.newLine();
								out.write(String.format("%-30s%s", "Estimated HST:", "CDN" + df.format(tax)));
								out.newLine();
								out.newLine();
								out.write(String.format("%-30s%s", "Grand Total:", "CDN" + df.format(tax + subtotal)));
								out.newLine();
								out.newLine();
								out.write("SHIPPING ADDRESS");
								out.newLine();
								out.write(fields[0].getText() + " " + fields[1].getText());
								out.newLine();
								out.write(fields[4].getText());
								out.newLine();
								if(!fields[5].getText().isEmpty())
								{
									out.write(fields[5].getText());
									out.newLine();
								}
								out.write(fields[8].getText() + "," + provinces.getValue() + " " + fields[9].getText());
								out.newLine();
								out.write("Canada");
								out.newLine();
								out.newLine();
								out.write("CONTACT INFORMATION");
								out.newLine();
								out.write(fields[6].getText());
								out.newLine();
								out.write(fields[7].getText());
								out.close();
								
								Alert thankYou = new Alert(AlertType.INFORMATION); //Alert thanking user
								thankYou.setTitle("Thank You!");
								thankYou.setHeaderText(null);
								thankYou.setContentText("Thank you for shopping with E-Catalog");
								thankYou.showAndWait();
								
								
								DashBoard.getItems().clear();
								
								new DashBoard(this);
								hide();
							}
						} 
						catch(FileNotFoundException e0) //Catches exception
						{
							Alert openRN = new Alert(AlertType.ERROR);
							openRN.setTitle("Error");
							openRN.setHeaderText(null);
							openRN.setContentText("The file you are trying to reference is being used by another source. Please close before exporting data to file");
							openRN.show();
						}
						catch (IOException e3) //Catches exception
						{
							e3.printStackTrace();
						}	
					});
					
					
				}
			}
		});		
		
		Label prompt = new Label("Expiry Date:");
		prompt.setFont(Font.loadFont(new FileInputStream(new File("font.ttf")), 18));
		prompt.setAlignment(Pos.CENTER_LEFT);
		HBox hbox = new HBox(15); //HBox holding credit card expiration nodes
		hbox.setAlignment(Pos.CENTER_LEFT);
		hbox.getChildren().addAll(prompt,month,year);
		
		//Displays payment amount
		Label transaction = new Label("Subtotal: " + df.format(subtotal) +"\nHST: " + df.format(tax));		
		Label total = new Label("Total: " + df.format(subtotal + tax));
		Label seperator = new Label("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
		seperator.setUnderline(true);
		seperator.setAlignment(Pos.TOP_LEFT);
		
		VBox vbox = new VBox(5); //Holding all nodes which displays payment amount
		vbox.setAlignment(Pos.CENTER_LEFT);
		vbox.getChildren().addAll(transaction,seperator,total);
		
		primaryStage = ps;	
		
		try //Imports and sets all fonts
		{
			transaction.setFont(Font.loadFont(new FileInputStream(new File("font.ttf")), 24));
			seperator.setFont(Font.loadFont(new FileInputStream(new File("font.ttf")), 2));
			total.setFont(Font.loadFont(new FileInputStream(new File("font.ttf")), 24));
		} 
		catch (FileNotFoundException e1) 
		{
			e1.printStackTrace();
		}
		for(int i = 0; i < fields.length; i++)//Initialize all text fields
		{
			fields[i] = new TextField();
			fields[i].setPrefSize(200, 40);//Sets base dimensions
		}
		
		HBox hbox1 = new HBox(20);//Holding nodes which gets Cardholders name
		hbox1.setAlignment(Pos.CENTER_LEFT);
		hbox1.getChildren().addAll(fields[0], fields[1]);
		
		HBox hbox2 = new HBox(20);
		hbox2.getChildren().addAll(fields[8], fields[9],provinces);
		hbox2.setAlignment(Pos.CENTER_LEFT);
		
		//Sets prompt text for all text fields
		fields[0].setPromptText("Cardholder First Name");
		fields[1].setPromptText("Cardholder Last Name");
		fields[2].setPromptText("Card Number (XXXX-XXXX-XXXX-XXXX)");
		fields[3].setPromptText("CVV (XXX)");
		fields[4].setPromptText("Billing Address Line 1");
		fields[5].setPromptText("Billing Address Line 2");
		fields[6].setPromptText("Email Address");
		fields[7].setPromptText("Phone Number (XXX-XXX-XXXX)");
		fields[8].setPromptText("City");
		fields[9].setPromptText("Postal Code (XXX XXX)");
		
		//Custom dimension adjustment
		fields[0].setPrefWidth(225);
		fields[1].setPrefWidth(225);
		fields[2].setPrefSize(470, 40);
		fields[3].setPrefSize(90, 40);
		fields[4].setPrefWidth(470);
		fields[5].setPrefWidth(470);
		fields[6].setPrefWidth(375);
		
		//Subtitle
		Label billing = new Label("Billing Information");
		billing.setAlignment(Pos.CENTER_LEFT);
		billing.getStyleClass().add("slogan");
		
		//Main GridPane
		GridPane root = new GridPane();
		root.setVgap(15);
		root.setHgap(20);
		root.setAlignment(Pos.TOP_LEFT);
		//root.setGridLinesVisible(true);
		root.setPadding(new Insets(40,40,40,40));
		root.add(vbox, 0, 0, 1, 1);
		root.add(new ImageView(new Image("file:payment.png")), 1, 0, 1, 1);
		root.add(billing, 0, 1,2,1);
		root.add(hbox1, 0, 2, 1, 1);
		root.add(fields[2], 0, 3, 2, 1);
		root.add(hbox, 0, 4,2,1);
		root.add(fields[3], 1, 3, 1, 1);
		root.add(hbox2, 0, 5, 2, 1);
		root.add(fields[4], 0, 6, 2, 1);
		root.add(fields[5], 0, 7, 2, 1);
		root.add(fields[6], 0, 8, 1, 1);
		root.add(fields[7],1, 8, 1, 1);
		root.add(enter, 0, 9, 1, 1);
		
		//Formatting
		GridPane.setFillWidth(fields[0], false);
		GridPane.setFillWidth(fields[1], false);
		GridPane.setFillWidth(fields[3], false);
		GridPane.setFillWidth(fields[2], false);
		GridPane.setFillWidth(fields[4], false);
		GridPane.setFillWidth(fields[5], false);
		GridPane.setFillWidth(fields[6], true);
		GridPane.setFillWidth(fields[7], false);
		GridPane.setHalignment(hbox, HPos.LEFT);
		GridPane.setFillWidth(fields[1], false);
		GridPane.setHalignment(enter, HPos.LEFT);
		GridPane.setValignment(enter, VPos.BOTTOM);		
		GridPane.setHalignment(fields[3], HPos.LEFT);	
		GridPane.setValignment(total, VPos.TOP);		
		root.getStyleClass().add("gridPaneBorder");
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		setTitle("Billing Info");
		getIcons().add(new Image("file:taskbar_logo.png"));
		setScene(scene);
		show();
		setResizable(false);
		setOnCloseRequest(new EventHandler<WindowEvent>() 
		{
			public void handle(WindowEvent e) {			
				
				  Alert cancel = new Alert(AlertType.CONFIRMATION);
				  cancel.setTitle("Billing Info"); cancel.setHeaderText(null);
				  cancel.setContentText("Cancel payment process?");
				  cancel.getButtonTypes().clear();
				  cancel.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
				  Optional<ButtonType> result = cancel.showAndWait();
				  
				  if(result.get() == ButtonType.YES) { hide(); new ShoppingCart(primaryStage);
				  } else { e.consume(); }
				 
			}
		});
	}

}
