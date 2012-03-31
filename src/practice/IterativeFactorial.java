package practice;

public class IterativeFactorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(factorial(3));
	}

	static int factorial( int n )
	{
		if ( n == 0 ) return 1 ;
		int factorial = 1 ;
		while ( n > 0 ) {
			factorial *= n-- ;
		}
		return factorial ;
	}
}
