package topcoder;

import java.util.Arrays;

public class SieveOfEratosthenes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] primes = sieve( 1000 );
		for ( int i = 2; i < primes.length; i++)
		{
			if ( primes[i] )
			{
				System.out.println(i);
			}
		}
	}
	
	/**
	 * Returns an array of prime of booleans.
	 * The index of each array element whose value is true
	 * is a prime number between 1 and n
	 */
	static boolean[] sieve( int n )
	{
		boolean[] prime = new boolean[n+1];
		Arrays.fill(prime,true);
		for ( int i = 2; i * i < n; i++)
		{
			if (prime[i])
			{
				for ( int k = i*i; k <= n; k+=i)
				{
					prime[k] = false ;
				}
			}
		}
		return prime ;
	}

}
