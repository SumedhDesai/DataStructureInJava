/*
 * Elements Between K1 and K2

	Given a Binary Search Tree and two integers k1 and k2, find and print the 
	elements which are in range k1 and k2 (both inclusive).
	Print the elements in increasing order.
	Input format:
	The first line of input contains data of the nodes of the tree in level order form. 
	The data of the nodes of the tree is separated by space. If any node does not have 
	left or right child, take -1 in its place. Since -1 is used as an indication whether 
	the left or right nodes exist, therefore, it will not be a part of the data of any node.
	The following line contains two integers, that denote the value of k1 and k2.
	Output Format:
	The first and only line of output prints the elements which are in range k1 and k2 
	(both inclusive). Print the elements in increasing order.
	Constraints:
	Time Limit: 1 second
	Sample Input 1:
	8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
	6 10
	Sample Output 1:
	6 7 8 10
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class ElementsBetweenK1AndK2 {

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
		int k1 = Integer.parseInt(st.nextToken());
		int k2 = Integer.parseInt(st.nextToken());
		elementsInRangeK1K2(root, k1, k2);
	}

	private static void elementsInRangeK1K2(BinaryTreeNode<Integer> root, int k1, int k2) {
		if(root==null) {
			return;
		}
		if(k1<=root.data && root.data<=k2) {
			elementsInRangeK1K2(root.left, k1, k2);
			System.out.print(root.data+" ");
			elementsInRangeK1K2(root.right, k1, k2);
		}
		if(root.data>k2) {
			elementsInRangeK1K2(root.left, k1, k2);
		}else if(root.data<k1) {
			elementsInRangeK1K2(root.right, k1, k2);
		}
	}
}
