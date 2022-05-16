//Author: William Brasic and Sergio Torres

package edu.unlv.mis768.finalproject;



//The ChessGameController puts together and implements the rules of the game with a visual layer.


import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;

public class ChessGameController {
		
		
		@FXML
		private Label statusLabel;
	
		@FXML
		private GridPane visualBoard;
	
	  @FXML
	    private ImageView blackBishopLeft;

	    @FXML
	    private ImageView blackBishopRight;

	    @FXML
	    private ImageView blackKing;

	    @FXML
	    private ImageView blackKnightLeft;

	    @FXML
	    private ImageView blackKnightRight;

	    @FXML
	    private ImageView blackQueen;

	    @FXML
	    private ImageView blackRookLeft;

	    @FXML
	    private ImageView blackRookRight;

	    @FXML
	    private ImageView pawn10;

	    @FXML
	    private ImageView pawn60;

	    @FXML
	    private ImageView pawn11;

	    @FXML
	    private ImageView pawn61;

	    @FXML
	    private ImageView pawn12;

	    @FXML
	    private ImageView pawn62;

	    @FXML
	    private ImageView pawn13;

	    @FXML
	    private ImageView pawn63;

	    @FXML
	    private ImageView pawn14;

	    @FXML
	    private ImageView pawn64;

	    @FXML
	    private ImageView pawn15;

	    @FXML
	    private ImageView pawn65;

	    @FXML
	    private ImageView pawn16;

	    @FXML
	    private ImageView pawn66;

	    @FXML
	    private ImageView pawn17;
	    
	    @FXML
	    private ImageView pawn67;

	    @FXML
	    private ImageView whiteKing;

	    @FXML
	    private ImageView whiteKnightLeft;

	    @FXML
	    private ImageView whiteBishopLeft;

	    @FXML
	    private ImageView whiteRookLeft;

	    @FXML
	    private ImageView whiteQueen;

	    @FXML
	    private ImageView whiteBishopRight;

	    @FXML
	    private ImageView whiteKnightRight;

	    @FXML
	    private ImageView whiteRookRight;
	    
	    @FXML
	    private ImageView board20;
	    
	    @FXML
	    private ImageView board21;
	    
	    @FXML
	    private ImageView board22;
	    
	    @FXML
	    private ImageView board23;
	    
	    @FXML
	    private ImageView board24;
	    
	    @FXML
	    private ImageView board25;
	    
	    @FXML
	    private ImageView board26;
	    
	    @FXML
	    private ImageView board27;
	    
	    @FXML
	    private ImageView board30;
	    
	    @FXML
	    private ImageView board31;
	    
	    @FXML
	    private ImageView board32;
	    
	    @FXML
	    private ImageView board33;
	    
	    @FXML
	    private ImageView board34;
	    
	    @FXML
	    private ImageView board35;
	    
	    @FXML
	    private ImageView board36;
	    
	    @FXML
	    private ImageView board37;
	    
	    @FXML
	    private ImageView board40;
	    
	    @FXML
	    private ImageView board41;
	    
	    @FXML
	    private ImageView board42;
	    
	    @FXML
	    private ImageView board43;
	    
	    @FXML
	    private ImageView board44;
	    
	    @FXML
	    private ImageView board45;
	    
	    @FXML
	    private ImageView board46;
	    
	    @FXML
	    private ImageView board47;
	    
	    @FXML
	    private ImageView board50;
	    
	    @FXML
	    private ImageView board51;
	    
	    @FXML
	    private ImageView board52;
	    
	    @FXML
	    private ImageView board53;
	    
	    @FXML
	    private ImageView board54;
	    
	    @FXML
	    private ImageView board55;
	    
	    @FXML
	    private ImageView board56;
	    
	    @FXML
	    private ImageView board57;

