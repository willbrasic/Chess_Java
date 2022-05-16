package edu.unlv.mis768.finalproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChessApplication extends Application {

	@Override
	public void start(Stage primaryStage)throws Exception {
		// load the fxml file
		Parent parent = FXMLLoader.load(getClass().getResource("ChessMenu.fxml"));
		// set the scene
		Scene scene = new Scene(parent);
				
		// set the title of the window
		primaryStage.setTitle("Chess Menu");
		// set the scene for the stage
		primaryStage.setScene(scene);
		
		//Prevent window from being resized.
		primaryStage.setResizable(false);
		
		// show the stage
		primaryStage.show();
		}
	

	public static void main(String[] args) {
		launch(args);
	}
}
