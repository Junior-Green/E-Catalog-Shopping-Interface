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

public class Sports extends Stage{
	
	GridPane root;
	ImageView[] images;
	private Stage primaryStage;
	public Sports(Stage ps) throws FileNotFoundException
	{		
		
		images = new ImageView[]{new ImageView(new Image("file:sports/slide1.jpg")), new ImageView(new Image("file:sports/slide2.jpg"))
				,new ImageView(new Image("file:sports/slide3.jpg")),new ImageView(new Image("file:sports/slide4.jpg")), 
				new ImageView(new Image("file:sports/slide5.jpg")),new ImageView(new Image("file:sports/slide6.jpg")), new ImageView(new Image("file:sports/slide7.jpg")),
				new ImageView(new Image("file:sports/slide8.jpg")), new ImageView(new Image("file:sports/slide9.jpg"))};
		
		Item[] items = new Item[37];
		
		SlideShow slideShow = new SlideShow(images);
		root = new GridPane();
		
		Label title = new Label("Sports/Equipment");
		title.setFont(Font.loadFont(new FileInputStream(new File("font.ttf")), 80));
		title.setAlignment(Pos.CENTER);
		title.setTextFill(Color.ORANGE);
		ScrollPane sp = new ScrollPane(root);
		sp.setPrefHeight(800);
		sp.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		sp.setHbarPolicy(ScrollBarPolicy.NEVER);
		
		Scene scene = new Scene(sp);
		primaryStage = ps;
		
		items[0] = new Item(new Image("file:sports/3_pack_promo_wilson_championship_tennis_balls.jpg"), "Wilson Championship Tennis Balls\n(3 Pack)", "13.99", scene);
		items[1] = new Item(new Image("file:sports/adidas_adizero_8.0_football_cleats.jpg"), "Adidas Adizero 8.0 Football Cleats", "124.99", scene);
		items[2] = new Item(new Image("file:sports/adidas_telstar_18_world_cup_soccer_ball.jpg"), "Adidas Telstar World Cup\nSoccer Ball", "49.99", scene);
		items[3] = new Item(new Image("file:sports/agility_900_fg_cleats.jpg"), "Agility 900 FG Cleats", "212.99", scene);
		items[4] = new Item(new Image("file:sports/air_force_1_black.jpeg"), "Air Force 1 (Black)", "0.99", scene);
		items[5] = new Item(new Image("file:sports/air_jordan_12_retro.jpeg"), "Air Jordan 12 Retro\n\"Flu Games\"", "439.99", scene);
		items[6] = new Item(new Image("file:sports/b271_premium.jpg"), "B271 Premium Baseball Bat", "21.49", scene);
		items[7] = new Item(new Image("file:sports/bauer_s18_nsx_hockey_stick.jpg"), "Bauer S18 NSX Hockey Stick", "149.99", scene);
		items[8] = new Item(new Image("file:sports/bauer_supreme_2s_pro_ice_hockey_skates.png"), "Bauer Supreme 2s Pro\nHockey Skates", "333.99", scene);
		items[9] = new Item(new Image("file:sports/bauer_vapor_x2.7_ice_hockey_skates.jpg"), "Bauer Vapor X2.7\nIce Hockey Skates", "276.99", scene);
		items[10] = new Item(new Image("file:sports/bronx_wooden_baseball_bat.jpg"), "Bronx Wooden Baseball Bat", "45.99", scene);
		items[11] = new Item(new Image("file:sports/custom_f7_vtd_professional_series.png"), "Custom F7 VTD Professional Series", "129.99", scene);
		items[12] = new Item(new Image("file:sports/jetspeed_xtra_pro_hockey_stick.jpg"), "Jetspeed Xtra Pro Hockey Stick", "87.99", scene);
		items[13] = new Item(new Image("file:sports/jordan_12_retro_ovo_white.jpg"), "Air Jordan 12 Retro OVO's", "1319.99", scene);
		items[14] = new Item(new Image("file:sports/kyrie_flytrap_basketball_shoe.jpg"), "Kyrie Flytrap Basketball Shoes", "321.99", scene);
		items[15] = new Item(new Image("file:sports/monkey_sports_offical_ice_hockey_puck_12_pack.jpg"), "Monkey Sports Official Hockey Puck\n(12-Pack)", "549.99", scene);
		items[16] = new Item(new Image("file:sports/nike_air_force_1.jpg"), "Nike Air Force 1 (White)", "94.99", scene);
		items[17] = new Item(new Image("file:sports/nike_air_jordan_basketball_shoes.jpg"), "Nike Air Jordan\nBasketball Shoes", "67.99", scene);
		items[18] = new Item(new Image("file:sports/nike_boys_football_and_soccer_shorts.jpg"), "Nike Football/Soccer Shorts ", "62.99", scene);
		items[19] = new Item(new Image("file:sports/nike_kyrie_5_basketball_shoes.jpg"), "Nike Kyrie 5 Basketball Shoes", "219.99", scene);
		items[20] = new Item(new Image("file:sports/nike_men's_kd_11_knit_basketball_shoes.jpg"), "Nike Men KD 11 Knit\nBasketball Shoes", "231.99", scene);
		items[21] = new Item(new Image("file:sports/nike_mercurial_superfly_academy_neymar_jr._soccer_cleats.jpg"), "Nike Mercurial SuperFly Academy\nNeymar Jr. Soccer Cleats", "246.99", scene);
		items[22] = new Item(new Image("file:sports/nike_zoom_lebron_xv_15_basketball_shoes.jpg"), "Nike Zoom Lebron XV 15\nBasketball Shoes", "199.99", scene);
		items[23] = new Item(new Image("file:sports/rawling_baseball_offical_league_recreational_2_ball_pack.jpg"), "Rawling Baseball Official League Ball\n(2-Pack)", "24.99", scene);
		items[24] = new Item(new Image("file:sports/rawlings_prodigy_series_baseball_glove.jpg"), "Rawlings Prodigy Series Baseball Glove", "82.99", scene);
		items[25] = new Item(new Image("file:sports/spalding_polycarbonate_ball_net.jpg"), "Spalding Polycarbonate Baaskteball Net", "614.99", scene);
		items[26] = new Item(new Image("file:sports/toronto_raptors_2019_nba_finals_champions_ball.jpg"), "Toronto Raptors 2019 NBA Finals\nChampionship Ball", "119.99", scene);
		items[27] = new Item(new Image("file:sports/under_armour_curry_one_mvp.jpg"), "Under Armour Curry One MVP", "639.99", scene);
		items[28] = new Item(new Image("file:sports/under_armour_men's_curry_3zero_basketball_shoe.jpg"), "Under Armour Curry 3\nBasketball Shoe", "182.99", scene);
		items[29] = new Item(new Image("file:sports/warrior_covert_qrlzzz-grip_senior_hockey_stick.jpg"), "Warrior Covert QRL Hockey Stick", "156.99", scene);
		items[30] = new Item(new Image("file:sports/wilson_a500_premium_2019_series_baseball_glove.jpg"), "Wilson A500 Premium 2019 Series\nBaseball Glove", "103.99", scene);
		items[31] = new Item(new Image("file:sports/wilson_fusion_xl_tennis_racquet.jpg"), "Wilson Fusion XL Tennis Racquet", "66.99", scene);
		items[32] = new Item(new Image("file:sports/wilson_official_size_football.jpg"), "Wilson Official Size Football", "252.99", scene);
		items[33] = new Item(new Image("file:sports/wilson_staff_fli_golf_balls_pack_of_12.jpg"), "Wilson Staff Fli Golf Balls\n(Pack of 12)", "185.99", scene);
		items[34] = new Item(new Image("file:sports/wilson_titanium_ball_18_pack.jpg"), "Wilson Titanium Golf Balls\n(Pack of 18)", "233.99", scene);
		items[35] = new Item(new Image("file:sports/wilson_ultra_100_cv_tennis_racquet.jpg"), "Wilson Ultra 100 CV \nTennis Racquet", "58.99", scene);
		items[36] = new Item(new Image("file:sports/zoom_lebron_soldier_xi_basketball_shoes.jpeg"), "Zoom Lebron XI\nBasketball Shoes", "275.99", scene);
		
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
		root.add(items[3].getNode(), 1, 3, 1, 1);
		root.add(items[4].getNode(), 0, 4, 1, 1);
		root.add(items[5].getNode(), 1, 4, 1, 1);
		root.add(items[6].getNode(), 0, 5, 1, 1);
		root.add(items[7].getNode(), 1, 5, 1, 1);
		root.add(items[8].getNode(), 0, 6, 1, 1);
		root.add(items[9].getNode(), 1, 6, 1, 1);
		root.add(items[10].getNode(), 0, 7, 1, 1);
		root.add(items[11].getNode(), 1, 7, 1, 1);
		root.add(items[12].getNode(), 0, 21, 1, 1);
		root.add(items[13].getNode(), 0, 8, 1, 1);
		root.add(items[14].getNode(), 1, 8, 1, 1);
		root.add(items[15].getNode(), 0, 9, 1, 1);
		root.add(items[16].getNode(), 1, 9, 1, 1);
		root.add(items[17].getNode(), 0, 10, 1, 1);
		root.add(items[18].getNode(), 1, 10, 1, 1);
		root.add(items[19].getNode(), 0, 11, 1, 1);
		root.add(items[20].getNode(), 1, 11, 1, 1);
		root.add(items[21].getNode(), 0, 12, 1, 1);
		root.add(items[22].getNode(), 1, 12, 1, 1);
		root.add(items[23].getNode(), 0, 13, 1, 1);
		root.add(items[24].getNode(), 1, 13, 1, 1);
		root.add(items[25].getNode(), 0, 14, 1, 1);
		root.add(items[26].getNode(), 1, 14, 1, 1);
		root.add(items[27].getNode(), 0, 15, 1, 1);
		root.add(items[28].getNode(), 1, 15, 1, 1);
		root.add(items[29].getNode(), 0, 16, 1, 1);
		root.add(items[30].getNode(), 1, 16, 1, 1);
		root.add(items[31].getNode(), 0, 17, 1, 1);
		root.add(items[32].getNode(), 1, 17, 1, 1);
		root.add(items[33].getNode(), 0, 18, 1, 1);
		root.add(items[34].getNode(), 1, 18, 1, 1);
		root.add(items[35].getNode(), 0, 19, 1, 1);
		root.add(items[36].getNode(), 1, 19, 1, 1);
		
		GridPane.setHalignment(title, HPos.CENTER);
	
		
		setTitle("Sports/Equipment");
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
