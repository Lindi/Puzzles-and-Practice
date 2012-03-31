package projecteuler;

import java.math.BigInteger;
import java.util.*;

public class Problem3 {

	/**
	 * The prime factors of 13195 are 5, 7, 13 and 29.
	 * What is the largest prime factor of the number 600851475143 ?
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BigInteger bigInteger = new BigInteger("600851475143");
//		BigInteger a = new BigInteger("2");
//		System.out.println(a.multiply(a));
		
		List<Integer> factors = getPrimeFactors(bigInteger);
		System.out.println(factors);
//		List<Integer> factors = getPrimeFactors(13195);
	}
	
	private static List<Integer> getPrimeFactors(BigInteger n)
	{	
		List<Integer> factors = new ArrayList<Integer>();
		for (int i = 2; n.compareTo(new BigInteger(Integer.toString(i)).multiply(new BigInteger(Integer.toString(i)))) == 1; i++ )
		{
			if ( n.mod(new BigInteger(new Integer(i).toString())).compareTo(new BigInteger("0")) == 0 && isPrime(i))
			{
				factors.add(i);
			}
//			System.out.println(new BigInteger(Integer.toString(i)).multiply(new BigInteger(Integer.toString(i))));
		}
		return factors ;
	}
	private static List<Integer> getPrimeFactors(int n)
	{	
		List<Integer> factors = new ArrayList<Integer>();
		for (int i = 2; i * i <= n; i++ )
		{
			if ( n % i == 0 && isPrime(i))
			{
				factors.add(i);
			}
		}
		return factors ;
	}
	
	private static boolean isPrime( int n )
	{
		for ( int i = 2; i * i <= n; i++ )
		{
			if ( n % i == 0 )
			{
				return false ;
			}
		}
		
		return true ;
	}

}
