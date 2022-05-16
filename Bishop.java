package edu.unlv.mis768.finalproject;

/**
 * This class designs the bishop.
 * @author William Brasic and Sergio Torres
 *
 */

public class Bishop extends Piece {
	
	/**
	 * Constructor for bishop class
	 * @param whitePiece
	 */
	public Bishop(boolean whitePiece){
        super(whitePiece);
    }
  
    /**
     * This method determines if the bishop can legally make the move.
     * @param board
     * @param start
     * @param end
     * @return boolean value if legal move; false otherwise
     */
    public boolean legalMove(ChessBoard board, Square start, Square end){
        
    	// if the piece at Square end is the same color as the bishop trying to move, return false, i.e., cannot move
        if (end.hasPiece()) {
        	if (end.getPiece().isWhitePiece() == this.isWhitePiece()) {
            return false;
        	}
        }
        // move is legal if and only if the bishop moves the same amount horizontally as vertically
        return Math.abs(start.getX() - end.getX()) == Math.abs(start.getY() - end.getY());
        
    }
}
