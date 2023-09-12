/*
 * Extract Unique characters

	Given a string S, you need to remove all the duplicates. That means, 
	the output string should contain each character only once. The respective 
	order of characters should remain same, as in the input string.
	Input format:
	The first and only line of input contains a string, that denotes the value 
	of S.
	Output format :
	The first and only line of output contains the updated string, as described 
	in the task.
	Constraints :
	0 <= Length of S <= 10^8
	Time Limit: 1 sec
	Sample Input 1 :
	ababacd
	Sample Output 1 :
	abcd
	Sample Input 2 :
	abcde
	Sample Output 2 :
	abcde
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ExtractUniqueCharacters {

	private static String uniqueChar(String str) {
		if(str.length()==0) {
			return null;
		}
		String ans = "";
		HashMap<Character, Boolean> map = new HashMap<>();

		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(!map.containsKey(ch)) {
				ans=ans+ch;
				map.put(ch, true);
			}
		}
		return ans;
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static String takeInput() throws IOException {
		String str = br.readLine(); 
		return str;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {


		String str = takeInput();
		System.out.print(uniqueChar(str));


	}
}