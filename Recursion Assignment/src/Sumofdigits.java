/*
 * Sum of digits (recursive)

	Write a recursive function that returns the sum of the digits of a given integer.
	Input format :
	Integer N
	Output format :
	Sum of digits of N
	Constraints :
	0 <= N <= 10^9
	Sample Input 1 :
	12345
	Sample Output 1 :
	15
	Sample Input 2 :
	9
	Sample Output 2 :
	9
 */
import java.util.Scanner;

public class Sumofdigits {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(sumOfDigits(n));
		s.close();
	}

	private static int sumOfDigits(int n) {
		if(n==0) {
			return 0;
		}
		int smallAns = sumOfDigits(n/10);
		return smallAns+(n%10);
	}
}
