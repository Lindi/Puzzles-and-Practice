package practice;

public class ConvertIntegerToString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String number = convertIntegerToString(-345);
		System.out.println(number);
		System.out.println( number.equals("-345"));

		number = convertIntegerToString(209845743);
		System.out.println(number);
		System.out.println( number.equals("209845743"));

	}
	
	static String convertIntegerToString( int number ) {
		if ( number == 0 ) return "0" ;
		boolean numberIsNegative = ( number < 0 );
		StringBuffer stringBuffer = new StringBuffer();
		number = Math.abs(number);
		int counter = 0;
		while ( number > 0 ) {
			//	Take the modulus of the number and 10, 100, 1000
			//	and subtract the remainder each time until
			//	the number equals 0
			
			//	Divide the remainder by mod / 10 to get the digit
			//	So, for example, if the remainder is 40, the digit is
			//	4, which is 40 / ( 100 / 10 );
			int mod = (int)Math.pow(10, ++counter);
			int remainder = (int)(number % mod);
			int digit = remainder / (mod / 10) ;
			stringBuffer.append(digit);
			number -= remainder ;
		}
		
		String string = stringBuffer.toString();
		char[] digits = string.toCharArray();
		int start = 0;
		int end = string.length() - 1 ;
		while ( end > start ) {
			char digit = digits[end];
			digits[end] = digits[start];
			digits[start] = digit ;
			end-- ;
			start++ ;
		}
		if (numberIsNegative) return "-" + new String( digits );
		return new String( digits );
	}

}
