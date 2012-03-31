package topcoder;
import java.util.ArrayList;
import java.util.List;

public class SquareDigits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = smallestResult(112);
		System.out.printf("Result, %d: ", result);
	}

	public static int smallestResult(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		int product = 2;
		int counter = 2 ;
		List<Integer> set = new ArrayList<Integer>();
		while ((product = calculateSquare(Integer.toString(product))) != n) {
			if (set.indexOf(product) != -1) {
				set.clear();
				product = ++counter ;
			} else {
				set.add(product);
			}
			System.out.println(set);
		}
		return counter;
	}

	private static int calculateSquare(String number) {
		int sum = 0;
		for (int i = 0; i < number.length(); i++) {
			int digit = Character.digit(number.charAt(i), 10);
			sum += (digit * digit);
		}
		return sum;
	}

}
