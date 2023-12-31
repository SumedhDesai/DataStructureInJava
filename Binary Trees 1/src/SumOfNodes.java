/*
 * Sum Of Nodes

	For a given Binary Tree of integers, find and return the sum of all the nodes data.
	Example:
	                        10
	                      /      \
	                    20      30
	                   /    \
	                 40    50
	
	When we sum up all the nodes data together, [10, 20, 30, 40 50] we get 150. 
	Hence, the output will be 150.
	 Input Format:
	The first and the only line of input will contain the nodes data, all separated 
	by a single space. Since -1 is used as an indication whether the left or right 
	node data exist for root, it will not be a part of the node data.
	Output Format:
	The first and the only line of output prints the sum of all the nodes data present 
	in the binary tree.
	Note:
	You are not required to print anything explicitly. It has already been taken care of.
	Constraints:
	1 <= N <= 10^6
	Where N is the total number of nodes in the binary tree.
	
	Time Limit: 1 sec
	Sample Input 1:
	2 3 4 6 -1 -1 -1 -1 -1
	Sample Output 1:
	 15
	Sample Input 2:
	1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
	Sample Output 2:
	 28
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfNodes {

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
		System.out.println(getSum(root));
	}

	private static int getSum(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		int leftSum = getSum(root.left);
		int rightSum = getSum(root.right);
		int sum= root.data+leftSum+rightSum;
		return sum;
	}
}