package application;

/*Junior Green
 * Mr. Bulhao
 * ICS4U1
 * 8 January 2020
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import com.sun.javafx.tk.FontLoader;
import com.sun.javafx.tk.Toolkit;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Main extends Application {
	
	private Random rnd = new Random();
	public static Stage mainStage; //Stores the Log-in screen stage
	private Pane root;
	private double opacity = 0; //Controls visibilty of label object
	private Timeline startWelcome; //Declare keyframe
	public static User curentUser = new User(); //Stores currently logged in user
	private static File allUsers = new File("accounts.txt"); //File which stores all user accounts
	private static ArrayList<User> users = new ArrayList<User>(); //Array List which stores all Users
	private Ball[] balls; //Declare an Array of class Ball
	KeyFrame welcomeScreen; //Declare keyframe 
	public void start(Stage primaryStage) throws FileNotFoundException {
		
		try //Reads file which contains all User account and stores it in the allUsers ArrayList
		{		
			mainStage = primaryStage;
			BufferedReader reader = new BufferedReader(new FileReader(allUsers));
			
			String line;
			String[] data;
			
			line = reader.readLine();
			while(line != null)
			{
				data = line.split(",");			
				users.add(new User(data[0], data[1], data[2],data[3]));
				line = reader.readLine();
			}
			reader.close();
		}
		catch(FileNotFoundException e)
		{}
		catch(IOException e2)
		{}
				
		PasswordField password = new PasswordField(); //Field which holds login email
		TextField email = new TextField(); //Password Field which holds login password
		Label percentage; //Label which displays percent on loading screen
		AnimationTimer timer; //Declare timer which controls background activity
		ImageView logo //ImageView for Logo
		= new ImageView(new Image("file:taskbar_logo.png",110,110,true,false));
		logo.setLayoutX(460);
		logo.setLayoutY(100);
		
		Font gameFont = Font.loadFont(new FileInputStream(new File("font.ttf")), 24); //Import font
		
		try {
			//Prompt labels for email and password fields
			Label emailW = new Label("Email address");
			emailW.setAlignment(Pos.CENTER);
			emailW.getStyleClass().add("promptLabel");
			emailW.setLayoutX(400);
			emailW.setLayoutY(295);
			emailW.setOnMouseClicked(e -> {
				email.requestFocus();
			});
			 					
			Label passwordW = new Label("Password");
			passwordW.setAlignment(Pos.CENTER);
			passwordW.getStyleClass().add("promptLabel");
			passwordW.setLayoutX(440);
			passwordW.setLayoutY(409);
			passwordW.setOnMouseClicked(e -> {
				password.requestFocus();
			});
			
			//Sets background image for log in screen
			BackgroundImage titleBGM = new BackgroundImage(new Image("file:loginscreen/log_in.jpg"), null, null, null, null);
			root = new Pane();
			root.setBackground(new Background(titleBGM));
			Scene scene = new Scene(root,1000,800);
			
			//Label which displays logged in user's first name
			Label welcomeName = new Label();
			welcomeName.setAlignment(Pos.CENTER);
			welcomeName.getStyleClass().add("welcomeName");
			welcomeName.setFont(Font.loadFont(new FileInputStream(new File("font.ttf")), 120));
			welcomeName.setPrefHeight(119);
			welcomeName.setOpacity(0);
			
			//Welcome phrase for logged in user
			Label welcomePhrase = new Label("Welcome");
			welcomePhrase.setFont(Font.loadFont(new FileInputStream(new File("font.ttf")), 60));
			welcomePhrase.setAlignment(Pos.CENTER);
			welcomePhrase.setPrefHeight(60);
			welcomePhrase.setOpacity(0);
			welcomePhrase.setPrefWidth(214);
			
			
			Label slogan = new Label("Helping You Shop Smarter.");
			slogan.setLayoutX(390);
			slogan.setLayoutY(220);
			slogan.setFont(gameFont);
			
			//Loading animation
			ImageView animation = new ImageView(new Image("file:loginscreen/loading_animation.gif"));	
			animation.setLayoutX(380);
			animation.setLayoutY(200);
				
			percentage = new Label("LOADING  0%");
			percentage.setTextFill(Color.WHITE);
			percentage.setFont(gameFont);
			percentage.setLayoutX(scene.getWidth() / 2 - (percentage.getWidth() / 2) - 50);
			percentage.setLayoutY(400);
			
			email.setPrefSize(400, 70);
			email.setLayoutX(1000 / 2 - 180);
			email.setLayoutY(800 / 2 - 110);
			email.getStyleClass().add("textfield");
			email.setAlignment(Pos.CENTER);
			
			password.setPrefSize(400, 70);
			password.setLayoutX(1000 / 2 - 180);
			password.setLayoutY(1000 / 2 - 100);
			password.getStyleClass().add("passwordfield");
			password.setAlignment(Pos.CENTER);
			
			Button enter = new Button();
			enter.setPrefSize(75,75);
			enter.setLayoutX(610);
			enter.setLayoutY(500);
			enter.getStyleClass().add("enter_button");
			enter.setOnAction(e -> //Encrypts using algorithm and matches it to users email
			{	
				
				Boolean signIn = false;
				for(int i = 0; i < users.size(); i++)
				{
					if (email.getText().equals(users.get(i).getEmail()))
					{
						if(Encrypt.encrypt(password.getText()).equals(users.get(i).getPassword()))
						{		
							if(!curentUser.equals(users.get(i)))
							DashBoard.getItems().clear();
							FontLoader fontLoader = Toolkit.getToolkit().getFontLoader();
							signIn = true;				
							curentUser = users.get(i);	
							welcomeName.setText(curentUser.getFirstName() + ".");
							double scene_width = scene.getWidth() / 2.0;
							double scene_height = scene.getHeight() / 2.0;
							double font_height = welcomeName.getPrefHeight() / 2;
							double font_width = fontLoader.computeStringWidth(welcomeName.getText(), welcomeName.getFont()) / 2.0;
							root.getChildren().clear();
							root.getChildren().addAll(balls[0].getNode(),balls[1].getNode(),balls[2].getNode(),balls[3].getNode(),welcomeName,welcomePhrase);
							welcomePhrase.setLayoutX(scene_width - 112);
							welcomePhrase.setLayoutY(scene_height - 190);
							welcomeName.setLayoutX(scene_width - font_width);
							welcomeName.setLayoutY(scene_height - font_height);	
							opacity = 0;
							startWelcome.play(); //Triggers log in animation
							break;
						}
					}	
					signIn = false;
				}
				if(signIn == false) //If email or password is incorrect display error alert
				{
					Alert wrong = new Alert(AlertType.ERROR);
					wrong.setTitle("Error");
					wrong.setHeaderText(null);
					wrong.setContentText("The email or password was not entered correctly please try again");
					wrong.show();
					email.clear();
					password.clear();
				}
			});
			
			welcomeScreen = new KeyFrame(Duration.millis(100), e -> {
				
				opacity += 0.05;//Increases opacity
				welcomePhrase.setOpacity(opacity);
				welcomeName.setOpacity(opacity);		
			});
			
			startWelcome = new Timeline(welcomeScreen);
			startWelcome.setCycleCount(40);
			;
			Label enter_arrow = new Label(); //Arrow for enter button design
			enter_arrow.setGraphic(new ImageView(new Image("file:loginscreen/enter_arrow.png",40,40,true,true)));
			enter_arrow.setLayoutX(639);
			enter_arrow.setLayoutY(500);
			enter_arrow.setPrefSize(75, 75);
			enter_arrow.setOnMouseEntered(e -> {				
				enter.getStyleClass().add("enter_button_hover");
			});
			enter_arrow.setOnMouseExited(e -> {
				enter.getStyleClass().remove("enter_button_hover");
				
			});
			enter_arrow.setOnMouseClicked(e -> {
				enter.fire();
			});
			
			//Label which redirects to create an account screen if clicked
			Label createAcc = new Label("Don't have an account? Create one.");
			createAcc.getStyleClass().add("createAcc");
			createAcc.setLayoutX(340);
			createAcc.setLayoutY(525);
			createAcc.setOnMouseEntered(e -> {
				primaryStage.getScene().setCursor(Cursor.HAND);
			});
			createAcc.setOnMouseExited(e -> {
				primaryStage.getScene().setCursor(Cursor.DEFAULT);
			});
			createAcc.setOnMouseClicked(e -> {
				
				primaryStage.hide();
				new NewAccount(primaryStage);			
			});
			
			balls = new Ball[4]; //Initializes an array of balls for background aesthetic
			balls[0] = new Ball(scene.getWidth() / 2 - 25, scene.getHeight() / 2 - 25, new Image("file:loginscreen/ball1.png"), 10d, 10d, 1d, 1d);
			balls[1] = new Ball(scene.getWidth() / 2 + 25, scene.getHeight() / 2 + 25, new Image("file:loginscreen/ball2.png"), 10d, 10d, 2d, 2d);
			balls[2] = new Ball(200, 400, new Image("file:loginscreen/ball3.png"), 10d, 10d, 3d, 2d);
			balls[3] = new Ball(324, 401, new Image("file:loginscreen/ball4.png"), 10d, 10d, 2d, 3d);
			
			timer = new AnimationTimer() //Increases percent until it reaches 100
			{
				int percent = rnd.nextInt(100);
				int increment = 9;
				int delay = 100;
				public void handle(long now) 
				{	
					delay -= increment;
					
					if(delay <= 0)
					{
						delay = 100;
						percent++;
						percentage.setText("LOADING  " + percent +"%");	
					}
					if(percent == 100)
					{
						percent++;
						root.getChildren().remove(percentage);
						root.getChildren().remove(animation);
						root.getChildren().addAll(email, password, emailW, passwordW,logo,slogan, enter,enter_arrow,createAcc);
					}
					if(percent == 98)
					{
						delay = 300;
						increment = 1;
						percent++;
						percentage.setText("LOADING  " + percent +"%");	
					}
					
					else if(percent >= 90)
						increment = 8;
					else if(percent >= 75)
						increment = 10;
					else if (percent >= 45)
						increment = 20;
					else 
						increment = 50;
					if(percent >= 100)
						percentage.setText("LOADING  100%");	
					for(int i = 0; i < balls.length; i++)
					{
						balls[i].move();
						balls[i].getNode().setLayoutX(balls[i].getX());
						balls[i].getNode().setLayoutY(balls[i].getY());
						if (balls[i].getX() <= 0 || balls[i].getX() + balls[i].getWidth() >= root.getWidth())
							balls[i].reverseDirection(true);
						if (balls[i].getY() <= 0|| balls[i].getHeight() + balls[i].getY() >= root.getHeight())
							balls[i].reverseDirection(false);
					}
				}
			};
			timer.start();	
			
			startWelcome.setOnFinished(e -> //Once "fade in" animation ends go to home screen
			{
				
				email.clear();
				password.clear();
				root.getChildren().removeAll(welcomePhrase, welcomeName);
				root.getChildren().addAll(email, password, emailW, passwordW,logo,slogan, enter,enter_arrow,createAcc);
				primaryStage.hide();
				new DashBoard(primaryStage);
			});
			
			//If email/password field is empty make prompt label visible if not make it invisible
			email.textProperty().addListener(new ChangeListener<String>() {
				public void changed(ObservableValue<? extends String> observable,
				String oldValue, String newValue)
				{
					
					if(email.getText().equals(""))
						emailW.setVisible(true);
					else
						emailW.setVisible(false);
				}
				});
			password.textProperty().addListener(new ChangeListener<String>() {
				public void changed(ObservableValue<? extends String> observable,
				String oldValue, String newValue)
				{
					
					if(password.getText().equals(""))
						passwordW.setVisible(true);
					else
						passwordW.setVisible(false);
				}
				});
			
			root.getChildren().addAll(balls[0].getNode(),balls[1].getNode(),balls[2].getNode(),balls[3].getNode(), animation,percentage);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("E-Catalog");
			primaryStage.getIcons().add(new Image("file:taskbar_logo.png"));
			primaryStage.setResizable(false);
			primaryStage.setOnCloseRequest(e ->{ //Save all new/existing users in accounts.txt file then terminate
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
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/*Returns a publically accessible array list 
	 * which stores all users
	 * 
	 * @return A ArrayList<User> which stores all users
	 */
	public static ArrayList<User> getUser()
	{
		return users;
	}
	/*Returns a comma delimted text 
	 * file object which stores all user
	 * account information
	 * 
	 * @return a file object
	 */
	public static File getAccountFile()
	{
		return allUsers;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
