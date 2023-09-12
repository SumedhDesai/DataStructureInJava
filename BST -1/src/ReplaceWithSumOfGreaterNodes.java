/*
 * Replace with Sum of greater nodes

	Given a binary search tree, you have to replace each node's data 
	with the sum of all nodes which are greater or equal than it. 
	You need to include the current node's data also.
	That is, if in given BST there is a node with data 5, you need to 
	replace it with sum of its data (i.e. 5) and all nodes whose data 
	is greater than or equal to 5.
	Note: You don't need to return or print, just change the data of each 
	node.
	Input format:
	The first line of input contains data of the nodes of the tree in level 
	order form. The data of the nodes of the tree is separated by space. 
	If any node does not have left or right child, take -1 in its place. 
	Since -1 is used as an indication whether the left or right nodes exist, 
	therefore, it will not be a part of the data of any node.
	Output format:
	In the output, data of the nodes of the tree are printed in level order 
	form. Each level of the tree is printed on a separate line.
	Constraints:
	Time Limit: 1 second
	Sample Input 1 :
	8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
	Sample Output 1 :
	18 
	36 10 
	38 31 
	25 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReplaceWithSumOfGreaterNodes {

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

	public static void printLevelWiseAtDiffLevel(BinaryTreeNode<Integer> root) throws QueueEmptyException {
		if (root == null)
			return;
		QueueUsingLL<BinaryTreeNode<Integer>> q = new QueueUsingLL<BinaryTreeNode<Integer>>();
		q.enqueue(root);
		q.enqueue(null);
		while (!q.isEmpty()) {
			BinaryTreeNode<Integer> first = q.front();
			q.dequeue();
			if (first == null) {
				if (q.isEmpty()) {
					break;
				}
				System.out.println();
				q.enqueue(null);
				continue;
			}
			System.out.print(first.data + " ");
			if (first.left != null) {
				q.enqueue(first.left);
			}
			if (first.right != null) {
				q.enqueue(first.right);
			}
		}
	}

	public static void main(String[] args) throws IOException, QueueEmptyException {
		BinaryTreeNode<Integer> root = takeInput();
		replaceWithLargerNodesSum(root);
		printLevelWiseAtDiffLevel(root);
	}

	private static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		replace(root, 0);
	}

	private static int replace(BinaryTreeNode<Integer> root, int sum) {
		if(root==null) {
			return sum; // as null root can't add anything so it simply return sum
		}				// that came from caller
		sum = replace(root.right, sum);  // getting sum of right sub tree
		sum = sum+ root.data;		   	 //updating sum with root data
		root.data=sum;					// updating root
		sum = replace(root.left, sum); //giving sum to left side to add itself to sum
		return sum;					// Returning sum of whole subtree to calling node
		
	}

}