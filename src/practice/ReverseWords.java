package practice;

public class ReverseWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseWords("Lindi Emoungu is my name"));

	}
	
	public static String reverseWords( String string )
	{
		if ( string == null )
		{
			return null ;
		}
		if ( string.length() == 0 ) 
		{
			return "" ;
		}
		int A = (int)'A';
		int Z = (int)'Z';
		int a = (int)'a';
		int z = (int)'z';
		
		int length = string.length();
		int endOfWord = length - 1 ;
		StringBuffer stringBuffer = new StringBuffer();
		for ( int i = length - 1; i >= 0; i-- )
		{
			char letter = string.charAt(i);
			int c = (int)letter ;
			if (!(( c >= A && c <= Z ) || ( c >= a && c <= z )) || i == 0)
			{
				if ( i > 0 )
				{
					//	Copy the word into the string buffer
					for ( int j = i+1; j <= endOfWord; j++ ) {
						stringBuffer.append(string.charAt(j));
					}
					stringBuffer.append(letter);
					endOfWord = i-1 ;
				} else {
					for ( int j = 0; j <= endOfWord; j++ ) {
						stringBuffer.append(string.charAt(j));
					}					
				}
			}
		}
		
		return stringBuffer.toString(); 
	}

}
