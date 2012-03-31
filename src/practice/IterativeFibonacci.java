package practice;

public class IterativeFibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibonacci(3));
	}

	/*
	 * Find the nth Fibonacci number
	 * http://www.ics.uci.edu/~eppstein/161/960109.html
	 */
	static int fibonacci(int n) {
	    int f[] = new int[n+1];
	    f[0] = 0 ;
	    f[1] = f[2] = 1;
	    for (int i = 3; i <= n; i++)
	        f[i] = f[i-1] + f[i-2];
	    return f[n];
	}
}
