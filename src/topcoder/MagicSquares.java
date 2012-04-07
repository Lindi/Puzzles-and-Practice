package topcoder;
import knuth.LexicographicCombinations; 

public class MagicSquares {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int[] numbers = {1,2,3,3,2,1,2,2,2};
		int[][] combinations = LexicographicCombinations.getCombinations(numbers.length, 3);
		int[][] squares = LexicographicCombinations.getCombinations(combinations.length, 3);
		int magicSquares = 0 ;
		for ( int i = 0; i < squares.length; i++ ) {
			int[][] square = new int[3][3] ; 
			square[0] = combinations[squares[i][0]];
			square[1] = combinations[squares[i][1]];
			square[2] = combinations[squares[i][2]];
			if ( isMagicSquare( square, numbers )) {
				magicSquares++ ;
			}
		}
		System.out.println("The number of magic squares is: " + magicSquares);
	}
	
	private static boolean isMagicSquare( int[][] square, int[] numbers ) {
		int total = numbers[square[0][0]] + numbers[square[0][1]] + numbers[square[0][2]];
		for ( int i = 0; i < 3; i++ ) {
			if (( numbers[square[i][0]] + numbers[square[i][1]] + numbers[square[i][2]] ) != total ) {
				return false ;
			}
			if (( numbers[square[i][0]] + numbers[square[i+3][0]] + numbers[square[i+6][0]] ) != total) {
				return false ;
			}
		}
		return true ;
	}
	
	private static void printCombinations( int[][] combinations ) {
		for (int i = 0; i < combinations.length; i++) {
			int[] combination = combinations[i];
			LexicographicCombinations.print(combination);
		}
	}
}
