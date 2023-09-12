/*
 * Print Level wise

	For a given a Binary Tree of type integer, print the complete information 
	of every node, when traversed in a level-order fashion.
	To print the information of a node with data D, you need to follow the 
	exact format :
	
	           D:L:X,R:Y
	
	Where D is the data of a node present in the binary tree. 
	X and Y are the values of the left(L) and right(R) child of the node.
	Print -1 if the child doesn't exist.
	
	For the above depicted Binary Tree, the level order travel will be printed 
	as followed:
	
	1:L:2,R:3
	2:L:4:,R:-1
	3:L:5:,R:6
	4:L:-1:,R:7
	5:L:-1:,R:-1    
	6:L:-1:,R:-1
	7:L:-1:,R:-1
	
	Note: There is no space in between while printing the information for each node.
	Input Format:
	The first and the only line of input will contain the node data, all separated 
	by a single space. Since -1 is used as an indication whether the left or right 
	node data exist for root, it will not be a part of the node data.
	Output Format:
	Information of all the nodes in the Binary Tree will be printed on a different 
	line where each node will follow a format of D:L:X,R:Y, without any spaces in between.
	Constraints:
	1 <= N <= 10^5
	Where N is the total number of nodes in the binary tree.
	
	Time Limit: 1 sec
	Sample Input 1:
	8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
	 Sample Output 1:
	8:L:3,R:10
	3:L:1,R:6
	10:L:-1,R:14
	1:L:-1,R:-1
	6:L:4,R:7
	14:L:13,R:-1
	4:L:-1,R:-1
	7:L:-1,R:-1
	13:L:-1,R:-1
	Sample Input 2:
	1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
	 Sample Output 2:
	1:L:2,R:3
	2:L:4,R:5
	3:L:6,R:7
	4:L:-1,R:-1
	5:L:-1,R:-1
	6:L:-1,R:-1
	7:L:-1,R:-1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class PrintLevelwise {

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
		Queue <BinaryTreeNode<Integer>> pending = new LinkedList <BinaryTreeNode<Integer>>();
		pending.add(root);
		while(!pending.isEmpty()) {
			BinaryTreeNode<Integer> node = pending.remove();
			System.out.print(node.data+":");
			if(node.left!=null) {
				System.out.print("L:"+node.left.data+",");
				pending.add(node.left);
			}else {
				System.out.print("L:"+"-1"+",");
			}
			if(node.right!=null) {
				System.out.print("R:"+node.right.data);
				pending.add(node.right);
			}else {
				System.out.print("R:"+"-1");
			}
			System.out.println();

		}
	}
}