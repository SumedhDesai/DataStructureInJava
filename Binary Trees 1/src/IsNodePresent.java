/*
 * Is Node Present?

	For a given Binary Tree of type integer and a number X, find whether 
	a node exists in the tree with data X or not.
	 Input Format:
	The first line of each test case contains elements of the first tree 
	in the level order form. The line consists of values of nodes separated 
	by a single space. In case a node is null, we take -1 in its place.
	
	The second line of each test case contains the node value you have to find.
	
	
	For example, the input for the tree depicted in the below image would be:
	example
	
	1
	2 3
	4 -1 5 6
	-1 7 -1 -1 -1 -1
	-1 -1
	Explanation:
	Level 1:
	The root node of the tree is 1
	
	Level 2:
	Left child of 1 = 2
	Right child of 1 = 3
	
	Level 3:
	Left child of 2 = 4
	Right child of 2 = null (-1)
	Left child of 3 = 5
	Right child of 3 = 6
	
	Level 4:
	Left child of 4 = null (-1)
	Right child of 4 = 7
	Left child of 5 = null (-1)
	Right child of 5 = null (-1)
	Left child of 6 = null (-1)
	Right child of 6 = null (-1)
	
	Level 5:
	Left child of 7 = null (-1)
	Right child of 7 = null (-1)
	
	The first not-null node(of the previous level) is treated as the 
	parent of the first two nodes of the current level. The second 
	not-null node (of the previous level) is treated as the parent 
	node for the next two nodes of the current level and so on.
	The input ends when all nodes at the last level are null(-1).
	Note:
	The above format was just to provide clarity on how the input is 
	formed for a given tree.
	The sequence will be put together in a single line separated by a 
	single space. Hence, for the above-depicted tree, the input will be given as:
	
	1 2 3 4 -1 5 6 -1 7 -1 -1 -1 -1 -1 -1
	Output Format:
	The only line of output prints 'true' or 'false'.
	
	The output of each test case should be printed in a separate line.
	Note:
	You are not required to print anything explicitly. It has already been taken care of.
	Constraints:
	1 <= N <= 10^5

	Where N is the total number of nodes in the binary tree.
	
	Time Limit: 1 sec.
	Sample Input 1:
	8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
	7
	Sample Output 1:
	true
	Explanation For Output 1:
	Clearly, we can see that 7 is present in the tree. So, the output will be true.
	Sample Input 2:
	2 3 4 -1 -1 -1 -1
	10
	Sample Output 2:
	false
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IsNodePresent {

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
		int x = Integer.parseInt(br.readLine().trim());

		boolean ans = isNodePresent(root, x);

		System.out.println(ans);
	}

	private static boolean isNodePresent(BinaryTreeNode<Integer> root, int k) {
		if(root==null) {
			return false;
		}
		if(root.data==k) {
			return true;
		}
		boolean left=isNodePresent(root.left, k);
		boolean right=isNodePresent(root.right, k);
		if(left||right) {
			return true;
		}else {
			return false;
		}
	}
}