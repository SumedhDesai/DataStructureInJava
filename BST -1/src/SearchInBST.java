/*
 * Search In BST

	Given a BST and an integer k. Find if the integer k is present in 
	given BST or not. You have to return true, if node with data k is 
	present, return false otherwise.
	Note: Assume that BST contains all unique elements.
	Input Format:
	The first line of input contains data of the nodes of the tree in 
	level order form. The data of the nodes of the tree is separated by 
	space. If any node does not have left or right child, take -1 in its 
	place. Since -1 is used as an indication whether the left or right 
	nodes exist, therefore, it will not be a part of the data of any node.   
	The following line of input contains an integer, that denotes the value of k.
	Output Format:
	The first and only line of output contains a boolean value. Print true, 
	if node with data k is present, print false otherwise. 
	Constraints:
	Time Limit: 1 second
	Sample Input 1 :
	8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
	2
	Sample Output 1 :
	true
	Sample Input 2 :
	8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
	12
	Sample Output 2 :
	false
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SearchInBST {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	static StringTokenizer st;

	public static BinaryTreeNode<Integer> takeInput() throws IOException {
		st = new StringTokenizer(br.readLine());
		int rootData = Integer.parseInt(st.nextToken());
		if (rootData == -1) {
			return null;
		}
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.add(root);

		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.remove();
			} catch (Exception e) {
				return null;
			}
			int leftChildData = Integer.parseInt(st.nextToken());
			if (leftChildData != -1) {
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.add(leftChild);
			}
			int rightChildData = Integer.parseInt(st.nextToken());
			if (rightChildData != -1) {
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.add(rightChild);
			}
		}
		return root;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BinaryTreeNode<Integer> root = takeInput();
		int k = Integer.parseInt(br.readLine());
		System.out.println(searchInBST(root,k));
	}

	private static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
		if(root == null) {
			return false;
		}
		if(root.data==k) {
			return true;
		}else if(root.data>k) {
			return searchInBST(root.left, k);
		}else {
			return searchInBST(root.right, k);
		}
		// no need to compare right side and left side
		// Because of if else only one side tree is called and return its answer
		// and that is sole purpose of BST 
		// Recursion is done on only one specific path
	}

}