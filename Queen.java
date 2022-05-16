package edu.unlv.mis768.finalproject;

/**
 * This class designs the queen
 * @author William Brasic and Sergio Torres
 *
 */

public class Queen extends Piece{
	
	/**
	 * Constructor 
	 * @param whitePiece
	 */
	public Queen(boolean whitePiece){
        super(whitePiece);
    }
  
    /**
     * This method determines if the queen can legally make the move.
     * @param board
     * @param start
     * @param end
     * @return boolean value if legal move; false otherwise
     */
    public boolean legalMove(ChessBoard board, Square start, Square end){
    	
    	// if the piece at Square end is the same color as the queen trying to move, return false, i.e., cannot move
        if (end.hasPiece()) {
        	if (end.getPiece().isWhitePiece() == this.isWhitePiece()) {
            return false;
        	}	
        }
        // if the queen tries to move as a rook would, we have a valid move
        if ((start.getX() == end.getY()) || start.getY() == end.getY())
        	return true;
        
        // if the queen tries to move as the bishop would, we have a valid move
        else if (Math.abs(start.getX() - end.getX()) == Math.abs(start.getY() - end.getY()))
        	return true;
        
        // otherwise, we have an invalid move
        else
        	return false;
        
    }

}
