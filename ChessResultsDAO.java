package edu.unlv.mis768.finalproject;

import java.util.List;

/**
 * This is the DAO Class for the ChessResult class
 * @author William Brasic and Sergio Torres
 *
 */


public interface ChessResultsDAO {
		

	   /**
	    * This method inserts a chess result record into the database
	    * @param unpaidOrder is a UnpaidOrder object
	    * @return whether the insertion is successful or not
	    */
	   public boolean createChessResult(ChessResult chessResult);
	   
	   /**
	    * This method deletes a record from the database
	    * @param chessResult
	    * @return whether deletion is successful or not
	    */
	   public boolean deleteChessResult(ChessResult chessResult);
	   
	   /**
	    * This method returns the total chess wins for a certain player
	    * @param chessResult
	    * @return String of ChessResult objects.
	    */
	   public String getTotalGamesPlayed(Player player);
	   
	   
	   /**
	    * This method updates a chess result by allowing the user to change their name
	    * @return true if chess result successfully updated
	    */
	   public boolean updateChessResult(ChessResult chessResult);

	   
}
