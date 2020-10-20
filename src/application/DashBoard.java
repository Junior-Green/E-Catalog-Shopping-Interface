package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import application.Categories.*;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class DashBoard extends Stage{

	Stage primaryStage;
	ImageView help,logOut,cart;
	private static ArrayList<Item> items = new ArrayList<Item>();
	public DashBoard(Stage ps)
	{
		
		primaryStage = ps;
		//Properties for each category button
		Color[] colors = new Color[] {Color.RED, Color.DARKGRAY, Color.GREEN, Color.PURPLE, Color.SANDYBROWN, Color.MEDIUMSEAGREEN, Color.LIGHTSALMON, Color.TURQUOISE};
		Label[] categories = new Label[8];
		Image[] logos = new Image[] {new Image("file:dashboard/books_icon.png"),new Image("file:dashboard/cellphone_icon.png"),new Image("file:dashboard/electronics_icon.png"),
				new Image("file:dashboard/gaming_icon.png"),new Image("file:dashboard/health_icon.png"),new Image("file:dashboard/movies_icon.png"),
				new Image("file:dashboard/office_icon.png"),new Image("file:dashboard/sports_icon.png"),};
		String[] logoNames = new String[] {"Books", "Cellphones", "Electronics", "Gaming", "Health Essentials", "Movies", "Office Supplies", "Sports/Equipment"};
		
		
		//Intialize and set properties for each button (Label)
		for(int i = 0; i < categories.length; i++)
		{
			categories[i] = new Label(logoNames[i], new ImageView(logos[i]));
			categories[i].setTextFill(Color.BLACK);
			categories[i].setContentDisplay(ContentDisplay.TOP);
			categories[i].setAlignment(Pos.CENTER);
			categories[i].setBackground(new Background(new BackgroundFill(colors[i], new CornerRadii(10), Insets.EMPTY)));
			categories[i].setPrefSize(235, 235);
			try {
				categories[i].setFont(Font.loadFont(new FileInputStream(new File("font.ttf")), 20));
			} 
			catch (FileNotFoundException e1) {e1.printStackTrace();}
			categories[i].setStyle("-fx-border-color: black; -fx-border-width: 4pt; ");
			categories[i].setOnMouseEntered(e -> {
				this.getScene().setCursor(Cursor.HAND);
			});
			categories[i].setOnMouseExited(e -> {
				this.getScene().setCursor(Cursor.DEFAULT);
			});
		} 
		//Redirects to respective category if clicked
		categories[0].setOnMouseClicked(e -> 
		{
			this.hide();
			try 
			{
				new Books(this);
			} 
			catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		categories[1].setOnMouseClicked(e -> 
		{
			this.hide();
			try 
			{
				new Cellphones(this);
			} 
			catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		categories[2].setOnMouseClicked(e -> 
		{
			this.hide();
			try 
			{
				new Electronics(this);
			} 
			catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		categories[3].setOnMouseClicked(e -> 
		{
			this.hide();
			try 
			{
				new Gaming(this);
			} 
			catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		categories[4].setOnMouseClicked(e -> 
		{
			this.hide();
			try 
			{
				new HealthEssentials(this);
			} 
			catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		categories[5].setOnMouseClicked(e -> 
		{
			this.hide();
			try 
			{
				new Movies(this);
			} 
			catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		categories[6].setOnMouseClicked(e -> 
		{
			this.hide();
			try 
			{
				new OfficeSupplies(this);
			} 
			catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		categories[7].setOnMouseClicked(e -> 
		{
			this.hide();
			try 
			{
				new Sports(this);
			} 
			catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		
		Label greet = new Label("Signed In: " + Main.curentUser.getFirstName() + " " + Main.curentUser.getLastName());
		greet.setPrefWidth(360);
		greet.setAlignment(Pos.BASELINE_LEFT);;
		try 
		{
			greet.setFont(Font.loadFont(new FileInputStream(new File("font.ttf")), 18));
		} 
		catch (FileNotFoundException e1) 
		{
			e1.printStackTrace();
		}
		
		//Intialize ImageView which instructs users on navigation
		help = new ImageView(new Image("file:dashboard/help.png"));
		help.setOnMouseEntered(e -> {
			
			this.getScene().setCursor(Cursor.HAND);
		});
		help.setOnMouseExited(e -> {
			this.getScene().setCursor(Cursor.DEFAULT);
		});
		help.setOnMouseClicked(e -> {
			
			Alert info = new Alert(AlertType.INFORMATION);
			info.setTitle("Help");
			info.setHeaderText(null);
			info.setContentText("Click button beside Help button to View Cart\nClick the exit button to log out and return back to the sign in screen");
			info.show();
		});
		//Initalize ImageView which logs the user out and returns back to the log in screen
		logOut = new ImageView(new Image("file:dashboard/sign_out.png"));
		logOut.setOnMouseEntered(e -> {
			
			this.getScene().setCursor(Cursor.HAND);
		});
		logOut.setOnMouseExited(e -> {
			this.getScene().setCursor(Cursor.DEFAULT);
		});
		logOut.setOnMouseClicked(e -> {
			
			Alert quit = new Alert(AlertType.CONFIRMATION);
			quit.getButtonTypes().clear();
			quit.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
			quit.setTitle("Sign Out?");
			quit.setHeaderText(null);
			quit.setContentText("Sign Out? You will be brought back to the log in screen.");
			Optional<ButtonType> result = quit.showAndWait();
			
			if(result.get() == ButtonType.YES)
			{
				this.hide();
				Main.mainStage.show();
			}
			else
				e.consume();
			
		});
		//Initialize a ImageView object which redirecys user to view their cart and proceed with the payment process
		cart = new ImageView(new Image("file:dashboard/shopping_cart.png"));
		cart.setOnMouseEntered(e -> {
			
			this.getScene().setCursor(Cursor.HAND);
		});
		cart.setOnMouseExited(e -> {
			this.getScene().setCursor(Cursor.DEFAULT);
		});
		cart.setOnMouseClicked(e -> {
			this.hide();
			new ShoppingCart(this);
		});
		
		//GridPane with all Categories
		GridPane select = new GridPane();
		select.setHgap(10);
		select.setVgap(10);
		select.setAlignment(Pos.CENTER);
		select.setPadding(new Insets(10,10,10,10));
		select.add(categories[0], 0, 0, 1, 1);
		select.add(categories[1], 1, 0, 1, 1);
		select.add(categories[2], 0, 1, 1, 1);
		select.add(categories[3], 1, 1, 1, 1);
		select.add(categories[4], 0, 2, 1, 1);
		select.add(categories[5], 1, 2, 1, 1);
		select.add(categories[6], 0, 3, 1, 1);
		select.add(categories[7], 1, 3, 1, 1);
		
		//ScrollPane which hold "select" GridPane
		ScrollPane sp = new ScrollPane(select);;
		sp.setPrefHeight(600);
		sp.setVbarPolicy(ScrollBarPolicy.NEVER);
		sp.setHbarPolicy(ScrollBarPolicy.NEVER);
		
		//intialize BackGroundImage object
		BackgroundImage backDrop = new BackgroundImage(new Image("file:dashboard/tabback.jpg"), null, null, null, null);
		
		//Main GridPane
		GridPane root = new GridPane();
		root.setBackground(new Background(backDrop));
		root.setMaxWidth(500);
		root.setHgap(10);
		root.add(greet, 0, 0, 1, 1);
		root.add(help, 1, 0, 1, 1);
		root.add(cart, 2, 0, 1, 1);
		root.add(logOut, 3, 0, 1, 1);
		root.add(sp, 0, 1, 4, 1);
		
		GridPane.setValignment(greet, VPos.BOTTOM);
		GridPane.setFillHeight(greet, true);
		GridPane.setFillHeight(sp, true);
		GridPane.setFillWidth(sp, true);
		GridPane.setFillWidth(greet, true);
		Scene scene = new Scene(root);
		
		setTitle("E-Catalog");
		getIcons().add(new Image("file:taskbar_logo.png"));
		setScene(scene);
		show();
		setTitle("Home");
		setOnCloseRequest(new EventHandler<WindowEvent>() 
		{
			public void handle(WindowEvent e) {	//Save all new/existing users in accounts.txt file then terminate		 
			
				try
				{
					BufferedWriter writer = new BufferedWriter(new FileWriter(Main.getAccountFile()));
					
					for(int i  = 0; i < Main.getUser().size(); i++)
					{
						writer.write(Main.getUser().get(i).toFile());
						writer.newLine();
					}
					writer.close();
					Platform.exit();
					System.exit(0);
				}
				catch(FileNotFoundException e1)
				{
					e1.printStackTrace();
				}
				catch(IOException e2)
				{
					e2.printStackTrace();				
				}
			}
		});	
	}
	public static ArrayList<Item> getItems()
	{
		return items;	
	}
}
