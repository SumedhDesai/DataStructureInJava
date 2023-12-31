/*
 * Does s contain t ?

	Given two string s and t, write a function to check if s contains all 
	characters of t (in the same order as they are in string t).
	Return true or false.
	Do it recursively.
	E.g. : s = �abchjsgsuohhdhyrikkknddg� contains all characters of t=�coding� 
	in the same order. So function will return true.
	Input Format :
	Line 1 : String s
	Line 2 : String t
	Output Format :
	true or false
	Sample Input 1 :
	abchjsgsuohhdhyrikkknddg
	coding
	Sample Output 1 :
	true
	Sample Input 2 :
	abcde
	aeb
	Sample Output 2 :
	false
 */
import java.util.Scanner;

public class Does_S_Contain_T {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		String large = s.nextLine();
		String small = s.nextLine();

		System.out.println(checkSequence(large, small));
		s.close();
	}

	private static boolean checkSequence(String a, String b) {
		if(b.length()==0) {
			return true;
		}
		if(a.length()==0) {
			return false;
		}
		if(a.charAt(0)==b.charAt(0)) {
			return checkSequence(a.substring(1), b.substring(1));
		}else {
			return checkSequence(a.substring(1), b.substring(0));
		}
	}
}