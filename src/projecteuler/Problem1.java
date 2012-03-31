package projecteuler;

public class Problem1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0 ;
		for ( int i = 1; i < 1000; i++ )
		{
			sum += ( i % 3 == 0 ? i : ( i % 5 == 0 ? i : 0 ));
		}
		System.out.printf("Sum: %d", sum);
	}

}
