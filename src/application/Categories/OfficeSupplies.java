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

public class OfficeSupplies extends Stage{
	
	GridPane root;
	ImageView[] images;
	private Stage primaryStage;
	public OfficeSupplies(Stage ps) throws FileNotFoundException
	{		
		
		images = new ImageView[]{new ImageView(new Image("file:office/slide1.jpg")), new ImageView(new Image("file:office/slide2.jpg"))
				,new ImageView(new Image("file:office/slide3.png")),new ImageView(new Image("file:office/slide4.jpg"))};
		
		Item[] items = new Item[18];
		
		SlideShow slideShow = new SlideShow(images);
		root = new GridPane();
		
		Label title = new Label("Office Supplies");
		title.setFont(Font.loadFont(new FileInputStream(new File("font.ttf")), 80));
		title.setAlignment(Pos.CENTER);
		title.setTextFill(Color.ORANGE);
		ScrollPane sp = new ScrollPane(root);
		sp.setPrefHeight(800);
		sp.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		sp.setHbarPolicy(ScrollBarPolicy.NEVER);
		
		Scene scene = new Scene(sp);
		primaryStage = ps;
		
		items[0] = new Item(new Image("file:office/bic_atlantis_retractable_ball_pens.jpg"), "BIC Atlantis Retractable\nBall Pens", "4.99", scene);
		items[1] = new Item(new Image("file:office/bic_mechanical_pencils.jpg"), "BIC Mechanical Pencils", "4.99", scene);
		items[2] = new Item(new Image("file:office/bic_round_stic_xtra_life_ballpoint_pen.jpg"), "BIC Round Stic Xtra Life\nBallpoint Pen", "3.99", scene);
		items[3] = new Item(new Image("file:office/bic_velocity_retractable_ballpoint_pen.jpg"), "BIC Velocity Retractable \nBallpoint Pen", "5.99", scene);
		items[4] = new Item(new Image("file:office/brother_hl_l3270cdw_wireless_color_laser_printer.jpg"), "Brother HL L3270CDW Wireless\nColor Laser Printer", "109.99", scene);
		items[5] = new Item(new Image("file:office/canon_a4_yellow_tab_printing_paper_500_sheets.jpg"), "Canon A4 Yellow Tab Printing Paper\n(500 Sheets)", "0.79", scene);
		items[6] = new Item(new Image("file:office/hp_63_black_original_ink_cartridge.png"), "HP 63 Black Original Ink Cartridge", "45.99", scene);
		items[7] = new Item(new Image("file:office/hp_color_laserjet_pro_m281fdw_laser_printer.jpg"), "HP Color LaserJet Pro (M281FDW)\nLaser Printer", "134.99", scene);
		items[8] = new Item(new Image("file:office/hp_neverstop_laser_1000a.png"), "HP NeverStop Laser 1000A", "99.99", scene);
		items[9] = new Item(new Image("file:office/livescribe_single_subject_notebook_4_pack.jpg"), "Livescribe Single Subject Notebook\n(4-Pack)", "1.79", scene);
		items[10] = new Item(new Image("file:office/oxford_lined_paper_500_sheets.jpg"), "Oxford Lined Paper\n(500 Sheets)", "0.99", scene);
		items[11] = new Item(new Image("file:office/pentel_hi_polymer_block_eraser_pack_of_4.jpg"), "Pentel HI Polymer Block Eraser\n(Pack of 4)", "2.49", scene);
		items[12] = new Item(new Image("file:office/post_it_super_sticky_notes_large_pack_24_pack.jpg"), "Post It Super Sticky Notes Large\n(Pack of 24)", "1.39", scene);
		
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
	
		
		setTitle("Office Supplies");
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
