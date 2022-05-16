package edu.unlv.mis768.finalproject;

/**
 * This class implements the DAO for ChessResultsDAO
 * @author William Brasic and Sergio Torres
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ChessResultsDAOImplementation implements ChessResultsDAO{

	@Override
	public boolean createChessResult(ChessResult chessResult) {
		// initialize flag
		boolean flag=false;
		try {
			// connect to database
			Connection conn = ChessResultsDBUtil.getDBConnection();
			Statement stmt = conn.createStatement();
			
			// sql statement for insertion
			String sql = "INSERT INTO " + "ChessResults"+
					     " VALUES ('"+
					     chessResult.getMatchID()+"', '"+
					     chessResult.getPlayer1().getPlayerName()+"', '"+
					     chessResult.getPlayer2().getPlayerName()+"')";
			System.out.println(sql);
			//Execute the query.
			int rows = stmt.executeUpdate(sql);
			
			// if we inserted a record set the flag to true
			if (rows ==1)
				flag=true;
			
			// close connection
            stmt.close();
            ChessResultsDBUtil.closeDBConnection(conn);
   
			// print error if needed
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
		return flag;
	}

	@Override
	public boolean deleteChessResult(ChessResult chessResult) {
		// initialize flag
		boolean flag=false;
		
		try {
			// connect to database
			Connection conn = ChessResultsDBUtil.getDBConnection();
			
			// sql statement
			String sql = "DELETE FROM ChessResults WHERE MatchID = ?";
			
			// prepared statement object
			PreparedStatement prepStmt = conn.prepareStatement(sql);
			
			// provide the value
			prepStmt.setString(1, chessResult.getMatchID());
			
			// execute it
			int rows = prepStmt.executeUpdate();
			
			// print query result
			System.out.println(sql);
			
			// if a row has been deleted then set the flag to true
			if (rows ==1)
				flag=true;
			
			// close connection
            prepStmt.close();
            ChessResultsDBUtil.closeDBConnection(conn);
   
            // print error if needed
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
		
		// return flag
		return flag;
	}

	@Override 
	//@Return list of player objects.
	public String getTotalGamesPlayed(Player player) {
		
		// Create a string object for the data.
        String gamesList = new String();
        
		try {
			// connect to database
			Connection conn = ChessResultsDBUtil.getDBConnection();
			
			// sql command with backtick on columns and string literals to reference player names in query.
			String sql = "SELECT * FROM ChessResults WHERE `Player1` = '"+player.getPlayerName()+"'OR `Player2` = '"+player.getPlayerName()+"'" ;
			
			// create statement object
			Statement stmt = conn.createStatement(
            		ResultSet.TYPE_SCROLL_INSENSITIVE,
            		ResultSet.CONCUR_READ_ONLY);
			
			
			// result set
			ResultSet result = stmt.executeQuery(sql);
			
			//Get the number of rows.
            result.last();                 // Move to last row
            int numRows = result.getRow(); // Get row number
            result.first();                // Move to first row

            for (int row = 0; row < numRows; row++) {
            	// Add fields from database to gamesList with the values from the result set.
            	gamesList += "Match:   " + result.getString("MatchID") + ", " +
            										result.getString("Player1") + " VS " +
            										result.getString("Player2") + " \n";

               // Go to the next row in the ResultSet.
               result.next();
            
            }
		
			// close connection
            stmt.close();
            ChessResultsDBUtil.closeDBConnection(conn);
		
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
		return gamesList;
	}

	@Override
	public boolean updateChessResult(ChessResult chessResult) {
		// initialize flag
		boolean flag=false;
		
		try {
			// connect to database
			Connection conn = ChessResultsDBUtil.getDBConnection();
			
			// sql statement
			String sql = "UPDATE ChessResults SET Player1 = ? , Player2 = ? WHERE MatchID = ?;";
			
			// prepared statement object
			PreparedStatement prepStmt = conn.prepareStatement(sql);
			
			// provide the value
			prepStmt.setString(3, chessResult.getMatchID());
			prepStmt.setString(1, chessResult.getPlayer1().getPlayerName());
			prepStmt.setString(2,chessResult.getPlayer2().getPlayerName());
			
			// execute it
			int rows = prepStmt.executeUpdate();
			
			// print query result
			System.out.println(sql);
			
			// if a row has been deleted then set the flag to true
			if (rows ==1)
				flag=true;
			
			// close connection
            prepStmt.close();
            ChessResultsDBUtil.closeDBConnection(conn);
   
            // print error if needed
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
		
		// return flag
		return flag;
		
	}

}
