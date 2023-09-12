/*
 * Level order traversal

	For a given a Binary Tree of type integer, print it in a level order 
	fashion where each level will be printed on a new line. Elements on 
	every level will be printed in a linear fashion and a single space will 
	separate them.
	Example:
	alt txt
	
	For the above-depicted tree, when printed in a level order fashion, the 
	output would look like:
	
	10
	20 30 
	40 50 60
	Where each new line denotes the level in the tree.
	Input Format:
	The first and the only line of input will contain the node data, all separated 
	by a single space. Since -1 is used as an indication whether the left or right 
	node data exist for root, it will not be a part of the node data.
	Output Format:
	The given input tree will be printed in a level order fashion where each level 
	will be printed on a new line. 
	Elements on every level will be printed in a linear fashion. A single space 
	will separate them.
	Constraints:
	1 <= N <= 10^5
	Where N is the total number of nodes in the binary tree.
	
	Time Limit: 1 sec
	Sample Input 1:
	10 20 30 40 50 -1 60 -1 -1 -1 -1 -1 -1 
	Sample Output 1:
	10 
	20 30 
	40 50 60 
	Sample Input 2:
	8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
	Sample Output 2:
	8 
	3 10 
	1 6 14 
	4 7 13 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

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

		printLevelWise(root);

	}


	private static void printLevelWise(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		Queue <BinaryTreeNode<Integer>> pending = new LinkedList<>();
		pending.add(root);
		pending.add(null);
		while(!pending.isEmpty()) {
			BinaryTreeNode<Integer> newNode = pending.remove();
			if(newNode==null) {
				System.out.println();
				if(!pending.isEmpty()) {
					pending.add(null);
				}
			}else {
				System.out.print(newNode.data+" ");
				if(newNode.left!=null) {
					pending.add(newNode.left);
				}
				if(newNode.right!=null) {
					pending.add(newNode.right);
				}
			}
		}
	}
}