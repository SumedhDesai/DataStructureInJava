/*
 * Minimum and Maximum in the Binary Tree

	For a given a Binary Tree of type integer, find and return the 
	minimum and the maximum data values.
	Return the output as an object of Pair class, which is already created.
	Note:
	All the node data will be unique and hence there will always exist a 
	minimum and maximum node data.
	Input Format:
	The first and the only line of input will contain the node data, all 
	separated by a single space. Since -1 is used as an indication whether 
	the left or right node data exist for root, it will not be a part of the node data.
	Output Format:
	The only line of output prints two integers denoting the minimum and the 
	maximum data values respectively. A single line will separate them both.
	Constraints:
	2 <= N <= 10^5
	Where N is the total number of nodes in the binary tree.
	
	Time Limit: 1 sec
	Sample Input 1:
	8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
	Sample Output 1:
	1 14
	Sample Input 2:
	10 20 60 -1 -1 3 50 -1 -1 -1 -1 
	Sample Output 2:
	3 60
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


class Pair<T, U> {
	T minimum;
	U maximum;

	public Pair(T minimum, U maximum) {
		this.minimum = minimum;
		this.maximum = maximum;
	}

}

public class MinimumAndMaximumInTheBinaryTree {

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
		
		Pair<Integer, Integer> pair = getMinAndMax(root);
		System.out.println(pair.minimum + " " + pair.maximum);
		
	}


	private static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
		if(root==null) {
			 Pair<Integer, Integer> p = new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE);
			return p; 
		}
		Pair<Integer, Integer> pairLeft = getMinAndMax(root.left);
		Pair<Integer, Integer> pairRight = getMinAndMax(root.right);
		
		int min = Math.min(root.data, Math.min(pairLeft.minimum, pairRight.minimum));
		int max = Math.max(root.data, Math.max(pairLeft.maximum, pairRight.maximum));
		
		Pair<Integer, Integer> pair = new Pair(min, max);
		return pair;
	}
}