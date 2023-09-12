package exceptionHandling;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int num = s.nextInt();
		int den = s.nextInt();

		try {
			System.out.println(devide(num, den));
		} catch (DevidebyZero e) {
			System.out.println("devide by zero exception");
		}
		finally {
			s.close();
		}
	}

	private static int devide(int num, int den) throws DevidebyZero  {
		if(den==0) {
			throw new DevidebyZero();
		}
		return num/den;
	}

}
