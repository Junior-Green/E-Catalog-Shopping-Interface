package application.Categories;
//Please refer to the Books class for comment code
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

public class Movies extends Stage{
	
	GridPane root;
	ImageView[] images;
	private Stage primaryStage;
	public Movies(Stage ps) throws FileNotFoundException
	{		
		
		images = new ImageView[]{new ImageView(new Image("file:movies/slide1.jpg")), new ImageView(new Image("file:movies/slide2.jpg"))
				,new ImageView(new Image("file:movies/slide3.jpg")),new ImageView(new Image("file:movies/slide4.jpg"))};
		
		Item[] items = new Item[18];
		
		SlideShow slideShow = new SlideShow(images);
		root = new GridPane();
		
		Label title = new Label("Movies");
		title.setFont(Font.loadFont(new FileInputStream(new File("font.ttf")), 80));
		title.setAlignment(Pos.CENTER);
		title.setTextFill(Color.ORANGE);
		ScrollPane sp = new ScrollPane(root);
		sp.setPrefHeight(800);
		sp.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		sp.setHbarPolicy(ScrollBarPolicy.NEVER);
		
		Scene scene = new Scene(sp,1000,800);
		primaryStage = ps;
		
		items[0] = new Item(new Image("file:movies/avengers_end_game.jpg"), "Avengers: End Game", "19.99", scene);
		items[1] = new Item(new Image("file:movies/avengers_infinty_war.jpg"), "Avengers: Infinity War", "17.99", scene);
		items[2] = new Item(new Image("file:movies/captain_marvel.jpg"), "Captain Marvel", "19.99", scene);
		items[3] = new Item(new Image("file:movies/furious_7.jpg"), "Furious 7", "12.99", scene);
		items[4] = new Item(new Image("file:movies/it_chapter_two.jpg"), "IT: Chapter II", "19.99", scene);
		items[5] = new Item(new Image("file:movies/joker_blu_ray.jpg"), "Joker", "21.99", scene);
		items[6] = new Item(new Image("file:movies/maleficent_blu_ray.jpg"), "Maleficent", "19.99", scene);
		items[7] = new Item(new Image("file:movies/shazam.jpg"), "Shazam", "17.99", scene);
		items[8] = new Item(new Image("file:movies/spider_man_homecoming.jpg"), "SpiderMan: Homecoming", "19.99", scene);
		items[9] = new Item(new Image("file:movies/the_lion_king.jpg"), "The Lion King", "20.99", scene);
		items[10] = new Item(new Image("file:movies/venom.jpeg"), "Venom", "16.49", scene);
		
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
		root.add(items[3].getNode(), 0, 7, 1, 1);
		root.add(items[4].getNode(), 1, 3, 1, 1);
		root.add(items[5].getNode(), 0, 4, 1, 1);
		root.add(items[6].getNode(), 1, 4, 1, 1);
		root.add(items[7].getNode(), 0, 5, 1, 1);
		root.add(items[8].getNode(), 1, 5, 1, 1);
		root.add(items[9].getNode(), 0, 6, 1, 1);
		root.add(items[10].getNode(), 1, 6, 1, 1);	
		
		GridPane.setHalignment(title, HPos.CENTER);
	
		
		setTitle("Movies");
		getIcons().add(new Image("file:taskbar_logo.png"));
		setScene(scene);
		show();
		setResizable(false);
		setOnCloseRequest(new EventHandler<WindowEvent>() 
		{
			public void handle(WindowEvent e) {			
				new DashBoard(primaryStage);
				primaryStage.hide();
			}
		});
	}
}
