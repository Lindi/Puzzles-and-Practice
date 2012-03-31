package topcoder;

public class GreatestCommonDenominator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( gcd( 20, 15 ));
	}
	
	static int gcd( int a, int b )
	{
		int r ;
		while (( r = a % b ) > 0 )
		{
			a = b ;
			b = r ;
		}
		return b ;
	}

}
