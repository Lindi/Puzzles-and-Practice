package topcoder;

public class TallPeople {

	/**
	 * TallPeople - SRM 208 Div 1:
	 * A group of people stands before you arranged in rows and columns. 
	 * Looking from above, they form an R by C rectangle of people. 
	 * Your job is to return 2 specific heights - the first is computed by 
	 * finding the shortest person in each row, and then finding 
	 * the tallest person among them (the "tallest-of-the-shortest"); 
	 * and the second is computed by finding the tallest person in each column, 
	 * and then finding the shortest person among them (the "shortest-of-the-tallest").
	 */
	public static void main(String[] args) {
		//	Sort each row, and add the lowest value in each row
		//	to the tallestOfTheShortest list.  
		//	Sort the tallestOfTheShortest. The highest value
		//	is the tallest of the shortest
		
		//	Sort each column, and add the highest value in each column
		//	to the shortestOfTheTallest list.
		//	Sort the shortestOfTheTallest list.  The lowest value
		//	is the shortest of the tallest
		
		//	For now, let's test our implementation of mergeSort
		//	to make sure it works
		int[] a = new int[10];
		System.out.println("Unmerged array: ");
		for ( int i = 0; i < a.length; i++) {
			a[i] = (int)(Math.random() * a.length) ;
			System.out.print(a[i]);
		}
		mergeSort( a, 0, a.length-1);
		System.out.println("\nmerged array: ");
		for ( int i = 0; i < a.length; ++i)
		{
			System.out.print(a[i]);
		}
	}
	
	static void mergeSort( int[] a, int p, int q ) {
		if ( p < q ) {
			int r = ( p + q ) / 2 ;
			mergeSort( a, p, r );
			mergeSort( a, r+1, q );
			merge( a, p, r, q );
		}
	}
	
	static void merge( int[] a, int p, int q, int r ) {
		int n1 = q - p + 1 ;
		int n2 = r - q ;
		int[] left = new int[n1+1];
		int[] right = new int[n2+1];
		for ( int i = 0; i < n1; i++ ) {
			left[i] = a[p+i];
		}
		for ( int i = 0; i < n2; i++ ) {
			right[i] = a[q+1+i];
		}
		
		//	Define sentinels to mark the end of the list
		left[n1] = -1 ;
		right[n2] = -1 ;
		
		//	Iterate over the section of the array we're
		//	sorting, and place the current value of the left array
		//	if it's less than the current value of the right array
		//	and vice versa
		for ( int i = 0, j = 0, k = p; k <= r; k++) {
			if ( compare( left[i], right[j] ) <= 0 ) {
				a[k] = left[i++] ;
			} else {
				a[k] = right[j++] ;
			}
 		}
	}
	
	/**
	 * This function is necessary to ensure that the sentinel
	 * value of -1 isn't inserted into the list ;
	 * @param x
	 * @param y
	 * @return
	 */
	static int compare( int x, int y ) {
		if ( x == -1 )
		{
			if ( y == -1 ) {
				
				//	If both x and y are the sentinel value
				//	they're equal, so return 0
				return 0 ;
			}
			
			//	If y is not -1, y is greater
			//	so return 1
			return 1 ;
		} else if ( y == -1 ) {
			
			//	If x is not -1 and y is negative one
			//	then y is less than x, so return -1
			return -1 ;
		}
		if ( x < y ) {
			
			//	If y is greater than x, return 1
			return 1 ;
		} else if ( x > y ) {
			
			//	If y is less than x, return -1 
			return -1 ;
		} else {
			
			//	If x and y are equal, return 0 ;
			return 0 ;
		}
	}
}
