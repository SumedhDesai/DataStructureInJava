/*
 * Find path in BST

	Given a BST and an integer k. Find and return the path from the node 
	with data k and root (if a node with data k is present in given BST) 
	in a list. Return empty list otherwise.
	Note: Assume that BST contains all unique elements.
	Input Format :
	The first line of input contains data of the nodes of the tree in level 
	order form. The data of the nodes of the tree is separated by space. 
	If any node does not have left or right child, take -1 in its place. 
	Since -1 is used as an indication whether the left or right nodes exist, 
	therefore, it will not be a part of the data of any node.   
	The following line of input contains an integer, that denotes the value of k.
	Output Format :
	The first line and only line of output prints the data of the nodes in the 
	path from node k to root. The data of the nodes is separated by single space.
	Constraints:
	Time Limit: 1 second   
	Sample Input 1:
	8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
	2
	Sample Output 1:
	2 5 8
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class FindPathInBST {

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

	public static void main(String[] args) throws IOException {
		BinaryTreeNode<Integer> root = takeInput();
		int k = Integer.parseInt(br.readLine());
		ArrayList<Integer> output = getPath(root, k);
		if(output != null) {
			for(int i : output) {
				System.out.print(i+" ");
			}
		}
	}

	private static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int k) {
		if(root==null) {
			return null;
		}
		if(root.data==k) {
			ArrayList<Integer> output = new ArrayList<>(); 
			output.add(root.data); // when we find data then only we create array list
			return output;			// then pass that array list
		}
		if(root.data>k) {
			ArrayList<Integer> leftOutput = getPath(root.left, k);
			// her we only create pointer of array list which point to array list of answer
			if(leftOutput!=null) {
				// if leftOutput is not null so now leftOutput is pointing to array list
				// that is created when answer is found
				leftOutput.add(root.data);
				return leftOutput;
			}
		}else if(root.data<k) {
			ArrayList<Integer> rightOutput = getPath(root.right, k);
			if(rightOutput!=null) {
				rightOutput.add(root.data);
				return rightOutput;
			}
		}
		return null;
	}

}