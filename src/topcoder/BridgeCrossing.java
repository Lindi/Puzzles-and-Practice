package topcoder;
import knuth.LexicographicCombinations; ;

public class BridgeCrossing {

	/**
	 * BridgeCrossing - SRM 146 Div 2 (3rd problem): A group of people is crossing an old bridge. 
	 * The bridge cannot hold more than two people at once. It is dark, so they can't walk without 
	 * a flashlight, and they only have one flashlight! Furthermore, the time needed to cross 
	 * the bridge varies among the people in the group. When people walk together, 
	 * they always walk at the speed of the slowest person. 
	 * It is impossible to toss the flashlight across the bridge, 
	 * so one person always has to go back with the flashlight to the others. 
	 * What is the minimum amount of time needed to get all the people across the bridge? 
	 * There are at most 6 people.
	 * 
	 * Generate all 6-choose-2 k-combinations of choosing 2 items from a set of
	 * 6 items.
	 * 
	 * For each pair in the set of combinations ...
	 * Add the maximum (slowest) time it will take for a given pair to cross the bridge
	 * Add the minimum (slowest) time of that pair for the return time
	 * Repeat this for each pair in the set of combinations that does not contain a member in the
	 * set of members across the bridge
	 * 
	 * We can use a more straightforward method of generating the combinations
	 * since we know there will be at most 6 people.  We can do something like this
	 * for ( int i = 0; i < n; i++ ) {
	 * 	for( int j = 0; j < n; j++ ) {
	 * 		if ( j == 1 ) continue ;
	 * 		...	mark pair
	 * }
	 * }
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
