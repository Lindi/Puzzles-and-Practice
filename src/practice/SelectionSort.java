package practice;


public class SelectionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[5] ;
		for ( int i = 0; i < array.length; i++ )
		{
			array[i] = (int)(Math.random() * 10);
		}
		for ( int i = 0; i < array.length; i++ )
		{
			System.out.print(array[i]);
		}
		selectionSort( array );
		System.out.println("\n");
		for ( int i = 0; i < array.length; i++ )
		{
			System.out.print(array[i]);
		}
	}
	
	
	static void selectionSort( int[] array ) {
		int i = array.length - 1 ;
		while ( i > 0 )
		{
			int j = i ;
			for ( int k = 0; k < i; k++ )
			{
				if ( array[k] > array[j] )
				{
					j = k ;
				}
			}
			int temp = array[i] ;
			array[i] = array[j] ;
			array[j] = temp ;
			i-- ;
		}
	}

}
