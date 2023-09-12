/*
 * Fibonacci Number by recursion
 */
import java.util.Scanner;

public class FibonacciNumber {

	public static void main(String[] args) {
		
		Scanner s= new Scanner(System.in);
		int n = s.nextInt();
		
		System.out.println(fibo(n));
		s.close();
	}

	private static int fibo(int n) {
		if(n==0) {
			return 0;
		}
		if (n==1 || n==2) {
			return 1;
		}
		int output=fibo(n-1)+fibo(n-2);
		
		return output;
	}

}
