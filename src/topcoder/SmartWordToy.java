package topcoder;
import java.util.*;

public class SmartWordToy {

	/**
	 * SmartWordToy - SRM 233 Div 1:
	 * A word composed of four Latin lowercase letters is given. With a single button click 
	 * you can change any letter to the previous or next letter in alphabetical order 
	 * (for example 'c' can be changed to 'b' or 'd'). The alphabet is circular, thus 'a' 
	 * can become 'z', and 'z' can become 'a' with one click. 
	 * 
	 * A collection of constraints is also given, each defining a set of forbidden words. 
	 * A constraint is composed of 4 strings of letters. A word is forbidden if each of its 
	 * characters is contained in corresponding string of a single constraint, i.e. 
	 * first letter is contained in the first string, the second letter - in the second string, and so on. 
	 * For example, the constraint "lf a tc e" defines the words "late", "fate", "lace" and "face". 
	 * You should find the minimum number of button presses required to reach the word finish 
	 * from the word start without passing through forbidden words, or return -1 if this is not possible.
	 */
	public static void main(String[] args) {
		
		System.out.println( getClicks( "well", "love", "" ));
		System.out.println( getClicks( "hello", "world", "" ));
	}
	
	static int getClicks( String start, String end, String forbidden ) {
		Set<String> words = new HashSet<String>();
		List<String> queue = new ArrayList<String>();
		queue.add(start);
		int clicks = 0 ;
		while ( queue.size() > 0 ) {
			String word = queue.remove(0);
			System.out.println(word);
			if ( word.equals(end) ) {
				return clicks ;
			}
			if ( words.contains(word)) continue ;
			if ( !isForbidden(word,forbidden)) {
				words.add(word);
			}
			
			int i = 0 ;
			for ( ; i < start.length(); i++ ) {
				char c = word.charAt(i);
				if ( c == end.charAt(i))
					continue ;
				break ;
			}
			
			int n = (int)( word.charAt(i) - 'a' ) ;
			char[] neighbor = word.toCharArray();
			for ( int j = -1; j <= 1; j+=2 ) {
				char c = (char)(((( n + j ) + 26 ) % 26) + (int)'a') ;
				neighbor[i] = c ;
				queue.add( String.copyValueOf(neighbor));
			}
			clicks++ ;
		}
		return -1 ;
		
	}
	
	static boolean isForbidden( String word, String forbidden ) {
		if ( forbidden.length() > 0 ) {
			StringTokenizer tokenizer = new StringTokenizer(forbidden);
			while ( tokenizer.hasMoreTokens()) {
				int n = 4 - tokenizer.countTokens() ;
				String token = tokenizer.nextToken();
				char[] c = new char[1];
				c[0] = word.charAt(n);
				if ( !token.contains(String.valueOf(word.charAt(n)))) {
					return false ;
				}
			}
			return true ;
		}
		return false ;
	}
}
