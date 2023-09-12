/*
 * Palindrome Pair

	Given 'n' number of words, you need to find if there exist any two words 
	which can be joined to make a palindrome or any word, which itself is a 
	palindrome.
	The function should return either true or false. You don't have to print 
	anything.
	Input Format :
	The first line of the test case contains an integer value denoting 'n'.
	
	The following contains 'n' number of words each separated by a single space.
	Output Format :
	The first and only line of output contains true if the conditions described 
	in the task are met and false otherwise.
	Constraints:
	0 <= n <= 10^5
	Time Limit: 1 sec
	Sample Input 1 :
	4
	abc def ghi cba
	Sample Output 1 :
	true
	Explanation of Sample Input 1:
	"abc" and "cba" forms a palindrome
	Sample Input 2 :
	2
	abc def
	Sample Output 2 :
	false
	Explanation of Sample Input 2:
	Neither their exists a pair which forms a palindrome, nor any of the words 
	is a palindrome in itself. Hence, the output is 'false
 */
package PalindromPair;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static ArrayList<String> takeInput() throws IOException {
        ArrayList<String> words = new ArrayList<>();

        int n = Integer.parseInt(br.readLine().trim());

        if (n == 0) {
            return words;
        }
        
        String[] listOfWords; 
        listOfWords = br.readLine().split("\\s");
        

        for (int i = 0; i < n; ++i) {
            words.add(listOfWords[i]);
        }

        return words;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        Trie root = new Trie();

        ArrayList<String> words = takeInput();
        System.out.println(root.isPalindromePair(words));
    } 

}