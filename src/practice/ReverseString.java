package practice;

public class ReverseString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseString("Lindi Emoungu is my name."));
		System.out.println(reverseString("no"));
		System.out.println(reverseString("I met her on a Monday and my heart stood still."));
	}
	
	public static String reverseString( String string )
	{
		int length = string.length();
		int mid = (int) Math.ceil(length/2) ;
		char[] characters = string.toCharArray();
		for ( int i = 0; i < mid; i++ )
		{
			char letter = characters[length-i-1];
			characters[length-i-1] = characters[i];
			characters[i] = letter ;
		}
		return new String(characters);
	}

}
