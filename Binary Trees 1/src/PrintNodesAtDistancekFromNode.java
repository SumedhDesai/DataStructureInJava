/*
 * Print nodes at distance k from node

	You are given a Binary Tree of type integer, a target node, and an 
	integer value K.
	Print the data of all nodes that have a distance K from the target node. 
	The order in which they would be printed will not matter.
	Example:
	For a given input tree(refer to the image below):
	1. Target Node: 5
	2. K = 2

	Starting from the target node 5, the nodes at distance K are 7 4 and 1.
	Input Format:
	The first line of input will contain the node data, all separated by a 
	single space. Since -1 is used as an indication whether the left or right 
	node data exist for root, it will not be a part of the node data.
	
	The second line of input contains two integers separated by a single space, 
	representing the value of the target node and K, respectively.
	Output Format:
	All the node data at distance K from the target node will be printed on a new line.
	
	The order in which the data is printed doesn't matter.
	Constraints:
	1 <= N <= 10^5
	Where N is the total number of nodes in the binary tree.
	
	Time Limit: 1 sec
	Sample Input 1:
	5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
	3 1
	Sample Output 1:
	9
	6
	Sample Input 2:
	1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
	3 3
	Sample Output 2:
	4
	5
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintNodesAtDistancekFromNode {

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
		String[] target_k = br.readLine().trim().split(" ");

		int target = Integer.parseInt(target_k[0].trim());
		int k = Integer.parseInt(target_k[1].trim());

		nodesAtDistanceK(root, target, k);
	}

	private static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
		if(root==null) {
			return;
		}
		nodesAtDistanceKHelper(root, node, k);

	}

	private static int nodesAtDistanceKHelper(BinaryTreeNode<Integer> root, int node, int k) {
		if(root==null) {
			return -1;				// node is not present because tree is null
		}
		if(root.data==node) {
			printNodeAtDepthK(root, k);
			return 0;
		}
		int leftD = nodesAtDistanceKHelper(root.left, node, k);
		if(leftD!=-1) {
			if(leftD+1==k) {
//means root is at distance k so no need to go to print right side subtree element
				System.out.println(root.data);
			}else {
				printNodeAtDepthK(root.right, k-(leftD+1)-1);
			}
			return leftD+1;
		}
		int rightD = nodesAtDistanceKHelper(root.right, node, k);
		if(rightD!=-1) {
			if(rightD+1==k) {
//means root is at distance k so no need to go to print left side subtree element
				System.out.println(root.data);
			}else {
				printNodeAtDepthK(root.left, k-(rightD+1)-1);
			}
			return rightD+1;
		}
		return -1;				// node is not present 
	}

	private static void printNodeAtDepthK(BinaryTreeNode<Integer> root, int k) {
		if(root==null) {
			return;
		}
		if(k==0) {
			System.out.println(root.data);
		}
		printNodeAtDepthK(root.left, k-1);
		printNodeAtDepthK(root.right, k-1);
	}
}