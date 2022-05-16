package edu.unlv.mis768.finalproject;

/**
 * This class designs a single square of the chess board
 * @author William Brasic and Sergio Torres
 *
 */

public class Square {
		
		// initialization of fields to be used in Square class
	    private Piece piece;
	    private int x;
	    private int y;
	    
	    /**
	     * Constructor
	     * @param piece
	     * @param x
	     * @param y
	     */
	    public Square(Piece piece, int x, int y){
	        this.setPiece(piece);
	        this.setX(x);
	        this.setY(y);
	    }

		/**
	     * Get piece on square
	     * @return type of piece on the square
	     */
	    public Piece getPiece(){
	        return this.piece;
	    }
	  
	    /**
	     * Set piece on square
	     * @param p
	     */
	    public void setPiece(Piece p){
	        this.piece = p;
	    }
	    
	    /**This method checks if the square has a piece.
	     * 
	     * @param p piece
	     * @return
	     */
	    public boolean hasPiece() {
	    	
	    	if (this.piece != null) {
	    		return true;
	    	}
	    	else {
	    		return false;
	    	}
	    }
	    /**
	     * Get x coordinate of square
	     * @return x coordinate
	     */
	    public int getX(){
	        return this.x;
	    }
	  
	    /**
	     * Set x coordinate of square
	     * @param x
	     */
	    public void setX(int x){
	        this.x = x;
	    }
	  
	    /**
	     * Get y coordinate of square
	     * @return y coordinate
	     */
	    public int getY(){
	        return this.y;
	    }
	  
	    /**
	     * Set y coordinate of square
	     * @param y
	     */
	    public void setY(int y){
	        this.y = y;
	    }
}











