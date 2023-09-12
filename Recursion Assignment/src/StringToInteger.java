/*
 * String to Integer

	Write a recursive function to convert a given string into the number it 
	represents. That is input will be a numeric string that contains only 
	numbers, you need to convert the string into corresponding integer and 
	return the answer.
	Input format :
	Numeric string S (string, Eg. "1234")
	Output format :
	Corresponding integer N (int, Eg. 1234)
	Constraints :
	0 <= |S| <= 9
	where |S| represents length of string S.
	Sample Input 1 :
	00001231
	Sample Output 1 :
	1231
	Sample Input 2 :
	12567
	Sample Output 2 :
	12567
 */
import java.util.Scanner;

public class StringToInteger {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(convertStringToInt(input));
		s.close();
	}

	private static int convertStringToInt(String str) {
		if(str.length()==0) {
		return 0;
		}
		int smallAns =convertStringToInt(str.substring(0, str.length()-1));
		int val = (int)str.charAt(str.length()-1);
		val= val-'0';
		return smallAns*10+val;
	}
}
