package edu.unlv.mis768.finalproject;

/**
 * This class designs the chess board
 * @author William Brasic and Sergio Torres
 *
 */

public class ChessBoard {
	// Initialize an array for each square
    private Square[][] square = new Square[8][8];
    
    /**No arg constructor.
     * This method sets all pieces on the chess board, i.e., puts all pieces in their starting position.
     */
    public ChessBoard(){
    	// Initialize array values for each square if constructor called.
        
        
    	//-------------------//
        //--- White Pieces---//
        //-------------------//
    	
    	// set white pawns
    	square[6][0] = new Square(new Pawn(true), 6, 0);
        square[6][1] = new Square(new Pawn(true), 6, 1);
        square[6][2] = new Square(new Pawn(true), 6, 2);
        square[6][3] = new Square(new Pawn(true), 6, 3);
        square[6][4] = new Square(new Pawn(true), 6, 4);
        square[6][5] = new Square(new Pawn(true), 6, 5);
        square[6][6] = new Square(new Pawn(true), 6, 6);
        square[6][7] = new Square(new Pawn(true), 6, 7);
        
        // set white rooks
        square[7][0] = new Square(new Rook(true), 7, 0);
        square[7][7] = new Square(new Rook(true), 7, 7);
        
        // set white knights
        square[7][1] = new Square(new Knight(true), 7, 1);
        square[7][6] = new Square(new Knight(true), 7, 6);
        
        // set white bishops
        square[7][2] = new Square(new Bishop(true), 7, 2);
        square[7][5] = new Square(new Bishop(true), 7, 5);
        
        // set white queen
        square[7][3] = new Square(new Queen(true), 7, 3);
        
        // set white king
        square[7][4] = new Square(new King(true), 7, 4);
        
        //-------------------//
        //--- Black Pieces---//
        //-------------------//
        
        // set black pawns
    	square[1][0] = new Square(new Pawn(false), 1, 0);
        square[1][1] = new Square(new Pawn(false), 1, 1);
        square[1][2] = new Square(new Pawn(false), 1, 2);
        square[1][3] = new Square(new Pawn(false), 1, 3);
        square[1][4] = new Square(new Pawn(false), 1, 4);
        square[1][5] = new Square(new Pawn(false), 1, 5);
        square[1][6] = new Square(new Pawn(false), 1, 6);
        square[1][7] = new Square(new Pawn(false), 1, 7);
        
        // set black rooks
        square[0][0] = new Square(new Rook(false), 0, 0);
        square[0][7] = new Square(new Rook(false), 0, 7);
        
        // set black knights
        square[0][1] = new Square(new Knight(false), 0, 1);
        square[0][6] = new Square(new Knight(false), 0, 6);
        
        // set black bishops
        square[0][2] = new Square(new Bishop(false), 0, 2);
        square[0][5] = new Square(new Bishop(false), 0, 5);
        
        // set black queen
        square[0][3] = new Square(new Queen(false), 0, 3);
        
        // set black king
        square[0][4] = new Square(new King(false), 0, 4);
  
        // set the remaining squares to null since they are empty upon board reset
        for (int i = 2; i <= 5; i++) {
            for (int j = 0; j <= 7; j++) {
                square[i][j] = new Square(null,i,j);
            }
        }
    }
    
    /**
     * @param x
     * @param y
     * @return
     * @throws Exception
     */
    public Square validSquare(int x, int y) throws Exception {
    	
    	// since the board axis goes from 0 to 7 on each side, throw an exception if either x or y is not in this interval
        if ((x > 7) || (y > 7)) {
            throw new Exception("Invalid square");
        }
        // if the above statement goes to false, set the square as desired
        else
        	return square[x][y];
    }

}
