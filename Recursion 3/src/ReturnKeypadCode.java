/*
 * Return Keypad Code

	Given an integer n, using phone keypad find out all the possible 
	strings that can be made using digits of input n.
	Return empty string for numbers 0 and 1.
	Note : 1. The order of strings are not important.
	2. Input and output has already been managed for you. You just have 
	to populate the output array and return the count of elements populated 
	in the output array.
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

public class ReturnKeypadCode {
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int input = s.nextInt();
		String output[] = keypad(input);
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}

	private static String[] keypad(int num) {
		if(num==0 || num==1) {
			String[] ans = new String[1];
			ans[0] = "";
			return ans;
		}
		String[] smallAns = keypad(num/10);
		int dig = num%10;
		String digStr = getStr(dig);
		String[] ans = new String[smallAns.length*digStr.length()];
		int k=0;
		for(int i=0; i<smallAns.length; i++) {
			for(int j=0; j<digStr.length(); j++) {
				ans[k] = smallAns[i] + digStr.charAt(j);
				k++;
			}
		}
		return ans;
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
