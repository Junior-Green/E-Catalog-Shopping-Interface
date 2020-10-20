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

public class Cellphones extends Stage{
	
	GridPane root;
	ImageView[] images;
	private Stage primaryStage;
	public Cellphones(Stage ps) throws FileNotFoundException
	{		
		
		images = new ImageView[]{new ImageView(new Image("file:cellphones/slide1.png")), new ImageView(new Image("file:cellphones/slide2.png"))
				,new ImageView(new Image("file:cellphones/slide3.jpg")),new ImageView(new Image("file:cellphones/slide4.jpg"))};
		
		Item[] items = new Item[18];
		
		SlideShow slideShow = new SlideShow(images);
		root = new GridPane();
		
		Label title = new Label("CellPhones");
		title.setFont(Font.loadFont(new FileInputStream(new File("font.ttf")), 80));
		title.setAlignment(Pos.CENTER);
		title.setTextFill(Color.ORANGE);
		ScrollPane sp = new ScrollPane(root);
		sp.setPrefHeight(800);
		sp.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		sp.setHbarPolicy(ScrollBarPolicy.NEVER);
		
		Scene scene = new Scene(sp,1000,800);
		primaryStage = ps;
		
		items[0] = new Item(new Image("file:cellphones/iphone_se.jpg"), "iPhone SE (64 GB)", "199.99", scene);
		items[1] = new Item(new Image("file:cellphones/iphone_8_plus.jpg"), "iPhone 8 Plus (64GB)", "799.99", scene);
		items[2] = new Item(new Image("file:cellphones/iphone_x.jpg"), "iPhone X (64 GB)", "999.99", scene);
		items[3] = new Item(new Image("file:cellphones/iphone_xr.jpg"), "iPhone XR (64 GB)", "1099.99", scene);
		items[4] = new Item(new Image("file:cellphones/iphone_xs_max.jpg"), "iPhone XS Max (256 GB)", "1589.99", scene);
		items[5] = new Item(new Image("file:cellphones/iphone_11.png"), "iPhone 11 (128 GB)", "1049.99", scene);
		items[6] = new Item(new Image("file:cellphones/iphone11_pro_max.png"), "iPhone 11 Pro Max (128 GB)", "1649.99", scene);
		items[7] = new Item(new Image("file:cellphones/samsung_s8.jpg"), "Samsung Galaxy S8 Plus (64 GB)", "261.99", scene);
		items[8] = new Item(new Image("file:cellphones/samsung_s9.jpg"), "Samsung Galaxy S9 Plus (128 GB)", "839.99", scene);
		items[9] = new Item(new Image("file:cellphones/samsung_s10.jpg"), "Samsung Galaxy S10 (128 GB)", "1259.99", scene);
		items[10] = new Item(new Image("file:cellphones/galaxy_note_9.jpg"), "Samsung Galaxy Note 9 (64 GB)", "949.99", scene);
		items[11] = new Item(new Image("file:cellphones/galaxy_note_10.jpg"), "Samsung Galaxy Note 10 (128 GB)", "1039.99", scene);
		items[12] = new Item(new Image("file:cellphones/oneplus_6t.jpg"), "OnePlus 6T (64 GB)", "579.99", scene);
		items[13] = new Item(new Image("file:cellphones/oneplus_7t.jpg"), "OnePlus 7T (128 GB)", "599.99", scene);
		items[14] = new Item(new Image("file:cellphones/oneplus_7_pro.jpg"), "OnePlus 7 Pro (256 GB)", "669.99", scene);
		items[15] = new Item(new Image("file:cellphones/google_pixel_3a.jpg"), "Google Pixel 3a (64 GB)", "549.99", scene);
		items[16] = new Item(new Image("file:cellphones/google_pixel_3_XL.jpg"), "Google Pixel 3 XL (64 GB)", "899.99", scene);
		items[17] = new Item(new Image("file:cellphones/huawei_p30_pro.png"), "Huawei P30 Pro (128 GB)", "1299.99", scene);
		
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
		root.add(items[12].getNode(), 1, 7, 1, 1);
		root.add(items[13].getNode(), 0, 8, 1, 1);
		root.add(items[14].getNode(), 1, 8, 1, 1);
		root.add(items[15].getNode(), 0, 9, 1, 1);
		root.add(items[16].getNode(), 1, 9, 1, 1);
		root.add(items[17].getNode(), 0, 10, 1, 1);
		
		
		GridPane.setHalignment(title, HPos.CENTER);
	
		
		setTitle("Cellphones");
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
