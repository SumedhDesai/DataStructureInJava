/*
 * Pair sum in a BST

	Given a binary search tree and an integer S, find pair of nodes in the BST 
	which sum to S. You can use extra space of the order of O(log n).
	Note:
	1. Assume BST contains all unique elements.
	2. In a pair, print the smaller element first.
	Input Format :
	The first line of input contains data of the nodes of the tree in level order 
	form. The data of the nodes of the tree is separated by space. If any node does 
	not have left or right child, take -1 in its place. Since -1 is used as an indication 
	\whether the left or right nodes exist, therefore, it will not be a part of the data 
	of any node.   
	The following line of input contains an integer, that denotes the value of S.
	Output format:
	You have to print each pair in a different line (pair elements separated by space). 
	The order of different pairs, to be printed, does not matter.
	Constraints:
	Time Limit: 1 second   
	Sample Input 1:
	8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
	12
	Sample Output 1:
	2 10
	5 7
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class PairSumInBST {

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
		int s = Integer.parseInt(br.readLine());
		printNodesSumToS(root,s);
	}

	private static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
		if(root == null) {
			return;
		}
		Stack<BinaryTreeNode<Integer>> inorder = new Stack<BinaryTreeNode<Integer>>();
		Stack<BinaryTreeNode<Integer>> revInorder = new Stack<BinaryTreeNode<Integer>>();
		int totalCount = count(root);
		int count = 0;

		BinaryTreeNode<Integer> temp; 
		temp = root;
		while(temp != null) {
			inorder.add(temp);
			temp=temp.left;
		}
		temp = root;
		while(temp !=null) {
			revInorder.add(temp);
			temp=temp.right;
		}

		while(count < totalCount -1 ) { // we add root two times and pair sum requird two elment so count-2;
			BinaryTreeNode<Integer> top1 = inorder.peek();
			BinaryTreeNode<Integer> top2 = revInorder.peek();

			if(top1.data+top2.data == s) {
				System.out.println(top1.data+" "+top2.data);

				BinaryTreeNode<Integer> top = top1;
				inorder.pop();
				count++;
				if(top.right!=null) {
					top=top.right;
					while(top!=null) {
						inorder.add(top);
						top=top.left;
					}
				}
				top = top2;
				revInorder.pop();
				count++;
				if(top.left!=null) {
					top=top.left;
					while(top!=null) {
						revInorder.add(top);
						top=top.right;
					}
				}
			}else if(top1.data+top2.data > s) {
				BinaryTreeNode<Integer> top = top2;
				revInorder.pop();
				count++;
				if(top.left!=null) {
					top=top.left;
					while(top!=null) {
						revInorder.add(top);
						top=top.right;
					}
				}
			}else {
				BinaryTreeNode<Integer> top = top1;
				inorder.pop();
				count++;
				if(top.right!=null) {
					top=top.right;
					while(top!=null) {
						inorder.add(top);
						top=top.left;
					}
				}
			}
		}
	}

	private static int count(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		return 1+ count(root.left)+count(root.right);
	}

}