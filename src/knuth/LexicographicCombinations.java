package knuth;

public class LexicographicCombinations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		findCombinations( 5, 3 );
	}
	
	static void findCombinations( int n, int t ) {
		int[] c = new int[n + 3];
		for (int j = 1; j <= t; j++) {
			c[j] = j - 1;
		}
		c[t + 1] = n;
		c[t + 2] = 0;

		while (true) {
			visit(c, t);
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

	static void visit(int[] c, int t) {
		String combination = "";
		for ( int j = t; j >= 1; j-- ) {
			combination += c[j];
		}
		System.out.println(combination);
	}

}
