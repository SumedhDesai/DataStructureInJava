/*
 * BST Main Equal Data On Right
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BSTMainEqualDataOnRight {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		BinarySearchTree2 bst = new BinarySearchTree2();
		bst.insert(4);
		bst.insert(2);
		bst.insert(6);
		bst.insert(1);
		bst.insert(3);
		bst.insert(5);
		bst.insert(7);
		bst.insert(8);
		bst.printTree();
		System.out.println(bst.search(8));
		bst.remove(4);
		bst.printTree();

	}
}

