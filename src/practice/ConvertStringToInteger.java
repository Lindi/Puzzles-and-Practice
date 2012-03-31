package practice;

public class ConvertStringToInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = convertStringToInteger("-101");
		System.out.println( number == -101 );
	}
	
	static int convertStringToInteger( String string )
	{
		int number = 0 ;
		char[] digits = string.toCharArray();
		int length = digits.length - 1 ;
		int startOfNumber = 0;
		boolean numberIsNegative = false ;
		if ( digits[0] == '-') {
			numberIsNegative = true ;
			++startOfNumber ;
		}
		for ( int i = length; i >= startOfNumber; i-- )
		{
			int digit = (int)digits[i] - '0';
			number += digit * Math.pow(10, length-i);
		}
		if (numberIsNegative) return number * -1 ;
		return number ;
	}

}
