package edu.unlv.mis768.finalproject;
/**
 * This is class is for moving a piece
 * @author William Brasic and Sergio Torres
 *
 */

public class Move {
	
	// initialize fields
    private Player player;
    private Square startingSquare;
    private Square endingSquare;
    private Piece killedPiece;
    //private boolean castlingMove = false;
  
    /**
     * Constructor
     * @param player
     * @param start
     * @param end
     */
    public Move(Player player, Square startingSquare, Square endingSquare)
    {
        this.player = player;
        this.startingSquare = startingSquare;
        this.endingSquare = endingSquare;
    }
    
    /**
     * Getter for starting square
     * @return starting square
     */
	public Square getStartingSquare() {
		return startingSquare;
	}

	/**
	 * Setter for starting square
	 * @param startingSquare
	 */
	public void setStartingSquare(Square startingSquare) {
		this.startingSquare = startingSquare;
	}
	
	/**
	 * Getter for ending square
	 * @return ending square
	 */
	public Square getEndingSquare() {
		return endingSquare;
	}

	/**
	 * Setter for ending square
	 * @param endingSquare
	 */
	public void setEndingSquare(Square endingSquare) {
		this.endingSquare = endingSquare;
	}
	
	/**
	 * Method for getting a killed piece
	 * @return the piece that has been killed
	 */
	public Piece getKilledPiece() {
		return killedPiece;
	}

	/**
	 * Method for setting the piece that has been killed
	 * @param killedPiece
	 */
	public void setKilledPiece(Piece killedPiece) {
		this.killedPiece = killedPiece;
	}
    
    
  

}
