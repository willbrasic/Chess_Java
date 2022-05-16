package edu.unlv.mis768.finalproject;


import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
 //Author: Sergio Torres and William Brasic.
//The purpose of this class is to control database operations in a visual display and launch the game.

public class ChessMenuController {

	 @FXML
	 private Button deleteHistoryButton;

	 @FXML
	 private Button loadHistoryButton;

	 @FXML
	 private Button newGameButton;

	 @FXML
	 private Label promptLabel;

	 @FXML
	 private Button reviseHistoryButton;
	 
	 @FXML
	 private TextArea resultArea;
	    
	 /**
	 * Event handler for the "New Game" Button 
	 * It allows the players to be set for the match and pass players to the next scene.
	 * @throws IOException 
	 */
	 public void changeSceneToBoard(ActionEvent e) throws IOException {
	 
		 //Generate dialog box to collect match info in local variables.
		 TextInputDialog playerOne = new TextInputDialog();
		 TextInputDialog playerTwo = new TextInputDialog();
		 TextInputDialog matchNum = new TextInputDialog();
		 //Set header for dialogs and Show the dialog boxes in order.
		 playerOne.setHeaderText("Enter first player name.");
		 playerTwo.setHeaderText("Enter second player name.");
		 matchNum.setHeaderText("Enter a reference ID");
		 playerOne.showAndWait();
		 playerTwo.showAndWait();
		 matchNum.showAndWait();
		 
		 //Retrieve inputs from dialogs to string values.
		 String firstName = playerOne.getEditor().getText();
		 String secondName = playerTwo.getEditor().getText();
		 String id= matchNum.getEditor().getText();
		 
		 //Set strings to player objects.
		 Player contestantOne = new Player(firstName);
		 Player contestantTwo = new Player(secondName);
		 
		 //Create ChessResult Object to add challenge to database using currentGame variable.
		 ChessResult currentGame = new ChessResult(id, contestantOne, contestantTwo);
		 
		//Initialize instance of DAO implementation and assign to variable.
		 ChessResultsDAOImplementation create = new ChessResultsDAOImplementation();
		 
		//Call createChessResult function to update database.
		 if (create.createChessResult(currentGame)) {
			 //If flag from method is true, set resultArea text to confirm.
			 resultArea.setText("Let the game begin!");
		 }
		 else {
			 //If false tell the user the match needs to be remade.
			 resultArea.setText("Your match is missing information.Try again.");
		 }
		 
		 // Instantiate the FXMLLoader object for loading the UI 
		 FXMLLoader loader = new FXMLLoader();
		 // specify the file location for the FXML file for the next window
		 loader.setLocation(getClass().getResource("ChessGame.fxml"));
		 // load the UI for the next window
		 Parent parent = loader.load();
		 // set the scene
		 Scene scene = new Scene(parent);
		 
		// access the controller class for the next window via the FXML loader
	    ChessGameController controller = loader.getController();
	    
	  //Initialize ChessGame with contestants using ChessGame variable freshMatch.
	    ChessGame freshMatch = new ChessGame();

	    //Start game using contestant player variables.
	    freshMatch.startGame(contestantOne, contestantTwo);
	    
	    // call the method in the controller class for the next window
	    // so that the string can be passed
	    controller.initData(freshMatch);
	   
		 // get the current stage, using the ActionEvent object
	     Stage stage = (Stage) (((Node) e.getSource()).getScene().getWindow());
	     
	     //Prevent stage from being resized.
	     stage.setResizable(false);
	     
		 // change the title
		 stage.setTitle("Active Chess Match");
		 // set the new scene to the stage
		 stage.setScene(scene);
		 // show the stage
		 stage.show();
	 	}
	 /**This method serves as an event listener for the loadHistoryButton and calls the database to load previous matches.
	  * 
	  */
	 public void loadHistoryButtonListener(ActionEvent e) {
		//Generate dialog box to collect player names in local variables.
		 TextInputDialog playerOne = new TextInputDialog();
		 
		 //Set header for dialog and Show the dialog box for input.
		 playerOne.setHeaderText("Player to search.");
		 
		 playerOne.showAndWait();
		 
		 
		 //Retrieve input from dialog to string values.
		 String firstName = playerOne.getEditor().getText();
		 
		 //Set string to player object.
		 Player contestant = new Player(firstName);
		 
		 //Initialize instance of DAO implementation and assign to variable.
		 ChessResultsDAOImplementation search = new ChessResultsDAOImplementation();
		
		//Call getTotalGamesPlayed function to search database of games played and set to text area.
		 resultArea.setText(search.getTotalGamesPlayed(contestant));	 
	 }
	 
	 
	 /**This method serves as an event listener for the deleteHistoryButton and calls the database to delete a match by number.
	  */
	 public void deleteHistoryButtonListener(ActionEvent e) {
		//Generate dialog box to collect match number in local variable.
		 TextInputDialog match = new TextInputDialog();
		 
		 //Set header for dialog and Show the dialog box for input.
		 match.setHeaderText("Enter Match Number.");
		 
		 match.showAndWait();
		 
		 //Retrieve input from dialog to string values.
		 String matchToDelete = match.getEditor().getText();
		 
		 //Set string to new ChessResult object deleteResult
		 ChessResult deleteResult = new ChessResult();
		 
		 //Call setMatchID and assign to deleteResult. 
		 deleteResult.setMatchID(matchToDelete);
		 
		 //Initialize instance of DAO implementation and assign to variable.
		 ChessResultsDAOImplementation remove = new ChessResultsDAOImplementation();
		 
		//Call deleteChessResult function to search database of games played and set to table view.
		 if (remove.deleteChessResult(deleteResult)) {
			 //If flag from method is true, set resultArea text to confirm.
			 resultArea.setText("The match has been successfully removed");
		 }
		 else {
			 //If false tell the user the match could not be found.
			 resultArea.setText("The match could not be found.");
		 }
	 }
		 /**This method serves as an event listener for the reviseHistoryButton and calls the database to change a record.
		  */
		 public void reviseHistoryButtonListener(ActionEvent e) {
			//Generate dialog boxes to collect players and match number in local variables.
			 TextInputDialog player1 = new TextInputDialog();
			 TextInputDialog player2 = new TextInputDialog();
			 TextInputDialog match = new TextInputDialog();
			 
			 //Set header for dialog and Show the dialog box for input.
			 match.setHeaderText("Enter Match # to Update."); 
			 match.showAndWait();
			 
			 player1.setHeaderText("Who was player 1?");
			 player1.showAndWait();
			 
			 player2.setHeaderText("Who was player 2?");
			 player2.showAndWait();
			 
			 //Retrieve input from dialogs to string values.
			 Player revisedFirst = new Player(player1.getEditor().getText());			 
			 Player revisedSecond = new Player(player2.getEditor().getText());
			 String matchRecord = match.getEditor().getText();
			 
			 //Set local variables to new ChessResult object updateResult
			 ChessResult updateResult = new ChessResult(matchRecord,revisedFirst,revisedSecond);
			 
			 //Initialize instance of DAO implementation and assign to variable.
			 ChessResultsDAOImplementation update = new ChessResultsDAOImplementation();
			 
			//Call updateChessResult function to search database for record to update.
			 if (update.updateChessResult(updateResult)) {
				 //If flag from method is true, set resultArea text to confirm change.
				 resultArea.setText("The match has been successfully updated");
			 }
			 else {
				 //If false tell the user the match could not be found.
				 resultArea.setText("The match could not be found.");
			 }
		 
	 }
	 
}




   


