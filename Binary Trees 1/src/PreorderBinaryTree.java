/*
 * Preorder Binary Tree

	You are given the root node of a binary tree.Print its preorder traversal.
	Input Format:
	The first and the only line of input will contain the node data, 
	all separated by a single space. Since -1 is used as an indication whether
	 the left or right node data exist for root, it will not be a part of the node data.
	Output Format:
	The only line of output prints the preorder traversal of the given binary tree.
	Constraints:
	1 <= N <= 10^6
	Where N is the total number of nodes in the binary tree.
	
	Time Limit: 1 sec
	Sample Input 1:
	1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
	 Sample Output 1:
	1 2 4 5 3 6 7
	Sample Input 2:
	5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
	 Sample Output 1:
	5 6 2 3 9 10
	
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

 
public class PreorderBinaryTree {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static BinaryTreeNode<Integer> takeInput() throws NumberFormatException, IOException {
		QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>(); 
		int start = 0;

		String[] nodeDatas = br.readLine().trim().split(" ");

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

	public static void main(String[] args) throws NumberFormatException, IOException {
		BinaryTreeNode<Integer> root = takeInput();
		preOrder(root);
	}

	private static void preOrder(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
}