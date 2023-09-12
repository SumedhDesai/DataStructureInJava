/*
 * Print Keypad Combinations Code

	Given an integer n, using phone keypad find out and print all the 
	possible strings that can be made using digits of input n.
	Note : The order of strings are not important. Just print different 
	strings in new lines.
	Input Format :
	Integer n
	Output Format :
	All possible strings in different lines
	Constraints :
	1 <= n <= 10^6
	Sample Input:
	23
	Sample Output:
	ad
	ae
	af
	bd
	be
	bf
	cd
	ce
	cf
 */
import java.util.Scanner;

public class PrintKeypadCombinations {
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int input = s.nextInt();
		printKeypad(input);
	}

	private static void printKeypad(int input) {
		printKeypadHelper(input,"");

	}
	private static void printKeypadHelper(int num, String stringSoFar) {
		if(num == 0 || num == 1) {
			System.out.println(stringSoFar);
			return;
		}
		int dig = num%10;
		String digStr = getStr(dig);
		int smallNum = num/10;
		for(int i=0 ;i < digStr.length() ; i++) {
			printKeypadHelper(smallNum, digStr.charAt(i)+stringSoFar);
		}
	}
	private static String getStr(int dig) {
		if(dig == 2) {
			return "abc";
		}
		if(dig == 3) {
			return "def";
		}
		if(dig == 4) {
			return "ghi";
		}
		if(dig == 5) {
			return "jkl";
		}
		if(dig == 6) {
			return "mno";
		}
		if(dig == 7) {
			return "pqrs";
		}
		if(dig == 8) {
			return "tuv";
		}
		if(dig == 9) {
			return "wxyz";
		}
		return "";
	}
}


