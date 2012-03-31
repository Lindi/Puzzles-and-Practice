package topcoder;
import java.util.*;

public class TotHello {

	private static int BLANK = 0 ;
	private static int RED = 1 ;
	private static int BLACK = 2 ;
	private static int ROWS = 8 ;
	private static int COLUMNS = 8 ;
	
	/**
	 * The game Tothello is a TopCoder modified version of the game Othello.
	 * The game is played on an 8x8 grid with two players, black and red.
	 * 
	 * This program takes an input of two string arrays, each of which
	 * specify the red and black pieces already on the board.  Each string
	 * in the array of strings is two characters long, begins with a letter (A-H)
	 * which specifies the row and ends with a number (1-8) that specifies the column
	 * 
	 * This program also takes as input the color of the current user (red or black)
	 * 
	 * This program outputs the greatest number of color changes for a given move.
	 */
	public static void main(String[] args) {
		String[] red = new String[2];
		red[0] = "A3" ;
		red[1] = "C1" ;
		String[] black = new String[2] ;
		black[0] = "A2";
		black[1] = "B1";
		int[][] board = createBoard( red, black );
		for ( int i = 0; i < ROWS; i++ ) {
			for ( int j = 0; j < COLUMNS; j++ ) {
				int color = board[i][j];
				String colorName = ( color == RED ? "Red" : ( color == BLACK ? "Black" : "__" ));
				System.out.println( "row: " + i + " column: " + j + " color: " + colorName );
			}
		}
		
		System.out.println( "findBestMoves: " + findBestMoves(board, new Piece(0,0), RED ));
	}
	
	public static int bestMove( String[] red, String[] black, String whoseTurn ) {
		int[][] board = createBoard( red, black );
		int color = ( whoseTurn == "Red" ? RED : BLACK );
		int bestMoves = -1 ;
		for ( int i = 0; i < ROWS; i++) {
			for ( int j = 0; j < COLUMNS; j++ ) {
				if ( board[i][j] == BLANK ) {
					Piece piece = new Piece( i, j );
					bestMoves = Math.max( findBestMoves( board, piece, color ), bestMoves);
				}
			}
		}
		return bestMoves ;
	}
	
	private static class Piece {
		public int row ;
		public int column ;
		public Piece( int row, int column ) {
			this.row = row ;
			this.column = column ;
		}
	}
	
	static int findBestMoves( int[][] board, Piece source, int color ) {
		List<Piece> queue = new ArrayList<Piece>();
		boolean[][] visited = new boolean[ROWS][COLUMNS] ;
		int moves = 0 ;
		int oppositeColor = ( color == RED ? BLACK : RED );
		Piece predecessor[][] = new Piece[8][8];
		queue.add(source);
		while ( queue.size() > 0 ) {
			Piece piece = queue.remove(0);
			if ( visited[piece.row][piece.column] ) continue ;
			visited[piece.row][piece.column] = true ;
			for ( int i = -1 ; i <= 1; i++) {
				for ( int j = -1; j <= 1; j++ ) {
					int row = piece.row + i ;
					int column = piece.column + j ;
					if ( row >= 0 && column >= 0 ) {
						Piece neighbor = new Piece( row, column );
						if ( board[row][column] == oppositeColor ) {
							predecessor[row][column] = piece ;
							queue.add(neighbor);
						} else if ( board[row][column] == color ) {
							do {
								neighbor = predecessor[ neighbor.row - i ][ neighbor.column - j ] ;
								if ( neighbor == null ) {
									break ;
								} else {
									row = neighbor.row ;
									column = neighbor.column ;
									moves++ ;
								}
							} while ( neighbor != source );
						}
					}
				}
			}
		}
		
		return moves ;
	}
	static int[][] createBoard( String[] red, String[] black ) {
		int[][] board = new int[ROWS][COLUMNS] ;
		populateBoard(board,red,RED);
		populateBoard(board,black,BLACK);
		return board ;
	}
	
	static void populateBoard( int[][] board, String[] pieces, int color ) {
		for ( int i = 0; i < pieces.length; i++ ) {
			String piece = pieces[i] ;
			if ( piece.length() > 0) {
				int column = (int)piece.charAt(0) - (int)'A';
				int row = (int)piece.charAt(1) - (int)'1';
				board[row][column] = color ;
			}
		}
	}
	
	
	
	
	
	//	Create a multi-dimensional array that will represent the game board
	//	The array should be a two-dimensional array of Strings?
}