	    //Declare field for storing the match settings.
	    private ChessGame playerMatch;
		
		
/**
 ** initData will pass initialized chess game and players from previous scene.
*/
public void initData(ChessGame game ) {
	playerMatch = game;
	
	//Start game with both players.
	playerMatch.startGame(game.getPlayer1(),game.getPlayer2());
	
	//Set chessboard square array property to visual board.
	visualBoard.setUserData(game.getChessBoard());
	

	//Assign ImageView Nodes of pieces to Pieces from the chessboard object.
	
	//Black Pieces
	blackBishopLeft.setUserData(new Rook(false));
	blackKnightLeft.setUserData(new Knight(false));
	blackBishopLeft.setUserData(new Bishop(false));
	blackQueen.setUserData(new Queen(false));
	blackKing.setUserData(new King(false));
	blackBishopRight.setUserData(new Bishop(false));
	blackKnightRight.setUserData(new Knight(false));
	blackRookRight.setUserData(new Rook(false));
	pawn10.setUserData(new Pawn(false));
	pawn11.setUserData(new Pawn(false));
	pawn12.setUserData(new Pawn(false));
	pawn13.setUserData(new Pawn(false));
	pawn14.setUserData(new Pawn(false));
	pawn15.setUserData(new Pawn(false));
	pawn16.setUserData(new Pawn(false));
	pawn17.setUserData(new Pawn(false));
	
	//White Pieces
	whiteRookLeft.setUserData(new Rook(true));
	whiteKnightLeft.setUserData(new Knight(true));
	whiteBishopLeft.setUserData(new Bishop(true));
	whiteQueen.setUserData(new Queen(true));
	whiteKing.setUserData(new King(true));
	whiteBishopRight.setUserData(new Bishop(true));
	whiteKnightRight.setUserData(new Knight(true));
	whiteRookRight.setUserData(new Rook(true));
	pawn60.setUserData(new Pawn(true));
	pawn61.setUserData(new Pawn(true));
	pawn62.setUserData(new Pawn(true));
	pawn63.setUserData(new Pawn(true));
	pawn64.setUserData(new Pawn(true));
	pawn65.setUserData(new Pawn(true));
	pawn66.setUserData(new Pawn(true));
	pawn67.setUserData(new Pawn(true));
	
	//Set the initial GridPane locations for the pieces.
	//Black Pieces
	GridPane.setColumnIndex(blackRookLeft, 0);
	GridPane.setRowIndex(blackRookLeft, 0);
	GridPane.setColumnIndex(blackKnightLeft, 1);
	GridPane.setRowIndex(blackKnightLeft, 0);
	GridPane.setColumnIndex(blackBishopLeft, 2);
	GridPane.setRowIndex(blackBishopLeft, 0);
	GridPane.setColumnIndex(blackQueen, 3);
	GridPane.setRowIndex(blackQueen, 0);
	GridPane.setColumnIndex(blackKing, 4);
	GridPane.setRowIndex(blackKing, 0);
	GridPane.setColumnIndex(blackBishopRight, 5);
	GridPane.setRowIndex(blackBishopRight, 0);
	GridPane.setColumnIndex(blackKnightRight, 6);
	GridPane.setRowIndex(blackKnightRight, 0);
	GridPane.setColumnIndex(blackRookRight, 7);
	GridPane.setRowIndex(blackRookRight, 0);
	GridPane.setColumnIndex(pawn10, 0);
	GridPane.setRowIndex(pawn10, 1);
	GridPane.setColumnIndex(pawn11, 1);
	GridPane.setRowIndex(pawn11, 1);
	GridPane.setColumnIndex(pawn12, 2);
	GridPane.setRowIndex(pawn12, 1);
	GridPane.setColumnIndex(pawn13, 3);
	GridPane.setRowIndex(pawn13, 1);
	GridPane.setColumnIndex(pawn14, 4);
	GridPane.setRowIndex(pawn14, 1);
	GridPane.setColumnIndex(pawn15, 5);
	GridPane.setRowIndex(pawn15, 1);
	GridPane.setColumnIndex(pawn16, 6);
	GridPane.setRowIndex(pawn16, 1);
	GridPane.setColumnIndex(pawn17, 7);
	GridPane.setRowIndex(pawn17, 1);
	
	//White Pieces
	GridPane.setColumnIndex(whiteRookLeft, 0);
	GridPane.setRowIndex(whiteRookLeft, 7);
	GridPane.setColumnIndex(whiteKnightLeft, 1);
	GridPane.setRowIndex(whiteKnightLeft, 7);
	GridPane.setColumnIndex(whiteBishopLeft, 2);
	GridPane.setRowIndex(whiteBishopLeft, 7);
	GridPane.setColumnIndex(whiteQueen, 3);
	GridPane.setRowIndex(whiteQueen, 7);
	GridPane.setColumnIndex(whiteKing, 4);
	GridPane.setRowIndex(whiteKing, 7);
	GridPane.setColumnIndex(whiteBishopRight, 5);
	GridPane.setRowIndex(whiteBishopRight, 7);
	GridPane.setColumnIndex(whiteKnightRight, 6);
	GridPane.setRowIndex(whiteKnightRight, 7);
	GridPane.setColumnIndex(whiteRookRight, 7);
	GridPane.setRowIndex(whiteRookRight, 7);
	GridPane.setColumnIndex(pawn60, 0);
	GridPane.setRowIndex(pawn60, 6);
	GridPane.setColumnIndex(pawn61, 1);
	GridPane.setRowIndex(pawn61, 6);
	GridPane.setColumnIndex(pawn62, 2);
	GridPane.setRowIndex(pawn62, 6);
	GridPane.setColumnIndex(pawn63, 3);
	GridPane.setRowIndex(pawn63, 6);
	GridPane.setColumnIndex(pawn64, 4);
	GridPane.setRowIndex(pawn64, 6);
	GridPane.setColumnIndex(pawn65, 5);
	GridPane.setRowIndex(pawn65, 6);
	GridPane.setColumnIndex(pawn66, 6);
	GridPane.setRowIndex(pawn66, 6);
	GridPane.setColumnIndex(pawn67, 7);
	GridPane.setRowIndex(pawn67, 6);
	
	//Empty Spaces
	GridPane.setColumnIndex(board20, 0);
	GridPane.setRowIndex(board20, 2);
	GridPane.setColumnIndex(board21, 1);
	GridPane.setRowIndex(board21, 2);
	GridPane.setColumnIndex(board22, 2);
	GridPane.setRowIndex(board22, 2);
	GridPane.setColumnIndex(board23, 3);
	GridPane.setRowIndex(board23, 2);
	GridPane.setColumnIndex(board24, 4);
	GridPane.setRowIndex(board24, 2);
	GridPane.setColumnIndex(board25, 5);
	GridPane.setRowIndex(board25, 2);
	GridPane.setColumnIndex(board26, 6);
	GridPane.setRowIndex(board26, 2);
	GridPane.setColumnIndex(board27, 7);
	GridPane.setRowIndex(board27, 2);
	GridPane.setColumnIndex(board30, 0);
	GridPane.setRowIndex(board30, 3);
	GridPane.setColumnIndex(board31, 1);
	GridPane.setRowIndex(board31, 3);
	GridPane.setColumnIndex(board32, 2);
	GridPane.setRowIndex(board32, 3);
	GridPane.setColumnIndex(board33, 3);
	GridPane.setRowIndex(board33, 3);
	GridPane.setColumnIndex(board34, 3);
	GridPane.setRowIndex(board34, 3);
	GridPane.setColumnIndex(board35, 5);
	GridPane.setRowIndex(board35, 3);
	GridPane.setColumnIndex(board36, 6);
	GridPane.setRowIndex(board36, 3);
	GridPane.setColumnIndex(board37, 7);
	GridPane.setRowIndex(board37, 3);
	GridPane.setColumnIndex(board40, 0);
	GridPane.setRowIndex(board40, 4);
	GridPane.setColumnIndex(board41, 1);
	GridPane.setRowIndex(board41, 4);
	GridPane.setColumnIndex(board42, 2);
	GridPane.setRowIndex(board42, 4);
	GridPane.setColumnIndex(board43, 3);
	GridPane.setRowIndex(board43, 4);
	GridPane.setColumnIndex(board44, 3);
	GridPane.setRowIndex(board44, 4);
	GridPane.setColumnIndex(board45, 5);
	GridPane.setRowIndex(board45, 4);
	GridPane.setColumnIndex(board46, 6);
	GridPane.setRowIndex(board46, 4);
	GridPane.setColumnIndex(board47, 7);
	GridPane.setRowIndex(board47, 4);
	GridPane.setColumnIndex(board50, 0);
	GridPane.setRowIndex(board50, 5);
	GridPane.setColumnIndex(board51, 1);
	GridPane.setRowIndex(board51, 5);
	GridPane.setColumnIndex(board52, 2);
	GridPane.setRowIndex(board52, 5);
	GridPane.setColumnIndex(board53, 3);
	GridPane.setRowIndex(board53, 5);
	GridPane.setColumnIndex(board54, 3);
	GridPane.setRowIndex(board54, 5);
	GridPane.setColumnIndex(board55, 5);
	GridPane.setRowIndex(board55, 5);
	GridPane.setColumnIndex(board56, 6);
	GridPane.setRowIndex(board56, 5);
	GridPane.setColumnIndex(board57, 7);
	GridPane.setRowIndex(board57, 5);
}

//Sets the status Label to display the current game state.
public void statusLabelListener(MouseEvent e) {
	statusLabel.setText(playerMatch.getCurrentTurn().playerName + "'s turn.");
}
//Initialize startLocation outside of class for reference in the drag and drop listener.
Node startLocation = null;

public void pieceMoveListener(DragEvent e) {
	//Create dragboard when drag and drop is initiated. Set success as false for default to evaluate first.
	Dragboard db = e.getDragboard();
	boolean success = false;
	
	//Record target of drag and drop to get start and end coordinates.
	//Create nodes for source and target location and get coordinates.
	Node endLocation = e.getPickResult().getIntersectedNode();

	int startXCoord = GridPane.getRowIndex(startLocation);
	int	startYCoord = GridPane.getColumnIndex(startLocation);
	int endXCoord = GridPane.getRowIndex(endLocation);
	int endYCoord = GridPane.getColumnIndex(endLocation);
	System.out.println("start: "+startLocation);
	System.out.println("end: "+endLocation);
	System.out.println("startXCoord: "+startXCoord+"startYCoord: "+startYCoord+"endXCoord: "+endXCoord+"endYCoord: "+endYCoord);
	//Run results through the player legal move method.
	if (playerMatch.playerLegalMove(playerMatch.getCurrentTurn(),
			startXCoord,startYCoord,endXCoord , endYCoord)) { 
		try {	
			
			//If true create a new imageview object using the image stored on the dragboard.
			//ImageView image= new ImageView(db.getImage());
			
			//Add new imageView to the new coordinate and change status of event.
			visualBoard.add(startLocation, endYCoord, endXCoord);
			
		}catch(Exception ex) {
			System.out.println(ex.getCause());
			System.out.println(ex.getMessage());
		}
		success = true;
	}
	
	//Advise source of event success and consume event.
	e.setDropCompleted(success);
	
	e.consume();
}
/**
 * This method detects when the dragevent is over a possible valid target.
 * @param e
 */
public void dragOver(DragEvent e) {
	e.acceptTransferModes(TransferMode.MOVE);
	e.consume();
}

/**This method detects when the user initiates the dragEvent and starts the Drag and Drop method.
 * Creates a clipboard to provide the programmer information on the drag status.
 * @param event
 */

public void dragDetected(MouseEvent event) {
	startLocation = (Node) event.getSource();
	
	Dragboard db= visualBoard.startDragAndDrop(TransferMode.MOVE);
	
	ClipboardContent content = new ClipboardContent();
	content.putString("starting");
	db.setContent(content);
	
	System.out.println("Drag and drop started!");
	event.consume();
}


}
