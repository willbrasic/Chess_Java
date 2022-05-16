package edu.unlv.mis768.finalproject;

/**
 * This class designs the knight
 * @author William Brasic and Sergio Torres
 *
 */

public class Knight extends Piece {
	

	/**
	 * Constructor
	 * @param whitePiece
	 */
	public Knight(boolean whitePiece){
        super(whitePiece);
    }
  
    /**
     * This method determines if the knight can legally make the move.
     * @param board
     * @param start
     * @param end
     * @return boolean value if legal move; false otherwise
     */
    public boolean legalMove(ChessBoard board, Square start, Square end){
        
    	// if the piece at Square end is the same color as the knight trying to move, return false, i.e., cannot move
        if (end.hasPiece()) {
        	
        	if(end.getPiece().isWhitePiece() == this.isWhitePiece()) {
        		return false;
        	}
        }
        
        // move is legal if and only if the distance between x_1 and x_2 times the distance between y_1 and y_2 equals 2
        return Math.abs(start.getX() - end.getX()) * Math.abs(start.getY() - end.getY()) == 2;
        
    
    }	
}
