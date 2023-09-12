/*
 * Create & Insert Duplicate Node

	For a given a Binary Tree of type integer, duplicate every node 
	of the tree and attach it to the left of itself.
	The root will remain the same. So you just need to insert nodes in 
	the given Binary Tree.
	You can see that every node in the input tree has been duplicated 
	and inserted to the left of itself.
	Input format :
	The first and the only line of input will contain the node data, all 
	separated by a single space. Since -1 is used as an indication whether the 
	left or right node data exist for root, it will not be a part of the node data.
	Output Format :
	The updated tree will be printed in a level order fashion where each level 
	will be printed on a new line. 
	Elements on every level will be printed in a linear fashion. A single space 
	will separate them.
	 Note:
	You are not required to print anything explicitly. It has already been taken 
	care of. Just implement the function to achieve the desired structure of the tree.
	Constraints :
	1 <= N <= 10^5
	Where N is the total number of nodes in the binary tree.
	
	Time Limit: 1 sec
	Sample Input 1:
	10 20 30 40 50 -1 60 -1 -1 -1 -1 -1 -1
	Sample Output 1:
	10 
	10 30 
	20 30 60 
	20 50 60 
	40 50 
	40 
	Sample Input 2:
	8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
	Sample Output 2:
	8 
	8 10 
	5 10 
	5 6 
	2 6 7 
	2 7
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreateInsertDuplicateNode {

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
		
		insertDuplicateNode(root);
		printLevelWise(root);
	}


	private static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return ;
		}
		BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(root.data);
		newNode.left=root.left;
		root.left=newNode;
		
		insertDuplicateNode(newNode.left);
		insertDuplicateNode(root.right);
	}
}