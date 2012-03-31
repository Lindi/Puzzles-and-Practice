package topcoder;
import java.util.*;

public class HowEasy {

	static public final String POEM =
	    "Twas brillig, and the slithy toves\n" +
	    "Did gyre and gimble in the wabe.\n" +
	    "All mimsy were the borogoves,\n" +
	    "And the mome raths outgrabe.\n\n" +
	    "Beware the Jabberwock, my son,\n" +
	    "The jaws that bite, the claws that catch.\n" +
	    "Beware the Jubjub bird, and shun\n" +
	    "The frumious Bandersnatch.";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("foo".matches("\\w+"));
		System.out.println(pointVal("TwasTwasTwasTwasTwasTwasTwas brilligbrilligbrilligbrillig andandandand thethethethe slithyslithyslithy tovestovestovestoves andandandand bububububububububububububu and the soft toes"));
	}
	
	public static int pointVal(String message)
	{
		if ( message == null )
		{
			return 0 ;
		}
		
		if ( message.length() == 0 )
		{
			return 0 ;
		}
		
		StringTokenizer tokenizer = new StringTokenizer( message );
		int numberOfWords = 0 ;
		int numberOfCharacters = 0 ;
		while (tokenizer.hasMoreTokens())
		{
			String token = tokenizer.nextToken();
			if ( token.matches("\\w+"))
			{
				numberOfWords++ ;
				numberOfCharacters += token.length();
			} else {
				return 0 ;
			}
		}
		int averageWordLength = numberOfCharacters / numberOfWords ;
		if ( averageWordLength <= 3 )
		{
			return 250 ;
		} else if ( averageWordLength <= 5 )
		{
			return 500 ;
		}
		return 1000 ;
	}
}
