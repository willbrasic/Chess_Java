package edu.unlv.mis768.finalproject;

/**
 * This class is used for Chess Results Database
 * @author William Brasic and Sergio Torres
 *
 */

public class ChessResult {
	
	// initialize fields
	private String matchID; 
	private Player player1;
	private Player player2;
	
	// No arg constructor
	public ChessResult() {
		
	}
	
	/**
	 * Constructor
	 * @param matchID
	 * @param player1
	 * @param player2
	 */
	public ChessResult(String matchID, Player player1, Player player2){
		this.matchID = matchID;
		this.player1 = player1;
		this.player2 = player2;
	}
	
	/**
	 * All String constructor for generating chess result and converting to proper field types.
	 * @param match
	 * @param play1
	 * @param play2
	 */
	public ChessResult(String match, String play1, String play2) {
		matchID = match;
		player1.setPlayerName(play1);
		player2.setPlayerName(play2);
	}

	/**
	 * Getter for matchID
	 * @return matchID
	 */
	public String getMatchID() {
		return matchID;
	}
	
	/**
	 * Setter for matchID
	 * @param matchID
	 */
	public void setMatchID(String matchID) {
		this.matchID = matchID;
		
	}
	
	/**
	 * Getter for player1
	 * @return player1
	 */
	public Player getPlayer1() {
		return player1;
	}
	
	/**
	 * Setter for player1
	 * @param player1
	 */
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}
	
	/**
	 * Getter for player2
	 * @return player2
	 */
	public Player getPlayer2() {
		return player2;
	}
	
	/**
	 * Setter for player2
	 * @param player2
	 */
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	
	
	
	
}
