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
import javafx.geometry.VPos;
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

public class Electronics extends Stage{
	
	GridPane root;
	ImageView[] images;
	private Stage primaryStage;
	public Electronics(Stage ps) throws FileNotFoundException
	{		
		
		images = new ImageView[]{new ImageView(new Image("file:electronics/slide1.jpg")), new ImageView(new Image("file:electronics/slide2.jpg"))
				,new ImageView(new Image("file:electronics/slide3.jpg")),new ImageView(new Image("file:electronics/slide4.jpg"))};
		
		Item[] items = new Item[18];
		
		SlideShow slideShow = new SlideShow(images);
		root = new GridPane();
		
		Label title = new Label("Electronics");
		title.setFont(Font.loadFont(new FileInputStream(new File("font.ttf")), 80));
		title.setAlignment(Pos.CENTER);
		title.setTextFill(Color.ORANGE);
		ScrollPane sp = new ScrollPane(root);
		sp.setPrefHeight(800);
		sp.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		sp.setHbarPolicy(ScrollBarPolicy.NEVER);
		
		Scene scene = new Scene(sp);
		primaryStage = ps;
		
		items[0] = new Item(new Image("file:electronics/15inch_macbookpro_touchbar.jpg"), "15\" MacBook Pro with TouchBar \n(500GB SSD)", "1999.99", scene);
		items[1] = new Item(new Image("file:electronics/43inch_lg_43um69_4k_ultrahdtv.jpg"), "43\" LG-43UM69 4K Ultra HD TV", "849.99", scene);
		items[2] = new Item(new Image("file:electronics/airpod_pro.jpg"), "Apple AirPods Pro", "329.99", scene);
		items[3] = new Item(new Image("file:electronics/airpods.jpg"), "Apple AirPods", "249.99", scene);
		items[4] = new Item(new Image("file:electronics/beats_studio_wireless.png"), "Beats Solo 3 Wireless", "309.99", scene);
		items[5] = new Item(new Image("file:electronics/benq_24_inch_ips_monitor.jpg"), "BenQ 24\" IPS Monitor", "219.99", scene);
		items[6] = new Item(new Image("file:electronics/corsair_harpoon_rgb_wireless_gaming_mouse.jpg"), "Corsair Harpoon RGB\nWireless Gaming Mouse", "99.99", scene);
		items[7] = new Item(new Image("file:electronics/polk_audio_rm6750_5.1_hometheatre_speaker_system.jpg"), "Polk Audio RM6750 5.1\nHome Theatre Speaker System", "599.99", scene);
		items[8] = new Item(new Image("file:electronics/razar_blackwidow_elite_wired_gaming_mechanical_rgb_keyboard.jpg"), "Razar Black Widow Elite Gaming\nMechanical RGB Keyboard", "114.99", scene);
		items[9] = new Item(new Image("file:electronics/razer_blade_pro_17.png"), "Razar Blade Pro 17", "2899.99", scene);
		items[10] = new Item(new Image("file:electronics/samsung_55_smart4k_uhdtv.jpg"), "Samsung 55 Smart 4K UHD TV", "749.99", scene);
		items[11] = new Item(new Image("file:electronics/samsung_galaxy_buds.jpg"), "Samsung Galaxy Buds", "224.99", scene);
		items[12] = new Item(new Image("file:electronics/sony_dav-sz1000w_multisystem_hometheatre.jpeg"), "Sony DAV-SZ1000W \nMulti System Home Theatre", "744.99", scene);
		
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
		
		GridPane.setHalignment(title, HPos.CENTER);
		GridPane.setHalignment(slideShow.getSlide(), HPos.CENTER);
		GridPane.setValignment(slideShow.getSlide(), VPos.CENTER);
	
		setTitle("Electronics");
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
