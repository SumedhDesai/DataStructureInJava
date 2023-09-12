/*
 * Largest BST

	Given a Binary tree, find the largest BST subtree. That is, you need to 
	find the BST with maximum height in the given binary tree. You have to 
	return the height of largest BST.
	Input format :
	The first line of input contains data of the nodes of the tree in level 
	order form. The data of the nodes of the tree is separated by space. If 
	any node does not have left or right child, take -1 in its place. Since -1 
	is used as an indication whether the left or right nodes exist, therefore, 
	it will not be a part of the data of any node.
	Output format:
	The first and only line of output contains the height of the largest BST.
	Constraints:
	Time Limit: 1 second
	Sample Input 1:
	5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
	Sample Output 1:
	2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LargestBST {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static BinaryTreeNode<Integer> takeInput() throws IOException {
		st = new StringTokenizer(br.readLine());
		int rootData = Integer.parseInt(st.nextToken());
		if (rootData == -1) {
			return null;
		}
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);

		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}
			int leftChildData = Integer.parseInt(st.nextToken());
			if (leftChildData != -1) {
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.enqueue(leftChild);
			}
			int rightChildData = Integer.parseInt(st.nextToken());
			if (rightChildData != -1) {
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}
		return root;
	}
	
	public static void main(String[] args) throws IOException {
		BinaryTreeNode<Integer> root = takeInput();
		System.out.println(largestBSTSubtree(root));
	}

	private static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
		BSTReturn b = largestBSTSubtreehelper(root);
		return b.height;
	}

	private static BSTReturn largestBSTSubtreehelper(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return new BSTReturn(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}
		BSTReturn leftAns = largestBSTSubtreehelper(root.left);
		BSTReturn rightAns = largestBSTSubtreehelper(root.right);
		
		int min = Math.min(root.data, Math.min(leftAns.min, rightAns.min));
		int max = Math.max(root.data, Math.max(leftAns.max, rightAns.max));
		int height = Math.max(leftAns.height, rightAns.height);
		boolean isBST = true;
		if(leftAns.max >= root.data) {
			isBST = false;
		}
		if(root.data > rightAns.min) {
			isBST = false ;
		}
		if(!leftAns.isBST) {
			isBST = false;
		}
		if(!rightAns.isBST) {
			isBST = false;
		}
		if(isBST) {
			height = height+1; // if either subtree is not BST then there 
			// parent is not BST
			//so to find largest BST height they must be sequence
			// hight +1 give hight of largst BST
		}
		
		BSTReturn ans = new BSTReturn(isBST, height, max, min);
		return ans;
	}
}