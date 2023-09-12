/*
 * Mirror Binary Tree

	For a given Binary Tree of type integer, update it with its corresponding 
	mirror image.
	Example:
	Alt text
	
	Input Format:
	The first and the only line of input will contain the node data, all separated 
	by a single space. Since -1 is used as an indication whether the left or right 
	node data exist for root, it will not be a part of the node data.
	Output Format:
	The only line of output prints the mirrored tree in a level-wise order. 
	Each level will be printed on a new line. Elements printed at each level will be 
	separated by a single line.
	Note:
	You are not required to print anything explicitly. It has already been taken care of.
	Constraints:
	1 <= N <= 10^5
	Where N is the total number of nodes in the binary tree.
	
	Time Limit: 1 sec
	Sample Input 1:
	1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
	Sample Output 1:
	1 
	3 2 
	7 6 5 4
	Sample Input 2:
	5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
	Sample Output 2:
	5 
	6 10 
	3 2 
	9
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MirrorBinaryTree {

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


	private static void printLevelWise(BinaryTreeNode<Integer> root){
		QueueUsingLL<BinaryTreeNode<Integer>>  primary = new QueueUsingLL<>();
		QueueUsingLL<BinaryTreeNode<Integer>>  secondary = new QueueUsingLL<>();

		primary.enqueue(root);

		while(!primary.isEmpty()){
			BinaryTreeNode<Integer> current=null;
			try {
				current = primary.dequeue();
			} catch (QueueEmptyException e) {
				System.out.println("Not possible");
			}
			System.out.print(current.data + " ");
			if(current.left != null){
				secondary.enqueue(current.left);
			}
			if(current.right != null){
				secondary.enqueue(current.right);
			}
			if(primary.isEmpty()){
				QueueUsingLL<BinaryTreeNode<Integer>>  temp = secondary;
				secondary = primary;
				primary = temp;
				System.out.println();
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BinaryTreeNode<Integer> root = takeInput();
		
		mirrorBinaryTree(root);
		printLevelWise(root);
		
	}


	private static void mirrorBinaryTree(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		BinaryTreeNode<Integer> temp = root.right;
		root.right=root.left;
		root.left=temp;
		mirrorBinaryTree(root.left);
		mirrorBinaryTree(root.right);
	}
}