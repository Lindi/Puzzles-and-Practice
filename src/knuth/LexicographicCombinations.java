package knuth;

public class LexicographicCombinations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//printCombinations( 6, 3 );
		easyCombinations( 3 );
	}
	
	/**
	 * Todo: Refactor to work with BigInteger
	 * @param n
	 * @return
	 */
	public static int factorial( int n ) {
		int factorial = 1 ;
		while ( n > 1 ) {
			factorial *= n-- ;
		}
		return factorial ;
	}
	
	private static int[][] easyCombinations( int n ) {
		int[][] combinations = new int[n][2];
		for ( int i = 1; i < n; i++ ) {
			for ( int j = 0; j < i; j++ ) {
				int[] c = new int[2];
				c[0] = j ;
				c[1] = i ;
				print( c );
			}
		}
		return combinations ;
	}
	
	public static int choose( int n, int k ) {
		return factorial(n) / (factorial(n-k) * factorial(k));
	}
	
	public static int[][] getCombinations( int n, int t ) {
		
		//	Make a multi-dimensional array whose first dimension
		//	is equal to the total number of possible combinations
		//	and whose second dimension is equal to the size
		//	of a combination
		int[][] combinations = new int[choose( n, t )][t];
		
		//	Initialize an array to hold the current combination
		//	Spaces [0..t-1] will hold the digits of the current combination
		//	Spaces [t and t+1] will hold sentinels
		int[] c = new int[t + 2];
		
		//	Initialize the combinations array with the
		//	first combination 0, 1, .. t-1
		for (int j = 0; j < t; j++) {
			c[j] = j ;
		}
		
		//	Initialize the sentinels
		c[t] = n;
		c[t + 1] = 0;
		int counter = 0 ;
		while (true) {
			combinations[counter++] = visit(c, t);
			int j = 0;
			
			//	While the difference between subsequent
			//	position values in the current combination
			//	is 1
			while (c[j] + 1 == c[j + 1]) {
				
				//	Set each position value to the
				//	current value of j minus 1, and increment j
				//	So, for example, if the current combination
				//	being evaluated is 0, 1, 2, this would
				//	ensure that
				c[j] = j ;
				j++;
			}
			if (j == t) {
				break;
			}
			c[j]++;
		}
		
		return combinations ;
	}
	
	public static int[] visit(int[] c, int t) {
		int[] combination = new int[t];
		for ( int j = t-1; j >= 0; j-- ) {
			combination[j] = c[j];
		}
		return combination ;
	}

	static void printCombinations( int n, int t ) {
		int[] c = new int[n + 3];
		for (int j = 1; j <= t; j++) {
			c[j] = j - 1;
		}
		c[t + 1] = n;
		c[t + 2] = 0;
		while (true) {
			print(c, t);
			int j = 1;
			while (c[j] + 1 == c[j + 1]) {
				c[j] = j - 1;
				j++;
			}
			if (j > t) {
				break;
			}
			c[j]++;
		}
	}
	
	public static void print(int[] c, int t) {
		String combination = "";
		for ( int j = t; j >= 1; j-- ) {
			combination += c[j];
		}
		System.out.println(combination);
	}
	
	public static void print( int[] c) {
		String combination = "";
		for ( int j = 0; j < c.length; j++ ) {
			combination += c[j];
		}
		System.out.println(combination);
	}

}
