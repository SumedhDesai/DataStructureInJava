/*
 * BST Class

	Implement the BST class which includes following functions -
	1. search
	Given an element, find if that is present in BST or not. Return true or false.
	2. insert -
	Given an element, insert that element in the BST at the correct position. If element is equal to the data of the node, insert it in the left subtree.
	3. delete -
	Given an element, remove that element from the BST. If the element which is to be deleted has both children, replace that with the minimum element from right sub-tree.
	4. printTree (recursive) -
	Print the BST in ithe following format -
	For printing a node with data N, you need to follow the exact format -
	N:L:x,R:y
	where, N is data of any node present in the binary tree. x and y are the values of left and right child of node N. Print the children only if it is not null.
	There is no space in between.
	You need to print all nodes in the recursive format in different lines.
	input 1
	6
	1 2
	1 3
	1 1
	4
	2 2
	4
	output 1
	2:L:1,R:3
	1:
	3:
	3:L:1,
	1:
	input 2
	6
	1 2
	1 3
	1 1
	3 2
	2 2
	3 2
	output 2
	true
	false	
	input 3
	8
	1 4
	1 4
	1 4
	1 4
	4
	3 4
	2 4
	4
	output 3
	4:L:4,
	4:L:4,
	4:L:4,
	4:
	true
	4:L:4,
	4:L:4,
	4:
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BSTMainEqualDataOnLeft {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BinarySearchTree bst = new BinarySearchTree();
		int choice, input;
		int q = Integer.parseInt(br.readLine());
		while (q-- > 0) {
			st = new StringTokenizer(br.readLine());
			choice = Integer.parseInt(st.nextToken());
			switch (choice) {
			case 1:
				input = Integer.parseInt(st.nextToken());
				bst.insert(input);
				break;
			case 2:
				input = Integer.parseInt(st.nextToken());
				bst.remove(input);
				break;
			case 3:
				input = Integer.parseInt(st.nextToken());
				System.out.println(bst.search(input));
				break;
			default:
				bst.printTree();
				break;
			}

		}
	}
}