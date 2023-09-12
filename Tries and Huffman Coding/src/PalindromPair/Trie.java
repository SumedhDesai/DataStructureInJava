package PalindromPair;


import java.util.ArrayList;

class TrieNode {
	char data;
	boolean isTerminating;
	TrieNode children[];
	int childCount;

	public TrieNode(char data) {
		this.data = data;
		isTerminating = false;
		children = new TrieNode[26];
		childCount = 0;
	}
}

public class Trie {

	private TrieNode root;
	public int count;

	public Trie() {
		root = new TrieNode('\0');
	}

	private void add(TrieNode root, String word){
		if(word.length() == 0){
			root.isTerminating = true;
			return;
		}		

		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];

		if(child == null) {
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}

		add(child, word.substring(1));
	}

	public void add(String word){
		add(root, word);
	}

	private boolean search(TrieNode root, String word) {
		if(word.length() == 0) {
			return root.isTerminating;
		}

		int childIndex=word.charAt(0) - 'a';
		TrieNode child=root.children[childIndex];

		if(child == null) {
			return false;
		}

		return search(child,word.substring(1));

	}

	public boolean search(String word) {
		return search(root,word);
	}

	private void print(TrieNode root, String word) {
		if (root == null) {
			return;
		}

		if (root.isTerminating) {
			System.out.println(word);
		}

		for (TrieNode child : root.children) {
			if (child == null) {
				continue;
			}
			String fwd = word + child.data;
			print(child, fwd);
		}
	}

	public void print() {
		print(this.root, "");
	}





	/*..................... Palindrome Pair................... */

	private String reverse(String word) {
		String rev ="";
		for(int i=word.length()-1; i>=0; i--) {
			rev+=word.charAt(i);
		}
		return rev;
	}

	private boolean isPalindrome(String word) {
		int startIndex = 0;
		int endIndex = word.length()-1;
		while(startIndex<endIndex) {
			if(word.charAt(startIndex)!=word.charAt(endIndex)) {
				return false;
			}
			startIndex++;
			endIndex--;
		}
		return true;
	}

	public boolean isPalindromePair(ArrayList<String> wordsArray) {

		if(wordsArray == null || wordsArray.size()==0) {
			return false;
		}

		for(int i=0; i<wordsArray.size(); i++) {
			String word = wordsArray.get(i);
			add(reverse(word));
		}

		for(int i=0; i<wordsArray.size(); i++) {
			String word = wordsArray.get(i);
			if(findPairInTrie(root, word, 0)) {
				return true;
			}
		}
		return false;
	}

	private boolean findPairInTrie(TrieNode root, String word, int startIndex) {
		if(startIndex == word.length()) {
			if(root.isTerminating) {
				return true;
			}
			/* 
			 * Trie Branch is same up to last char of word but trie Branch has 
			 * more char to be check and if this char are Palindrome then whole 
			 * string is Palindrome
			 */
			return creatWordOfRemainingCharAndCheck(root,"");
		}
		int childIndex = word.charAt(startIndex)-'a';
		TrieNode child = root.children[childIndex];
		if(child == null) {
			if(root.isTerminating) {
				/* 
				 * Trie Branch is same up to terminal node but word has 
				 * more char to be check and if this char are Palindrome then whole 
				 * string is Palindrome
				 */
				return isPalindrome(word.substring(startIndex));
			}
			return false;
		}
		
		return findPairInTrie(child, word, startIndex+1);
	}

	private boolean creatWordOfRemainingCharAndCheck(TrieNode root, String word) {
		if(root.isTerminating) {
			return isPalindrome(word);
		}
		
		for(int i=0; i<root.children.length; i++) {
			TrieNode child = root.children[i];
			if(child!=null) {
				word = word+child.data;
				return creatWordOfRemainingCharAndCheck(child, word);
			}
		}
		return false;
	}
} 