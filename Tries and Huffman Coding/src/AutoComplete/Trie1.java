
package AutoComplete;

import java.util.ArrayList;

class TrieNode{
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

public class Trie1 {
	private TrieNode root;
	public int count;
	public Trie1() {
		root = new TrieNode('\0');
	}

	private void add(TrieNode root, String word){
		if(word.length() == 0){
			root.isTerminating = true;
			return;
		}		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		add(child, word.substring(1));
	}

	public void add(String word){
		add(root, word);
	}

	private TrieNode findroot(TrieNode root, String word) {
		if(word.length()==0) {
			return root;
		}
		int childIndex = word.charAt(0)-'a';
		TrieNode child = root.children[childIndex];
		if(child == null) {
			return null;
		}
		return findroot(child, word.substring(1));
	}

	public void autoComplete(ArrayList<String> input, String word) {

		for(String w : input) {
			add(w);
		}
		TrieNode node = findroot(root, word);
		if(node==null) {
			return;
		}

		allRootToLeafPaths(node, "" , word);
	}

	private void allRootToLeafPaths(TrieNode root, String output, String word) {
		
		if(root.isTerminating==true) {
			System.out.println(word+output);
		}
		for(int i=0; i<root.children.length; i++) {
			TrieNode child = root.children[i];
			if(child != null) {
				String ans = output + child.data;
				allRootToLeafPaths(child, ans, word);
			}
		}
	}
}