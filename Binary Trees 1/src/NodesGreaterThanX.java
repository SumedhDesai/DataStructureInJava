/*
 * Nodes Greater Than X

	For a given a binary tree of integers and an integer X, find and return the total 
	number of nodes of the given binary tree which are having data greater than X.
	Input Format:
	The first line of input will contain the node data, all separated by a single space. 
	Since -1 is used as an indication whether the left or right node data exist for root, 
	it will not be a part of the node data.
	
	The second line of input contains an integer, denoting the value of X.
	Note:
	You are not required to print anything explicitly. It has already been taken care of.
	Output Format:
	The only line of output prints the total number of nodes where the node data is greater 
	than X.
	Constraints:
	1 <= N <= 10^5
	Where N is the total number of nodes in the binary tree.
	
	Time Limit: 1 sec
	Sample Input 1:
	1 4 2 3 -1 -1 -1
	2
	Sample Output 1:
	2
	Explanation for Sample Input 1:
	Out of the four nodes of the given binary tree, [3, 4] are the node data that are greater 
	than X = 2.
	Sample Input 2:
	5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
	5
	Sample Output 2:
	3
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NodesGreaterThanX {

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
		int x = Integer.parseInt(br.readLine().trim());
		int count = countNodesGreaterThanX(root, x);

		System.out.println(count);
	}

	private static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
		if(root==null) {
			return 0;
		}
		int leftCount = countNodesGreaterThanX(root.left, x);
		int rightCount = countNodesGreaterThanX(root.right, x);
		if(root.data>x) {
		return 1+leftCount+rightCount;
		}else {
			return leftCount+rightCount;
		}
	}
}