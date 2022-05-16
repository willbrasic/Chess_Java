package edu.unlv.mis768.finalproject;

/**
 * This is the generic piece class. Specific pieces will inherit the attributes from this Piece class
 * @author William Brasic and Sergio Torres
 *
 */

public abstract class Piece {
	
	// initialization of fields
	private boolean killedPiece = false;
	private boolean whitePiece = false;
	
	/**
	 * Constructor for Piece abstract class
	 * @param whitePiece
	 */
	public Piece(boolean whitePiece) {
		this.setWhitePiece(whitePiece);
	}
	
	
	/**
	 * White Piece Setter
	 * @param whitePiece
	 */
	public void setWhitePiece(boolean whitePiece) {
		this.whitePiece = true;
	}
	
	/**
	 * Determine if piece is white
	 * @return boolean if piece is white
	 */
	public boolean isWhitePiece() {
		return this.whitePiece;
	}
	
	/**
	 * Set killed piece
	 * @param killedPiece
	 */
	public void setKilledPiece(boolean killedPiece) {
		this.killedPiece = true;
	}

	/**
	 * Determine if piece is killed
	 * @param killedPiece
	 * @return boolean if piece killed
	 */
	public boolean isKilledPiece(boolean killedPiece) {
		return this.killedPiece;
	}
	
	/**
	 * This method will be overwritten by each individual piece
	 * @param board
	 * @param start
	 * @param end
	 * @return boolean value if the move is legal
	 */
	public abstract boolean legalMove(ChessBoard board, Square start, Square end);

}








