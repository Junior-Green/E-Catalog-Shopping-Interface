package application;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class NewAccount extends Stage{

	private Stage primaryStage;
	TextField[] fields = new TextField[5];
		public NewAccount(Stage ps)
		{
			
			//Declare and initialize an Error Alert
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("Invalid Information");
			error.setHeaderText(null);
			error.setContentText("All text fields are required to be filled out");
			
			ImageView accountLogo = new ImageView(new Image("file:createaccount/account_logo.png"));
			accountLogo.getStyleClass().add("accountcreateLogo");
			
			Button enter = new Button("Create");
			enter.setPrefSize(100,40);
			enter.setStyle("-fx-text-fill: white; -fx-control-inner-background: orange; -fx-font-weight: bold;");
			enter.setBackground(new Background(new BackgroundFill(Color.ORANGE, new CornerRadii(5), Insets.EMPTY)));
			enter.setOnMouseEntered(e -> { 
				this.getScene().setCursor(Cursor.HAND);
			});
			enter.setOnMouseExited(e -> {
				this.getScene().setCursor(Cursor.DEFAULT);
			});
			enter.setOnAction(e -> {
				Boolean okay = true;
				//If any of the text fields are empty show an alert
				if (fields[0].getText().isEmpty())
				{
					fields[0].requestFocus();					
					error.show();
				}
				else if (fields[1].getText().isEmpty())
				{
					fields[1].requestFocus();				
					error.show();
				}
				else if (fields[2].getText().isEmpty())
				{
					fields[2].requestFocus();
					error.show();
				}
				else if (fields[3].getText().isEmpty())
				{
					fields[3].requestFocus();
					error.show();
				}
				else if (fields[4].getText().isEmpty())
				{
					fields[4].requestFocus();
					error.show();
				}
				else if(!fields[3].getText().equals(fields[4].getText())) //If text fields 3 and 4 do not match show an alert
				{

					Alert passwords = new Alert(AlertType.ERROR);
					passwords.setTitle("Incorrect Password");
					passwords.setHeaderText(null);
					passwords.setContentText("Your passwords do not match please try again.");
					passwords.show();
					fields[3].clear();
					fields[4].clear();
					fields[3].requestFocus();					
				}
				//Show an alert if the text field does not match the pattern
				else if(!fields[2].getText().matches("\\w+@\\w+[.]{1}\\w{2,}"))
				{
					Alert wrong = new Alert(AlertType.ERROR);
					wrong.setTitle("Invalid Information");
					wrong.setHeaderText(null);
					wrong.setContentText("Please enter in a valid email address.");
					wrong.show();
				}
				else 
				{
					//If the email given matches any of the existing user's emails show an alert
					for(int i = 0; i < Main.getUser().size(); i++)
					{					
						if(Main.getUser().get(i).getEmail().equals(fields[2].getText()))
						{				
							Alert errorE = new Alert(AlertType.ERROR);
							errorE.setTitle("Error");
							errorE.setHeaderText(null);
							errorE.setContentText("An account has already been created with the given email address.\n Please try again.");
							errorE.showAndWait();
							okay = false;
							break;		
						}
					}
					if(okay)//Use information given in the text fields to create a new User object
					{					
						Main.getUser().add(new User(fields[0].getText(), fields[1].getText(),fields[2].getText(),Encrypt.encrypt(fields[3].getText())));
						Alert success = new Alert(AlertType.INFORMATION);
						success.setTitle("Account Created.");
						success.setHeaderText(null);
						success.setContentText("Account creation successful.");
						success.showAndWait();
						hide();
						
						
						primaryStage.show();
					}
				}
			});		
			
			//Declare and intialize a Label object
			Label signIn = new Label("Log-in screen");
			signIn.setStyle("-fx-text-fill: orange; -fx-font-size: 12pt; -fx-font-weight: bold;");
			signIn.setAlignment(Pos.TOP_CENTER);
			signIn.setOnMouseEntered(e -> {		
				this.getScene().setCursor(Cursor.HAND);
			});
			signIn.setOnMouseExited(e -> {
				this.getScene().setCursor(Cursor.DEFAULT);
			});
			signIn.setOnMouseClicked(e -> {//Brings users back the login screen
				this.hide();
				primaryStage.show();
			});
			
			primaryStage = ps;
						
			for(int i = 0; i < fields.length; i++)//Initialize all Label objects
			{
				fields[i] = new TextField();
				fields[i].setPrefSize(200, 40);
			}
			fields[2].setPrefSize(400, 40);
		
			//Sets the prompt text for all label objects
			fields[0].setPromptText("First Name");
			fields[1].setPromptText("Last Name");
			fields[2].setPromptText("Email");
			fields[3].setPromptText("Password");
			fields[4].setPromptText("Confirm Password");
			
			ImageView logo = new ImageView(new Image("file:taskbar_logo.png",70,70,true,true));
			
			//Title label
			Label createAcc = new Label("Create your E-Catalog Account.");
			createAcc.setAlignment(Pos.CENTER_LEFT);
			createAcc.getStyleClass().add("slogan");
			
			GridPane root = new GridPane();
			//GridPane formatting
			root.setVgap(25);
			root.setHgap(20);
			root.setAlignment(Pos.TOP_LEFT);
			root.setPadding(new Insets(40,40,40,40));
			root.add(logo, 0, 0);
			root.add(createAcc, 0, 1,3,1);
			root.add(fields[0], 0, 2, 1, 1);
			root.add(fields[1], 1, 2, 1, 1);
			root.add(fields[2], 0, 3, 2, 1);
			root.add(fields[3], 0, 4,1,1);
			root.add(fields[4], 1, 4,1,1);
			root.add(accountLogo, 2, 1, 1, 4);
			root.add(signIn, 0, 5, 1, 1);
			root.add(enter, 1, 5, 1, 1);
			
			//GridPane formatting
			GridPane.setHalignment(signIn, HPos.LEFT);
			GridPane.setValignment(signIn, VPos.BOTTOM);
			GridPane.setHalignment(enter, HPos.RIGHT);
			GridPane.setValignment(enter, VPos.BOTTOM);		
			GridPane.setHalignment(logo, HPos.LEFT);
			GridPane.setValignment(logo, VPos.CENTER);
			GridPane.setMargin(accountLogo, new Insets(0,0,0,30));
			GridPane.setMargin(enter, new Insets(20,0,0,40));
			root.getStyleClass().add("gridPaneBorder");
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			getIcons().add(new Image("file:taskbar_logo.png"));
			setTitle("Create An Account");
			setScene(scene);
			show();
			setOnCloseRequest(new EventHandler<WindowEvent>() {
				public void handle(WindowEvent e) { //Save all new existing users in accounts.txt file then terminate
					
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

}
