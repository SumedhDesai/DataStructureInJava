/*
 * Longest Leaf to root path

	Given a binary tree, return the longest path from leaf to root. 
	Longest means, a path which contain maximum number of nodes from 
	leaf to root.
	Input format :
	Elements in level order form (separated by space)
	(If any node does not have left or right child, take -1 in its place)
	Line 1 : Binary Tree 1 (separated by space)
	Sample Input 1 :
	 5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
	Sample Output 1 :
	9
	3
	6
	5
 */
import java.util.ArrayList;
import java.util.Scanner;
 
public class LongestLeafToRootPath {
	
	private static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return null;
		}
		if(root.left==null && root.right==null) {
			ArrayList<Integer> ans = new ArrayList<>();
			ans.add(root.data);
			return ans;
		}
		
		ArrayList<Integer> leftAns = longestRootToLeafPath(root.left);
		ArrayList<Integer> rightAns = longestRootToLeafPath(root.right);
		
		if(leftAns == null) {
			// means root has only right subtree
			rightAns.add(root.data);
			return rightAns;
		}if(rightAns == null) {
			// means root has only right subtree
			leftAns.add(root.data);
			return leftAns;
		}
		if(leftAns.size()>rightAns.size()) {
			leftAns.add(root.data);
			return leftAns;
		}else {
			rightAns.add(root.data);
			return rightAns;
		}

	}
	
	static Scanner s = new Scanner(System.in);

	public static BinaryTreeNode<Integer> takeInput(){
		QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>(); // we can skip writing again inside <> after java version 1.7 

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
		ArrayList<Integer> output = longestRootToLeafPath(root);
		for(int i : output) {
			System.out.println(i);
		}
	}
}
