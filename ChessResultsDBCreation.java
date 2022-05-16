package edu.unlv.mis768.finalproject;

/**
 * This class creates a database with a single table for results of completed chess games
 * @author William Brasic and Sergio Torres
 */


import java.sql.*;   

public class ChessResultsDBCreation {
	   public static void main(String[] args) {
	      // Create a named constant for the URL.
	      // NOTE: This value is specific for MySQL.
	      final String DB_URL = "jdbc:mysql://localhost:3306/";
	      final String DB_CHESS_URL = "jdbc:mysql://localhost:3306/ChessResultsDB";
	      final String USERNAME = "root";
	      final String PASSWORD = "$Louie97";
	      
	      try {
	         // Create a connection to the database.
	         Connection conn =
	                DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
	            // Create the database. If the database already exists, drop it. 
	            createDataBase(conn);
	            conn.close();
	            
	         //Create a connection to the database and to the chess database   
	         Connection conn2 =
	        		 DriverManager.getConnection(DB_CHESS_URL, USERNAME, PASSWORD);
				
				// Build the Coffee table.
				buildChessResultsTable(conn2);
				
				// Build the Customer table.
//				buildChessMovesTable(conn2);
				

	         // Close the connection.
	         conn2.close();
	      } catch (Exception ex) {
	         System.out.println("ERROR: "+ ex.getMessage());
	      }
	   }

	   /**
	    * The createDatabase method creates the DB. If the DB is already existed, drop the DB first.
	    */
	   
	   public static void createDataBase(Connection conn) {
		   System.out.println("Checking for existing database.");
		   
		   try{
			   Statement stmt = conn.createStatement();
			   
			   //Drop the existing database
			   try {
				   stmt.executeUpdate("Drop DATABASE ChessResultsDB");
			   }
			   catch(SQLException ex) {
					// No need to report an error.
					// The database simply did not exist.
				}
			   //Create a new database
			   try {
				   stmt.execute("Create DATABASE ChessResultsDB");
				   //stmt.execute("USE coffee");
				   System.out.println("Database ChessResultsDB created.");
			   }
			   catch(SQLException ex) {
					// No need to report an error.
					// The database simply did not exist.
				}			   
		   }
	  	   catch(SQLException ex) {
	  		   System.out.println("ERROR: "+ ex.getMessage());
	  		   ex.printStackTrace();
			}
	   }
		
		/**
		 * This method creates a chess results table containing the matchID, winner, and loser of the game
		 * 
		 */
		public static void buildChessResultsTable(Connection conn){
			try {
	         // Get a Statement object.
	         Statement stmt = conn.createStatement();
	         
				// Create the table.
				stmt.execute("CREATE TABLE ChessResults ("+ 
	   				       "MatchID CHAR(10) NOT NULL PRIMARY KEY,"+  
	                       "Player1 CHAR(25),"+  
	                       "Player2 CHAR(25))");
								 
				// Insert data
				stmt.execute("INSERT INTO ChessResults VALUES ('1','Will', 'Sergio')");
				stmt.execute("INSERT INTO ChessResults VALUES ('2','Will', 'Sergio')");
				stmt.execute("INSERT INTO ChessResults VALUES ('3','Will', 'Sergio')");
				stmt.execute("INSERT INTO ChessResults VALUES ('4','Will', 'Sergio')");
				stmt.execute("INSERT INTO ChessResults VALUES ('5','Will', 'Sergio')");
				stmt.execute("INSERT INTO ChessResults VALUES ('6','Will', 'Sergio')");
				stmt.execute("INSERT INTO ChessResults VALUES ('7','Will', 'Sergio')");
				stmt.execute("INSERT INTO ChessResults VALUES ('8','Will', 'Sergio')");
				stmt.execute("INSERT INTO ChessResults VALUES ('9','Will', 'Sergio')");
				stmt.execute("INSERT INTO ChessResults VALUES ('10','Will', 'Sergio')");
				stmt.execute("INSERT INTO ChessResults VALUES ('11','Will', 'Sergio')");
				stmt.execute("INSERT INTO ChessResults VALUES ('12','Will', 'Sergio')");
				stmt.execute("INSERT INTO ChessResults VALUES ('13','Will', 'Sergio')");
				stmt.execute("INSERT INTO ChessResults VALUES ('14','Sergio', 'Will')");
				stmt.execute("INSERT INTO ChessResults VALUES ('15','Sergio', 'Will')");
				stmt.execute("INSERT INTO ChessResults VALUES ('16','Sergio', 'Will')");
				stmt.execute("INSERT INTO ChessResults VALUES ('17','Sergio', 'Will')");
				stmt.execute("INSERT INTO ChessResults VALUES ('18','Sergio', 'Will')");
				stmt.execute("INSERT INTO ChessResults VALUES ('19','Sergio', 'Will')");
				stmt.execute("INSERT INTO ChessResults VALUES ('20','Sergio', 'Will')");
				stmt.execute("INSERT INTO ChessResults VALUES ('21','Sergio', 'Will')");
				stmt.execute("INSERT INTO ChessResults VALUES ('22','Sergio', 'Will')");
				stmt.execute("INSERT INTO ChessResults VALUES ('23','Sergio', 'Will')");
				stmt.execute("INSERT INTO ChessResults VALUES ('24','Sergio', 'Will')");
				stmt.execute("INSERT INTO ChessResults VALUES ('25','Sergio', 'Will')");
				stmt.execute("INSERT INTO ChessResults VALUES ('26','Sergio', 'Will')");
				stmt.execute("INSERT INTO ChessResults VALUES ('27','Sergio', 'Will')");
				
				// confirmation message
				System.out.println("Chess Results Table created.");
			} catch (SQLException ex) {
	         System.out.println("ERROR: "+ex.getMessage());
			}
		}
}

