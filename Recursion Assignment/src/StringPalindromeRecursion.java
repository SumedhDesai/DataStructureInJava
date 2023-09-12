/*
 * Check Palindrome (recursive)

	Check whether a given String S is a palindrome using recursion. Return true or false.
	Input Format :
	String S
	Output Format :
	'true' or 'false'
	Constraints :
	0 <= |S| <= 1000
	where |S| represents length of string S.
	Sample Input 1 :
	racecar
	Sample Output 1:
	true
	Sample Input 2 :
	ninja
	Sample Output 2:
	false
*/
import java.util.Scanner;
 
public class StringPalindromeRecursion {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(isStringPalindrome(input));
		s.close();
	}

	private static boolean isStringPalindrome(String str) {
		if(str.length()<=1) {
			return true;
		}else if(str.charAt(0)==str.charAt(str.length()-1)) {
			return isStringPalindrome(str.substring(1, str.length()-1));
		}else {
			return false;
		}
	}
}