/*
 * LCA of BST

	Given a binary search tree and data of two nodes, find 'LCA' 
	(Lowest Common Ancestor) of the given two nodes in the BST.
	LCA
	LCA of two nodes A and B is the lowest or deepest node which 
	has both A and B as its descendants. 
	Example:
	In this example, the green coloured node is the LCA to A and B.
	
	Note:
	It is defined that each node is a descendant to itself, so, if there 
	are two nodes X and Y and X has a direct connection from Y, then Y is 
	the lowest common ancestor.
	Example:
	
	Note:
	1. If out of 2 nodes only one node is present, return that node. 
	2. If both are not present, return -1.
	3. all the node data will be unique.
	Input format:
	The first line of input contains data of the nodes of the tree in level 
	order form. The data of the nodes of the tree is separated by space. If 
	any node does not have left or right child, take -1 in its place. Since -1 
	is used as an indication whether the left or right nodes exist, therefore, 
	it will not be a part of the data of any node.
	The following line of input contains two integers, denoting the value of 
	data of two nodes of given BST.
	Output Format:
	The first and only line of output contains the data associated with the 
	lowest common ancestor node.
	Constraints:
	Time Limit: 1 second
	Sample Input 1:
	8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
	2 10
	Sample Output 1:
	8
	Sample Input 2:
	8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
	2 6
	Sample Output 2:
	5
	Sample Input 3:
	8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
	12 78
	Sample Output 3:
	-1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LCAofBST {

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
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		System.out.println(getLCA(root, a, b));
	}

	private static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
		if(root==null) {
			return -1;
		}
		BinaryTreeNode<Integer> node = getLCAHelper(root, a, b);
		if(node==null) {
			return -1;
		}
		return node.data;
	}

	private static BinaryTreeNode<Integer> getLCAHelper(BinaryTreeNode<Integer> root, int a, int b) {
		if(root==null || root.data==a || root.data==b) {
			return root;
		}
		BinaryTreeNode<Integer> leftLCD = getLCAHelper(root.left, a, b);
		BinaryTreeNode<Integer> rightLCD = getLCAHelper(root.right, a, b);
		
		if(leftLCD!=null && rightLCD!=null) {
			return root;
		}
		if(leftLCD!=null) {
			return leftLCD;
		}else {
			return rightLCD;
		}
	}

}