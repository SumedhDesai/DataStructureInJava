/*
 * Replace Node With Depth

	For a given a Binary Tree of integers, replace each of its data with the 
	depth of the tree.
	Root is at depth 0, hence the root data is updated with 0. Replicate the 
	same further going down the in the depth of the given tree.
	The modified tree will be printed in the in-order fashion.
	Output: 2 1 2 0 2 1 2 (printed in the in-order fashion)
	 Input Format:
	The first and the only line of input will contain the node data, all 
	separated by a single space. Since -1 is used as an indication whether 
	the left or right node data exist for root, it will not be a part of the 
	node data.
	Output Format:
	The first and the only line of output prints the updated tree in the 
	in-order fashion.
	Note:
	You are not required to print anything explicitly. It has already been 
	taken care of.
	Constraints:
	1 <= N <= 10^5
	Where N is the total number of nodes in the binary tree.
	
	Time Limit: 1sec
	 Sample Input 1:
	2 35 10 2 3 5 2 -1 -1 -1 -1 -1 -1 -1 -1 
	Sample Output 1:
	2 1 2 0 2 1 2 
	 Sample Input 2:
	1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
	Sample Output 2:
	2 1 2 0 2 1 2 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReplaceNodeWithDepth {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static BinaryTreeNode<Integer> takeInput() throws NumberFormatException, IOException {
		QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>(); 
		int start = 0;

		String[] nodeDatas = br.readLine().trim().split(" ");

		if (nodeDatas.length == 1) {
			return null;
		}

		int rootData = Integer.parseInt(nodeDatas[start]);
		start += 1;

		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);

		while(!pendingNodes.isEmpty()){
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}

			int leftChildData = Integer.parseInt(nodeDatas[start]);
			start += 1;

			if(leftChildData != -1){
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.enqueue(leftChild);
			}

			int rightChildData = Integer.parseInt(nodeDatas[start]);
			start += 1;

			if(rightChildData != -1){
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}

		return root;
	}

	public static void inOrder(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}

		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BinaryTreeNode<Integer> root = takeInput();
		
		changeToDepthTree(root);
		inOrder(root);
	}

	private static void changeToDepthTree(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		replaceNodeWithDepth(root, 0);
	}

	private static void replaceNodeWithDepth(BinaryTreeNode<Integer> root, int k) {
		if(root==null) {
			return;
		}
		root.data=k;
		replaceNodeWithDepth(root.left, k+1);
		replaceNodeWithDepth(root.right, k+1);
	}
}