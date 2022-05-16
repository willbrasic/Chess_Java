package edu.unlv.mis768.finalproject;

/**
 * This class designs the King
 * @author William Brasic and Sergio Torres
 *
 */

public class King extends Piece {
//	private boolean castlingComplete = false;
	 
	/**
	 * Constructor for king
	 * @param whitePiece
	 */
    public King(boolean whitePiece){
        super(whitePiece);
       
    }
  
//    public boolean isCastlingComplete(){
//        return this.castlingComplete;
//    }
//  
//    public void setCastlingComplete(boolean castlingComplete){
//        this.castlingComplete = castlingComplete;
//    }
    
    /**
     * Method for determining if the king move is legal
     * @param board
     * @param start
     * @param end
     * @return boolean value if legal move; false otherwise
     */
    public boolean legalMove(ChessBoard board, Square start, Square end){
    	
    	// if the piece at Square end is the same color as the king trying to move, return false, i.e., cannot move
        if (end.hasPiece()) {
        	if (end.getPiece().isWhitePiece() == this.isWhitePiece()) {
            return false;
        	}
        }
        // move is legal if and only if the king moves one spot
        return Math.abs(start.getX() - end.getX()) + Math.abs(start.getY() - end.getY()) == 1;
  
        // return this.isValidCastling(board, start, end);
    }
  
//    private boolean isValidCastling(ChessBoard board, Square start, Square end){
//  
//        if (this.isCastlingComplete()) {
//            return false;
//        }
//  
//        // castle logic for returning true or false
//    }
  
//    public boolean isCastlingComplete(Square start, Square end){
//        // check if the starting and 
//        // ending position are correct
//    }
}
