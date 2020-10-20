package application.Categories;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import application.DashBoard;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Books extends Stage{

	GridPane root; //Declare GridPane
	ImageView[] images;
	private Stage primaryStage;
	public Books(Stage ps) throws FileNotFoundException
	{		
		//Initialize ImageViews used for the Slideshow object
		images = new ImageView[] {new ImageView(new Image("file:books/slide1.png")), new ImageView(new Image("file:books/slide2.png"))
				,new ImageView(new Image("file:books/slide3.jpg")),new ImageView(new Image("file:books/slide4.jpg"))};
		
		Item[] items = new Item[12]; //Declare and initialize and array of Items
		
		SlideShow slideShow = new SlideShow(images); //Declare and initialize a Slideshow object
		root = new GridPane();
		
		Label title = new Label("Books"); //Label used for title
		title.setFont(Font.loadFont(new FileInputStream(new File("font.ttf")), 80));
		title.setAlignment(Pos.CENTER);
		title.setTextFill(Color.ORANGE);
		ScrollPane sp = new ScrollPane(root);
		sp.setPrefHeight(800);
		sp.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		sp.setHbarPolicy(ScrollBarPolicy.NEVER);
		
		Scene scene = new Scene(sp,1000,800);
		primaryStage = ps;
		//All items being displayed
		items[0] = new Item(new Image("file:books/hunger_games_trilogy.png"), "Hunger Games Trilogy", "34.99", scene);
		items[1] = new Item(new Image("file:books/lord_of_the_rings_trilogy.png"), "The Hobbit + Lord of the Rings Trilogy", "54.99", scene);
		items[2] = new Item(new Image("file:books/harry_potter.png"), "Harry Potter Set (1-7)", "64.99", scene);
		items[3] = new Item(new Image("file:books/13_reason_why.png"), "13 Reasons Why The Novel", "19.99", scene);
		items[4] = new Item(new Image("file:books/fahrenheit_451.jpg"), "Fahrenheit 451", "19.99", scene);
		items[5] = new Item(new Image("file:books/its_kind_of_a_funny_story.jpg"), "It's Kind of Funny a Story", "19.99", scene);
		items[6] = new Item(new Image("file:books/lord_of_the_flies.jpg"), "Lord of The Flies", "19.99", scene);
		items[7] = new Item(new Image("file:books/speak.jpg"), "Speak", "21.79", scene);
		items[8] = new Item(new Image("file:books/stargirl.jpg"), "Stargirl", "19.99", scene);
		items[9] = new Item(new Image("file:books/the_call_of_the_wild.jpg"), "The Call of The Wild", "19.99", scene);
		items[10] = new Item(new Image("file:books/the_fault_in_our_stars.jpg"), "The Fault in Our Stars", "21.79", scene);
		items[11] = new Item(new Image("file:books/the_giver.jpg"), "The Giver", "21.99", scene);
			
		//GridPane formatting
		root.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(20), Insets.EMPTY)));
		root.setVgap(20);
		root.setHgap(20);
		root.setAlignment(Pos.TOP_CENTER);
		root.setPadding(new Insets(10,10,10,10));
		root.add(title, 0, 0, 2, 1);
		root.add(slideShow.getSlide(), 0, 1, 2, 1);
		root.add(items[0].getNode(), 0, 2, 1, 1);
		root.add(items[1].getNode(), 1, 2, 1, 1);
		root.add(items[2].getNode(), 0, 3, 1, 1);
		root.add(items[3].getNode(), 1, 7, 1, 1);
		root.add(items[4].getNode(), 1, 3, 1, 1);
		root.add(items[5].getNode(), 0, 4, 1, 1);
		root.add(items[6].getNode(), 1, 4, 1, 1);
		root.add(items[7].getNode(), 0, 5, 1, 1);
		root.add(items[8].getNode(), 1, 5, 1, 1);
		root.add(items[9].getNode(), 0, 6, 1, 1);
		root.add(items[10].getNode(), 1, 6, 1, 1);
		root.add(items[11].getNode(), 0, 7, 1, 1);
		
		GridPane.setHalignment(title, HPos.CENTER);
	
		
		setTitle("Books");
		getIcons().add(new Image("file:taskbar_logo.png"));
		setScene(scene);
		show();
		setResizable(false);
		setTitle("Books");
		setOnCloseRequest(new EventHandler<WindowEvent>() //Go back to DashBoard if closed
		{
			public void handle(WindowEvent e) {			
				new DashBoard(primaryStage);
				primaryStage.hide();
			}
		});
	}
	
}
