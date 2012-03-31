package practice;

public class InsertionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[50];
		for ( int i = 0; i < array.length; ++i)
		{
			array[i] = (int)(Math.random() * 10);
			System.out.print(array[i]);
		}
		insertionSort( array );
		System.out.println("");
		for ( int i = 0; i < array.length; ++i)
		{
			System.out.print(array[i]);
		}
		
	}
	
	static void insertionSort( int[] array ) {
		if ( array == null )
		{
			return ;
		}
		if ( array.length == 0 )
		{
			return ;
		}
		for ( int i = 1; i < array.length; i++)
		{
			int value = array[i];
			int j = i - 1 ;
			while ( j >= 0 && array[j] < value )
			{
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = value ;
		}
	}

}
