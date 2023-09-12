/*
 * Return Permutations of a String
	
	Given a string, find and return all the possible permutations 
	of the input string.
	Note : The order of permutations are not important.
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

public class ReturnPermutationsOfString {
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		String input = s.nextLine();
		String output[] = permutationOfString(input);
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}

	private static String[] permutationOfString(String str) {
		if(str.length() == 0) {
			String[] ans = new String[1];
			ans[0]="";
			return ans;
		}
		
		String[] smallAns = permutationOfString(str.substring(1));
		
		String[] ans = new String[str.length()*smallAns.length];
		int k=0;
		for(int i=0; i<smallAns.length; i++) {
			String currStr = smallAns[i];
			for(int j=0; j<=currStr.length(); j++) {
//				<= is to go till last char of String i.e. "" string i.e to take whole string
				ans[k] = currStr.substring(0,j) + str.charAt(0) + currStr.substring(j);
				k++;
			}
		}
		return ans;
	}
}
