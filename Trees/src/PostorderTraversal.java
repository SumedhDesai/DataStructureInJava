/*
 * Code : Post-order Traversal

	Given a generic tree, print the post-order traversal of given tree.
	The post-order traversal is: visit child nodes first and then root node.
	Input format:
	The first line of input contains data of the nodes of the tree in level 
	order form. The order is: data for root node, number of children to root 
	node, data of each of child nodes and so on and so forth for each node. 
	The data of the nodes of the tree is separated by space.
	Output Format :
	The first and only line of output contains the elements printed in post-order 
	traversal. The elements in the output must be separated by a single space.
	Constraints:
	Time Limit: 1 sec
	Sample Input 1:
	10 3 20 30 40 2 400 50 0 0 0 0 
	Sample Output 1:
	400 50 20 30 40 10
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PostorderTraversal {

	private static void printPostOrder(TreeNode<Integer> root) {
		if(root == null ) {
			return;
		}
		for(int i=0; i<root.children.size(); i++) {
			printPostOrder(root.children.get(i));
		}
		System.out.print(root.data+" ");
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	static StringTokenizer st;

	public static TreeNode<Integer> takeInputLevelWise() throws IOException {
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>(); // Queue of node that are
		// entered themselves
		// but their children
		// aren't added yet
		st = new StringTokenizer(br.readLine());
		int rootData = Integer.parseInt(st.nextToken());
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);
		while (!pendingNodes.isEmpty()) {
			TreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
				int numChild = Integer.parseInt(st.nextToken());
				for (int i = 0; i < numChild; i++) {
					int currentChild = Integer.parseInt(st.nextToken());
					TreeNode<Integer> childNode = new TreeNode<Integer>(currentChild);
					pendingNodes.enqueue(childNode);
					currentNode.children.add(childNode);
				}
			} catch (QueueEmptyException e) {
			}
		}
		return root;
	}

	public static void main(String[] args) throws IOException {
		TreeNode<Integer> root = takeInputLevelWise();
		printPostOrder(root);

	}

	
}