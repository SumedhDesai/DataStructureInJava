/*
 * Print factorial function
 */
public class PrintFactorialFunction {

	public static void main(String[] args) {
		
		factorial(5 , 1);

	}

	private static void factorial(int num, int ans) {
		if(num==0) {
			System.out.println(ans);
			return;
		}
		ans = ans*num;
		factorial(num-1, ans);
	}

}
