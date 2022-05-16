package edu.unlv.mis768.finalproject;

/**
 * This class designs the rook
 * @author William Brasic and Sergio Torres
 *
 */

public class Rook extends Piece{
	
	/**
	 * Constructor
	 * @param whitePiece
	 */
	public Rook(boolean whitePiece){
        super(whitePiece);
    }
  
    /**
     * This method determines if the rook can legally make the move.
     * @param board
     * @param start
     * @param end
     * @return boolean value if legal move; false otherwise
     */
    public boolean legalMove(ChessBoard board, Square start, Square end){
        
    	// if the piece at Square end is the same color as the rook trying to move, return false, i.e., cannot move
        if (end.hasPiece()) {
        	if(end.getPiece().isWhitePiece() == this.isWhitePiece()) {
            return false;
        	}
        }
        // legal move if and only if x_1 equals x_2 or y_1 equals y_2
        return ((start.getX() == end.getX()) || (start.getY() == end.getY()));
        
    }
}
