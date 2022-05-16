package edu.unlv.mis768.finalproject;

/**
 * This class designs the pawn piece
 * @author William Brasic and Sergio Torres
 *
 */

public class Pawn extends Piece{


	/**
	 * Constuctor for pawn class
	 * @param whitePiece
	 */
	public Pawn(boolean whitePiece){
        super(whitePiece);
    }
  
    /**
     * This method determines if the pawn can legally make the move.
     * @param board
     * @param start
     * @param end
     * @return boolean value if legal move; false otherwise
     */
    public boolean legalMove(ChessBoard board, Square start, Square end){
        boolean flag = true;
    	
        if (end.hasPiece()) {
        	// if the piece at Square end is the same color as the pawn trying to move, return false, i.e., cannot move
        	if (end.getPiece().isWhitePiece() == this.isWhitePiece()) {
        		flag = false;
        	}
        
        	// white pawn can move one space diagonally if it is trying to take black piece
        	else if ((end.getPiece().isWhitePiece()) && (this.isWhitePiece()) && 
        			(Math.abs(start.getX() - end.getX()) == 1) && 
        			(Math.abs(start.getY() - end.getY()) == 1))
        		flag = true;
        
        	// black pawn can move one space diagonally if it is trying to take white piece
        	else if ((end.getPiece().isWhitePiece()) && (!this.isWhitePiece()) && 
        			(Math.abs(start.getX() - end.getX()) == 1) && 
        			(Math.abs(start.getY() - end.getY()) == 1))
        		flag = true;
        }
        // if pawn is just trying to move regularly, it can do so if and only if it moves one space up vertically
        else if ((Math.abs(start.getX() - end.getX()) == 0) && (Math.abs(start.getY() - end.getY()) == 1)) {
        	flag = true;
        }
        // otherwise, pawn can only move 
        return flag;
        
    }
}
