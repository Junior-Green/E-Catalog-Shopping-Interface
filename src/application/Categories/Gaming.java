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

public class Gaming extends Stage{
	
	GridPane root;
	ImageView[] images;
	private Stage primaryStage;
	public Gaming(Stage ps) throws FileNotFoundException
	{		
		
		images = new ImageView[]{new ImageView(new Image("file:gaming/slide1.jpg")), new ImageView(new Image("file:gaming/slide2.jpg"))
				,new ImageView(new Image("file:gaming/slide3.jpg")),new ImageView(new Image("file:gaming/slide4.jpg"))};
		
		Item[] items = new Item[35];
		
		SlideShow slideShow = new SlideShow(images);
		root = new GridPane();
		
		Label title = new Label("Gaming");
		title.setFont(Font.loadFont(new FileInputStream(new File("font.ttf")), 80));
		title.setAlignment(Pos.CENTER);
		title.setTextFill(Color.ORANGE);
		ScrollPane sp = new ScrollPane(root);
		sp.setPrefHeight(800);
		sp.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		sp.setHbarPolicy(ScrollBarPolicy.NEVER);
		
		Scene scene = new Scene(sp);
		primaryStage = ps;
		
		items[0] = new Item(new Image("file:gaming/dragon_ball_z_kakarot.jpg"), "DragonBall Z Kakarot\n(PS4)", "79.99", scene);
		items[1] = new Item(new Image("file:gaming/dualshock_4_ps4_controller.jpg"), "DualShock 4 PS4 Controller", "74.99", scene);
		items[2] = new Item(new Image("file:gaming/minecraft_starter_pack_edition.jpg"), "Minecraft Starter Pack Edition\n(XBox One)", "59.99", scene);
		items[3] = new Item(new Image("file:gaming/last_of_us_2.jfif"), "Last of Us 2 Pre-Order\n(PS4)", "109.99", scene);
		items[4] = new Item(new Image("file:gaming/nintendo_2ds.jpg"), "Nintendo 2DS\n(Zelda: Ocarina of Time Pre-Installed)", "279.99", scene);
		items[5] = new Item(new Image("file:gaming/nintendo_switch.jpg"), "Nintendo Switch", "409.99", scene);
		items[6] = new Item(new Image("file:gaming/ps_plus_12_month.jpg"), "PS Plus 12 Months", "59.99", scene);
		items[7] = new Item(new Image("file:gaming/xbox_live_12 _months.jpg"), "XBox Live 12 Months", "59.99", scene);
		items[8] = new Item(new Image("file:gaming/ps4_500gb_with_fortnite.jfif"), "PlayStation 4 Fortnite Edition\n(500 GB)", "399.99", scene);
		items[9] = new Item(new Image("file:gaming/ps4_pro_1tb.jpg"), "PlayStation 4 Pro\n(1 TB)", "499.99", scene);
		items[10] = new Item(new Image("file:gaming/sekiro_shadows_die_twice.jpeg"), "Sekiro Shadows Die Twice\n(PS4)", "79.99", scene);
		items[11] = new Item(new Image("file:gaming/sony_psp_1000.jpg"), "Sony PSP 1000", "49.99", scene);
		items[12] = new Item(new Image("file:gaming/star_wars_jedi_fallen_order.jpg"), "Star Wars Jedi:\nFallen Order\n(PS4)", "79.99", scene);
		items[13] = new Item(new Image("file:gaming/super_smash_bros_ultimate.jpg"), "Super Smash Bros. Ultimate", "79.99", scene);
		items[14] = new Item(new Image("file:gaming/xbox_one__s_1tb.jpg"), "XBox One S\n(1TB)", "479.99", scene);
		items[15] = new Item(new Image("file:gaming/xbox_one_500_gb.jpg"), "XBox One\n(500 GB)", "399.99", scene);
		items[17] = new Item(new Image("file:gaming/mario_kart_8_deluxe.jpg"), "Mario Kart 8 Deluxe", "79.99", scene);
		items[18] = new Item(new Image("file:gaming/the_outerworlds_ps4.jpg"), "The OuterWorlds\n(PS4)", "79.99", scene);
		items[19] = new Item(new Image("file:gaming/xbox_one_wireless_controller.jpg"), "XBox One Wireless Controller", "74.99", scene);
		items[20] = new Item(new Image("file:gaming/horizon_zero_dawn_complete_edition.jpg"), "Horizon Zero Dawn\n(Complete Edition)(PS4)", "79.99", scene);
		items[21] = new Item(new Image("file:gaming/overwatch_legendary_edition.jpg"), "Overwatch Legendary Edition\n(PS4)", "79.99", scene);
		items[22] = new Item(new Image("file:gaming/dragonball_fighter_z.jpg"), "Dragonball Fighter Z\n(PS4)", "79.99", scene);
		items[23] = new Item(new Image("file:gaming/resident_evil_2_xbox.jpg"), "Resident Evil 2\n(XBox One)", "79.99", scene);
		items[24] = new Item(new Image("file:gaming/resident_evil_2.jpg"), "Resident Evil 2\n(PS4)", "79.99", scene);
		items[25] = new Item(new Image("file:gaming/pokemon_sword_and_shield_double_pack.png"), "Pokemon Sword and Shield", "119.99", scene);
		items[26] = new Item(new Image("file:gaming/witcher_3.jpg"), "Wither 3 Game of the Year Edition\n(XBox One)", "74.99", scene);
		items[27] = new Item(new Image("file:gaming/god_of_war.jpg"), "God of War (PS4)", "69.99", scene);
		items[28] = new Item(new Image("file:gaming/call_of_duty_modern_warfare.jpg"), "Call of Duty Mordern Warfare\n(XBox One)", "79.99", scene);
		items[29] = new Item(new Image("file:gaming/super_mario_odyssey.png"), "Super Mario Odyssey", "79.99", scene);
		items[30] = new Item(new Image("file:gaming/red_dead_redemption_2.jpg"), "Red Dead Redemption 2\n(PS4/Xbox One)", "79.99", scene);
		items[31] = new Item(new Image("file:gaming/energizer_controller_charging_station_for_xboxone.jpg"), "Energizer Controller Charging Station\nfor Xbox One", "34.99", scene);
		items[32] = new Item(new Image("file:gaming/beboncool_ps4_controller_charging_station.jpg"), "BEBONCOOL PS4 Controller\nCharging Station", "23.99", scene);
		items[33] = new Item(new Image("file:gaming/turtle_beach_ear_force_stealth_300_wired_gaming_headset.jpg"), "Turtle Beach Force Stealth 300\nWired Gaming Headset", "126.99", scene);
		items[34] = new Item(new Image("file:gaming/ps_gold_wireless_stereo_headset.jpg"), "PS Gold Wireless Stereo Headset", "46.99", scene);
		items[16] = new Item(new Image("file:gaming/ps_vr.jpg"), "PlayStation VR", "379.99", scene);
		
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
		
		GridPane.setHalignment(title, HPos.CENTER);
		GridPane.setHalignment(slideShow.getSlide(), HPos.CENTER);
	
		
		setTitle("Gaming");
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
