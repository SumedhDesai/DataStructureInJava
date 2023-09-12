/*
 * Check cousins
	
	Given the binary Tree and two nodes say �p� and �q�. Determine whether 
	the two nodes are cousins of each other or not. Two nodes are said to 
	be cousins of each other if they are at same level of the Binary Tree 
	and have different parents.
	Do it in O(n).
	Input format :
	Line 1 : Nodes in level order form (separated by space). If any node does 
	not have left or right child, take -1 in its place
	Line 2 : integer value of p 
	Line 3 : Integer value of q
	Output format :
	true or false
	Constraints :
	1 <= N <= 10^5
	Sample Input :
	5 6 10 2 3 4 -1 -1 -1 -1 9 -1 -1 -1 -1
	2
	4
	Sample Output :
	true
 */
import java.util.Scanner;

public class CheckCousins {
	
	private static boolean isCousin(BinaryTreeNode<Integer> root, int p, int q) {
		return ((depth(root, p)==depth(root, q))&& (!isSibling(root, p, q)));
	}

	private static int depth(BinaryTreeNode<Integer> root, int x) {
		if(root == null) {
			return -1;
		}
		if(root.data==x) {
			return 0;
		}
		int leftAns = depth(root.left, x);
		if(leftAns != -1) {
			return leftAns+1;
		}
		int rightAns = depth(root.right, x);
		if(rightAns != -1) {
			return rightAns+1;
		}
		return -1;
	}

	private static boolean isSibling(BinaryTreeNode<Integer> root, int p, int q) {
		if(root == null) {
			return false;
		}
		if(root.left != null && root.right != null) {
			if(root.left.data==p && root.right.data==q) {
				return true;
			}else if(root.left.data==q && root.right.data==p) {
				return true;
			}else {
				return isSibling(root.left, p, q) || isSibling(root.right, p, q);
			}
		}else if (root.left!= null) {
			isSibling(root.left, p, q);
		}else {
			isSibling(root.right, p, q);
		}
//		System.out.println(root.data);
		return false;
	}

	static Scanner s = new Scanner(System.in);

	public static BinaryTreeNode<Integer> takeInput(){
		QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>(); 
		int rootData = s.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);

		while(!pendingNodes.isEmpty()){
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}
			int leftChildData = s.nextInt();
			if(leftChildData != -1){
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.enqueue(leftChild);
			}
			int rightChildData = s.nextInt();
			if(rightChildData != -1){
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}
		return root;
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();
		int p = s.nextInt();
		int q = s.nextInt();
		System.out.println(isCousin(root, p, q));
	}
}