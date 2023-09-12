/*
 * Height Of Tree

	For a given Binary Tree of integers, find and return the height of the tree.
	Example:
	                        10
	                      /      \
	                    20      30
	                   /    \
	                 40    50
	
	Height of the given tree is 3. 
	
	Height is defined as the total number of nodes along the longest path from the 
	root to any of the leaf node.
	 Input Format:
	The first and the only line of input will contain the node data, all separated 
	by a single space. Since -1 is used as an indication whether the left or right 
	node data exist for root, it will not be a part of the node data.
	Output Format:
	The first and the only line of output prints the height of the given binary tree.
	Note:
	You are not required to print anything explicitly. It has already been taken care of.
	Constraints:
	0 <= N <= 10^5
	Where N is the total number of nodes in the binary tree.
	
	Time Limit: 1 sec
	Sample Input 1:
	10 20 30 40 50 -1 -1 -1 -1 -1 -1
	Sample Output 1:
	3
	Sample Input 2:
	3 -1 -1
	Sample Output 2:
	1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
		
public class HeightOfTree {

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

	public static void main(String[] args) throws NumberFormatException, IOException {
		BinaryTreeNode<Integer> root = takeInput();
		
		int h = height(root);

		System.out.println(h);
	}

	private static int height(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		return 1+Math.max(leftHeight, rightHeight);
	}
}