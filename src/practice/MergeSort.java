package practice;

public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int[] array = new int[10];
		for ( int i = 0; i < array.length; ++i)
		{
			array[i] = (int)(Math.random() * 10);
			System.out.print(array[i]);
		}
		mergeSort( array, 0, array.length - 1 );
		System.out.println("\nmered array");
		for ( int i = 0; i < array.length; ++i)
		{
			System.out.print(array[i]);
		}

	}
	
	static void mergeSort( int[] array, int p, int q )
	{
		if ( array == null )
		{
			return ;
		}
		if ( p < q )
		{
			//	Josh Bloch might shift the argument to 
			//	Math.floor to the right >> instead of
			//	dividing to avoid possible overflow errors
			int mid = (p+q)/2;
			mergeSort( array, p, mid );
			mergeSort( array, mid+1, q );
			merge( array, p, mid, q );
		}
		
	}
	
	static void merge(int[] array, int p, int q, int r)
	{
		//	This is the number of items in the left list
		//	p is the start index
		//	q is the floor of the mid index mid index
		//	r is the end index 
		
		//	For even numbered lists, the left list will have
		//	one more than the number of items in the right list
		//	For example, for a list of 5 items, where p = 0 and r = 4
		//	q will be 2.  The left list will contain items 0, 1 and 2
		//	and the right list will contain items 3 and 4
		
		//	For odd numbered lists, the left and right lists will
		//	have the same number of items.  For example, for a list
		//	of 6 items, where p = 0 and r = 5, q will be 2 such that
		//	the left list will contain items 0, 1 and 2 and the
		//	right list will contain items 3, 4 and 5
		int n1 = q - p + 1 ;
		int n2 = r - q ;
		int[] left = new int[n1+1];
		int[] right = new int[n2+1] ;
		
		//	We're sorting positive integers
		left[n1] = -1 ;
		right[n2] = -1 ;
		
		//	Fill up the left array
		for ( int i = 0; i < n1; i++ )
		{
			left[i] = array[p+i] ;
		}
		
		//	Fill up the right array
		for ( int i = 0; i < n2; i++)
		{
			right[i] = array[q+i+1];
		}
		
		//	
		for ( int i = 0, j = 0, k = p; k <= r; k++) {
			if ( compare( left[i], right[j] ) <= 0 ) {
				array[k] = left[i++] ;
			} else {
				array[k] = right[j++] ;
			}
 		}
	}
	
	static int compare( int x, int y ) {
		if ( x == -1 )
		{
			if ( y == -1 ) {
				return 0 ;
			}
			return 1 ;
		} else if ( y == -1 ) {
			return -1 ;
		}
		if ( x < y ) {
			return 1 ;
		} else if ( x > y ) {
			return -1 ;
		} else {
			return 0 ;
		}
	}
}
