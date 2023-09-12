/*
 * Pair Star

	Given a string S, compute recursively a new string where identical 
	chars that are adjacent in the original string are separated from 
	each other by a "*".
	Input format :
	String S
	Output format :
	Modified string
	Constraints :
	0 <= |S| <= 1000
	where |S| represents length of string S.
	Sample Input 1 :
	hello
	Sample Output 1:
	hel*lo
	Sample Input 2 :
	aaaa
	Sample Output 2 :
	a*a*a*a
 */
import java.util.Scanner;

public class PairStar {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(addStars(input));
		s.close();
	}

	private static String addStars(String input) {
		if(input.length()<=1) {
			return input;
		}
		String smallAns = addStars(input.substring(1));
		if(input.charAt(0)==input.charAt(1)) {
			return input.charAt(0)+"*"+smallAns;
		}else {
			return input.charAt(0)+smallAns;
		}
	}
}
