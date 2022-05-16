package edu.unlv.mis768.finalproject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javafx.scene.layout.GridPane;

/**
 * This Class controls the flow of the chess game. 
 * @author William Brasic and Sergio Torres
 *
 */

public class ChessGame {
	
	
		// initializing fields
	    private Player player1;
	    private Player player2;
	    private ChessBoard chessBoard;
	    private Player currentTurn;
	    private GameState gameState;
	    private ArrayList<Move> moves = new ArrayList<Move>();
	  
	    /**
	     * This method initializes the game and resets the chess board
	     * @param player1
	     * @param player2
	     */
	    void startGame(Player player1, Player player2){
	    	
	    	// set player1 and player 1
	        this.player1 = player1;
	        this.player2 = player2;
	  
	        // reset chess board
	        chessBoard = new ChessBoard();
	        
	        // if player1 is white then they start the game
	        if (player1.isWhitePlayer()) 
	            this.currentTurn = player1;
	        
	        // otherwise player2 will start the game
	        else 
	            this.currentTurn = player2;
	  
	    }
	    /**
	     * Getter for the first player name.
	     * @return
	     */
	    public Player getPlayer1() {
	    	return this.player1;
	    }
	    /**
	     * Getter for the second player name in the chessgame.
	     * @return
	     */
	    public Player getPlayer2() {
	    	return this.player2;
	    }
	    
	    /**Getter for the ChessBoard array object.
	     * @return
	     */
	    public ChessBoard getChessBoard() {
	    	return this.chessBoard;
	    }
	    /*Getter for the ChessBoard current player turn.
	     * @return 
	     */
	    public Player getCurrentTurn() {
	    	return this.currentTurn;
	    }
	    
	    
	    /**
	     * Getter for the state of the game
	     * @return
	     */
	    public GameState getGameState(){
	        return this.gameState;
	    }
	    
	    /**
	     * Setter for state of the game
	     * @param gameState
	     */
	    public void setGameState(GameState gameState){
	        this.gameState = gameState;
	    }
	  
	    /**
	     * Method to determine if the game is in play or not
	     * @return boolean value of true if the game is in play; true otherwise
	     */
	    public boolean gameInPlay(){
	        return this.getGameState() == GameState.IN_PLAY;
	    }
	    
	    /**
	     * Method to execute move by player_i
	     * @param move
	     * @param player
	     * @return flag which is a boolean value of true if move executed; false otherwise.
	     * @throws  
	     */
	    public boolean executeMove(Move move, Player player){
	    	
	    	// initialize flag
	    	boolean flag = true;
	    	//initialize ending piece.
	    	Piece endingPiece = null;
	    	
	    	// get the piece that is to be moved
	        Piece startingPiece = move.getStartingSquare().getPiece();
	    	
	    	// get ending square to evaluate for null value. 
	    	Square endingSquare = move.getEndingSquare();

	        // determine if a piece has been killed. Update value of ending piece if square not empty.
	        if (endingSquare != null) {
	        	if (endingSquare.hasPiece()) {
	        		endingPiece = move.getEndingSquare().getPiece();
	        		endingPiece.setKilledPiece(true);
	        		move.setKilledPiece(endingPiece);
	        		
	        	}
	        }
	        // if there is no piece on the square return false 
	        if (startingPiece == null) {
	        	flag = false;
	            return flag;
	        }
	  
	        // if it is NOT player_i's turn, then return false because they cannot currently move
	        if (player != currentTurn) {
	        	flag = false;
	            return flag;
	        }
	        
	        // if player_i is playing white (black) and player_i tries to move black (white) this is NOT valid
	        if (startingPiece.isWhitePiece() == player.isWhitePlayer()) {
	            flag = false;
	        	return flag;
	        }
	  
	        // if the piece tries to move in some fashion which is invalid then set flag to false
	        if (!startingPiece.legalMove(chessBoard, move.getStartingSquare(), 
	                                            move.getEndingSquare())) {
	        	flag = false;
	            return flag;
	        }
	  
	  
//	        // castling?
//	        if (startingPiece != null && 
//	            && startingPiece.isCastlingMove()) {
//	            move.setCastlingMove(true);
//	        }
	  
	        
	  
	        // move desired piece from starting square to ending square
	        move.getEndingSquare().setPiece(move.getStartingSquare().getPiece());
	        
	        // set starting square to null as the desired piece has been moved from it
	        move.getStartingSquare().setPiece(null);
	        
	        // store move
	        moves.add(move);
	        
	        // end game if endingPiece is a king
	        if (endingPiece != null && endingPiece instanceof King) {
	            if (player.isWhitePlayer()) {
	                this.setGameState(GameState.WHITE_WIN);
	            }
	            else {
	                this.setGameState(GameState.BLACK_WIN);
	            }
	            
	            // create print writer object to write all the games moves to
	            PrintWriter movesFile = null;
				try {
					movesFile = new PrintWriter("Moves_of_Previous_Game.txt");
				// print the issue if there is one
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				// loop through the moves ArrayList printing each element to the file 
	            for (int k = 0; k < moves.size(); k ++) {
	            	movesFile.print(k);
	            }
	            	
	        }
	        
	        // set the current turn to the other player
	        if (this.currentTurn == player1) {
	            this.currentTurn = player2;
	        }
	        else {
	            this.currentTurn = player1;
	        }
	        
	        // return true if move executed
	        return true;
	    }

	    
	  /**
	   * Method to determine if player_i can make the desired move
	   * @param player
	   * @param startX
	   * @param startY
	   * @param endX
	   * @param endY
	   * @return boolean value of true if player_i can make the desired move, false otherwise
	   */
	    public boolean playerLegalMove(Player player, int startX, 
	                                int startY, int endX, int endY){
	    	
	    	// initialize the starting and ending squares to null
	    	Square startingSquare = null;
			Square endingSquare = null;
			
			// try to set the starting square
			try {
				startingSquare = chessBoard.validSquare(startX, startY);
				
			// if validSquare method evaluates the false for starting square, inform player_i
			} catch (Exception e) {
				System.out.println("ERROR: Invalid starting square");
			}
			
			// try to set ending square
			try {
				endingSquare = chessBoard.validSquare(endX, endY);
			
			// if validSquare method evaluates to false for ending square, inform player_i
			} catch (Exception e) {
				System.out.println("ERROR: Invalid ending square");
			}
	        
			//Check if both values were assigned a value.
			if (startingSquare != null && endingSquare != null) {
				// if the above are okay then create a move object of class Move
				Move move = new Move(player, startingSquare, endingSquare);
	        
				// return true if moves is made, false otherwise.
				return this.executeMove(move, player);
	    }
			else {
				return false;
			}
	    
	    }
	
}
