package application.Categories;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;

import application.DashBoard;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class Item implements Comparable<Item>{
	DecimalFormat df = new DecimalFormat("$,##0.00");//Declare and initialize DecimalFormat object
	//Declare variables
	Image image;
	Label name;
	Button add;
	String itemName;
	double amount;
	Label price;
	GridPane item;
	//Constants used for sorting
	 public final static int SORT_BY_NAME = 0;
	 public final static int SORT_BY_PRICE = 1;
	 public static int sort = 0;
	
	public Item(Image image, String name, String price, Scene scene) throws FileNotFoundException
	{	
		itemName = name;
		amount = Double.parseDouble(price);
		Label seperator = new Label();
		seperator.setAlignment(Pos.CENTER);
		seperator.setGraphic(new ImageView(new Image("file:line_seperator.png")));
		
		add = new Button("Add to cart");
		add.setPrefSize(450, 50);
		add.setStyle("-fx-text-fill: white; -fx-control-inner-background: orange; -fx-font-weight: bold;");
		add.setBackground(new Background(new BackgroundFill(Color.ORANGE, new CornerRadii(20), Insets.EMPTY)));
		add.setOnAction(e -> {//Show alert and add Item object to array list of objects
			Alert added = new Alert(AlertType.INFORMATION);
			added.setTitle("Item Added");
			added.setHeaderText(null);
			added.setContentText("Added to Cart");
			added.show();
			DashBoard.getItems().add(this);
		});
		add.setOnMouseEntered(e -> {
			scene.setCursor(Cursor.HAND);
		});
		add.setOnMouseExited(e -> {
			scene.setCursor(Cursor.DEFAULT);
		});;
		this.price = new Label("$" + price);//Initialize Label object and set its properties	
		this.price.setTextFill(Color.ORANGE);
		this.price.setFont(Font.loadFont(new FileInputStream(new File("font.ttf")), 22));
		this.name = new Label(name);
		this.name.setPrefWidth(480);
		this.name.setPrefHeight(490);
		this.name.setTextFill(Color.ORANGE);
		this.name.setGraphic(new ImageView(image));
		this.name.setTextAlignment(TextAlignment.CENTER);
		this.name.setAlignment(Pos.BOTTOM_CENTER);
		this.name.setContentDisplay(ContentDisplay.TOP);
		this.name.setFont(Font.loadFont(new FileInputStream(new File("font.ttf")), 28));
		item = new GridPane(); //Initialize GridPane object and set its properties
		//item.setGridLinesVisible(true);
		item.setBackground(new Background(new BackgroundFill(Color.WHITE, null, Insets.EMPTY)));
		//Add nodes to GridPane
		item.add(this.name, 0, 0, 2, 1);
		item.add(this.price, 0, 1, 2, 1);
		item.add(add, 0, 2, 2, 1);
		item.add(seperator, 0, 3, 2, 1);
		item.setPrefWidth(480);
		item.setAlignment(Pos.CENTER);
		item.setVgap(10);	
		
		//GridPane adjustment
		GridPane.setFillWidth(add, true);
		GridPane.setHalignment(add, HPos.CENTER);
		GridPane.setValignment(add, VPos.CENTER);
		GridPane.setHalignment(this.price, HPos.CENTER);
		GridPane.setValignment(this.price, VPos.CENTER);
		GridPane.setHalignment(seperator, HPos.CENTER);
		GridPane.setValignment(seperator, VPos.CENTER);
		GridPane.setHalignment(this.name, HPos.CENTER);
		GridPane.setValignment(this.name, VPos.CENTER);
	}
	
	//@return String
	public String getName()
	{
		return itemName;
	}
	//@return String
	public double getPrice()
	{
		return amount;
	}
	//@return GridPane
	public GridPane getNode()
	{
		return item;
	}
	//@param String
	public void setName(String s)
	{
		itemName = s;
	}
	/*Takes the itemName and the Item's price
	 * and formats it to be outputted
	 * to a ListView
	 * 
	 * @return String
	 */
	public String toString()
	{
		
		String converted = df.format(amount);
		return String.format("%-65s%-1s", itemName, converted);	
	}

	@Override
	public int compareTo(Item s) {
		
		int comparison = 0;
		if(sort == 0)
			 comparison = itemName.compareToIgnoreCase(s.getName());
		else if(sort == 1)
		{
			 comparison = Double.compare(amount, s.getPrice());
			 
			 if(comparison == 0)
				 comparison = s.getName().compareToIgnoreCase(itemName);
		}
		return comparison;
	}
}
