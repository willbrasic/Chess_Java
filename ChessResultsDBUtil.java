package edu.unlv.mis768.finalproject;

/**
 * This class establishes connection to the ChessResultsDB
 */

import java.sql.*;

public class ChessResultsDBUtil {
	/**
	 * This method establishes the DB connection
	 * @return a database connection
	 */
	public static Connection getDBConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ChessResultsDB", "root", "ENTER PASSWORD");
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}

		return conn;
		
	}

	/**
	 * This method closes the DB connection
	 * @param the connection to be closed
	 */
	public static void closeDBConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception ex) {
				System.out.println("ERROR: " + ex.getMessage());
			}
		}
	}

	
}

