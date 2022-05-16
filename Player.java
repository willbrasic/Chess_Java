package edu.unlv.mis768.finalproject;

/**
 * This is the player class for the chess game
 * @author William Brasic and Sergio Torres
 *
 */

public class Player {
	
	// initialize fields
	public String playerName;
	public boolean whitePlayer;
	
	/**
	 * Getter for player name
	 * @return playerName
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * Setter for player name
	 * @param playerName
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	/**
	 * Constructor
	 * @param playerName
	 */
	public Player(String playerName) {
		this.playerName = playerName;
	}
	
	/**
	 * Determine if player is white or not
	 * @return boolean if player is white; false otherwise
	 */
	public boolean isWhitePlayer() {
		
		return this.whitePlayer;
	}
	
	

}
