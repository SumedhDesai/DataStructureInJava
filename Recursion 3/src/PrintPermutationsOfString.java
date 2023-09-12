/*
 * Print Permutations of a String

	Given a string, find and print all the possible permutations of 
	the input string.
	Note : The order of permutations are not important. Just print 
	them in different lines.
	Sample Input :
	abc
	Sample Output :
	abc
	acb
	bac
	bca
	cab
	cba
 */
import java.util.Scanner;

public class PrintPermutationsOfString {
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		String input = s.nextLine();
		permutations(input);
	}

	private static void permutations(String input) {
		permutationsHelper(input,"");
	}

	private static void permutationsHelper(String input, String str) {
		if(input.length()==0) {
			System.out.println(str);
			return;
		}
		for(int i=0; i<input.length(); i++) {
		permutationsHelper(input.substring(0,i)+input.substring(i+1), str+input.charAt(i));
		}
	}
}
