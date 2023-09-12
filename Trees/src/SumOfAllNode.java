/*
 * Sum of all nodes

	Given a generic tree, count and return the sum of all nodes present in the given tree.
	Input format :
	Elements in level order form separated by space (as per done in class). Order is - 
	Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 
	Output Format :
	Sum of all nodes
	Sample Input :
	10 3 20 30 40 2 40 50 0 0 0 0 
	Sample Output :
	190
 */
import java.util.Scanner;
 
public class SumOfAllNode {

	static Scanner s = new Scanner(System.in);

	public static TreeNode<Integer> takeInputLevelWise(){
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>();  
		// Queue of node that are entered themselves but their children aren't added yet
		int rootData = s.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);
		while(!pendingNodes.isEmpty()){
			TreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
				int numChild = s.nextInt();
				for(int i = 0 ; i < numChild; i++){
					int currentChild = s.nextInt();
					TreeNode<Integer> childNode = new TreeNode<Integer>(currentChild);
					pendingNodes.enqueue(childNode);
					currentNode.children.add(childNode);
				}
			} catch (QueueEmptyException e) {
			}
		}
		return root;
	}


	public static void main(String[] args) {
		TreeNode<Integer> root =  takeInputLevelWise();
		System.out.println(sumOfAllNode(root));
	}


	private static int sumOfAllNode(TreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int sum =root.data;
		
		for(int i=0; i<root.children.size(); i++) {
			int smallSum = sumOfAllNode(root.children.get(i));
			sum +=smallSum;
		}
		return sum;
	}

}
