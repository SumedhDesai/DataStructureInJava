/*
 * Auto complete
 
	Given n number of words and an incomplete word w. You need 
	to auto-complete that word w.
	That means, find and print all the possible words which can 
	be formed using the incomplete word w.
	Note : Order of words does not matter.
	Input Format :
	The first line of input contains an integer, that denotes 
	the value of n.
	The following line contains n space separated words.
	The following line contains the word w, that has to be 
	auto-completed.
	Output Format :
	Print all possible words in separate lines.
	Constraints:
	Time Limit: 1 sec
	Sample Input 1 :
	7
	do dont no not note notes den
	no
	Sample Output 2 :
	no
	not
	note
	notes
	Sample Input 2 :
	7
	do dont no not note notes den
	de
	Sample Output 2 :
	den
	Sample Input 3 :
	7
	do dont no not note notes den
	nom
	Sample Output 3 :
	(Empty) There is no word which starts with "nom"
 */
package AutoComplete;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Runner {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
	
	public static void main(String[] args) throws IOException{
		Trie1 t = new Trie1();
		int n = Integer.parseInt(br.readLine().trim());
        ArrayList<String> input = new ArrayList<String>();
        String[] words = br.readLine().split("\\s");
		for(int i = 0; i < n; i++) {
			
			input.add(words[i]);
		}
		String pattern = br.readLine();
		t.autoComplete(input, pattern);
	}
}