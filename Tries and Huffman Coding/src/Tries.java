
public class Tries {

	private TrieNode root ;
	private int numWords;
	public Tries() {
		this.root = new TrieNode('\0');
		this.numWords=0;
	}
	
	public void add(String word) {
		addHelper(root, word);
		numWords++;
	}

	private void addHelper(TrieNode root, String word) {
		if(word.length()==0) {
			root.isTerminating=true;
			return;
		}
		int childIndex = word.charAt(0) - 'A';
		TrieNode child = root.children[childIndex];
		if(child == null) {
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		addHelper(child, word.substring(1));
	}
	
	public boolean search(String word) {
		return searchHelper(root, word);
	}

	private boolean searchHelper(TrieNode root, String word) {
		if(word.length()==0) {
//			if(root.isTerminal) {
//				return true;
//			}else {
//				return false;
//			}
			return root.isTerminating;
		}
		int index = word.charAt(0)-'A';
		if(root.children[index]==null) {
			return false;
		}
		return searchHelper(root.children[index], word.substring(1));
	}
	
	public void remove(String word) {
		removeHelper(root , word);
		numWords--;
	}

	private void removeHelper(TrieNode root, String word) {
		if(word.length() == 0) {
			root.isTerminating =false;
			return;
		}
		int childIndex = word.charAt(0)-'A';
		TrieNode child = root.children[childIndex];
		if(child == null) {
			return;
		}
		removeHelper(child, word.substring(1));
		if(!child.isTerminating && child.childCount == 0) {
			root.children[childIndex]=null;
			root.childCount--;
		}
	}
	
	public int countWord(){
		return numWords;
	}
}
