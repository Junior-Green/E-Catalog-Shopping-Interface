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

public class HealthEssentials extends Stage{
	
	GridPane root;
	ImageView[] images;
	private Stage primaryStage;
	public HealthEssentials(Stage ps) throws FileNotFoundException
	{		
		
		images = new ImageView[]{new ImageView(new Image("file:health_essentials/slide1.jpg")), new ImageView(new Image("file:health_essentials/slide2.jpg"))
				,new ImageView(new Image("file:health_essentials/slide3.jpg")),new ImageView(new Image("file:health_essentials/slide4.png"))};
		
		Item[] items = new Item[18];
		
		SlideShow slideShow = new SlideShow(images);
		root = new GridPane();
		
		Label title = new Label("Health Essentials");
		title.setFont(Font.loadFont(new FileInputStream(new File("font.ttf")), 80));
		title.setAlignment(Pos.CENTER);
		title.setTextFill(Color.ORANGE);
		ScrollPane sp = new ScrollPane(root);
		sp.setPrefHeight(800);
		sp.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		sp.setHbarPolicy(ScrollBarPolicy.NEVER);
		
		Scene scene = new Scene(sp,1000,800);
		primaryStage = ps;
		
		items[0] = new Item(new Image("file:health_essentials/4_pcs__brush_and_comb_set.jpg"), "4-Piece Brush and Comb Set", "9.99", scene);
		items[1] = new Item(new Image("file:health_essentials/bounty_paper_towels.jpg"), "Bounty Paper Towels (8-Pack)", "8.99", scene);
		items[2] = new Item(new Image("file:health_essentials/colgate_360_adult_toothbrush.jpg"), "Colgate 360 Adult ToothBrush", "3.99", scene);
		items[3] = new Item(new Image("file:health_essentials/colgate_advanced_whitening_toothpaste.jpg"), "Colgate Advanced Whitening Toothpaste", "4.99", scene);
		items[4] = new Item(new Image("file:health_essentials/colgate_total_gum_health_clean_mint_mouthwash.jpg"), "Colgate Total:\n Gum Health Mint Mouthwash", "9.99", scene);
		items[5] = new Item(new Image("file:health_essentials/cool_mint_antiseptic_mouthwash.png"), "Cool Mint Antiseptic Mouthwash", "10.99", scene);
		items[6] = new Item(new Image("file:health_essentials/fari_rotary_electric_razor_shaver.jpg"), "Fari Electric Razor Shaver", "64.99", scene);
		items[7] = new Item(new Image("file:health_essentials/fist_afro_hair_pick.jpg"), "Fist Afro Pick", "3.99", scene);
		items[8] = new Item(new Image("file:health_essentials/head_and_shoulders_anti_dandruff_shampoo_8.45_fl_oz.jpeg"), "Head and Shoulder:\nAnti Dandruff (8.45 fl oz)", "839.99", scene);
		items[9] = new Item(new Image("file:health_essentials/invisible_antiperspirasnt.png"), "Lady Speed Stick:\nInvisible Antiperspirant", "8.99", scene);
		items[10] = new Item(new Image("file:health_essentials/men+_care_clean_comfort_deodarant_stick.png"), "Dove Men+ Care:\nClean Comfort Deodarant Stick", "8.99", scene);
		items[11] = new Item(new Image("file:health_essentials/old_spice_deodarant_for_men_pack_of_3.jpg"), "Old Spice: Pure Sport\n(Pack of 3)", "14.99", scene);
		items[12] = new Item(new Image("file:health_essentials/old_spice_shampoo_and_conditioner_2_in_1_krakengard.jpg"), "Old Spice Krakengard: \nShampoo and Conditioner (2 in 1)", "12.99", scene);
		items[13] = new Item(new Image("file:health_essentials/philips_sonicare_protective_clean_4100_rechargeable_electric_toothbrush.jpg"), "Philips SoniCare: 4100 Protective Clean", "109.99", scene);
		items[14] = new Item(new Image("file:health_essentials/st.ives_nourish_and_soothe_shea_butter_body_lotion.jpg"), "St. Ives Nourish and Soothe \nShea Butter Body Lotion", "9.99", scene);
		items[15] = new Item(new Image("file:health_essentials/vaseline_essential_heling_body_lotion.jpg"), "Vaseline Essential Healing Body Lotion", "8.79", scene);
		
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
		
		GridPane.setHalignment(title, HPos.CENTER);
	
		
		setTitle("Health Essentials");
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
