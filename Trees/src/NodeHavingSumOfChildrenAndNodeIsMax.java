/*
 * Node having sum of children and node is max
	
	Given a tree, find and return the node for which sum of data 
	of all children and the node itself is maximum. In the sum, data 
	of node itself and data of immediate children is to be taken.
	Input format :
	
	Line 1 : Elements in level order form separated by space (as per done in class). 
	Order is -
	
	Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element
	
	Output format : Node with maximum sum.
	
	Sample Input 1 :
	5 3 1 2 3 1 15 2 4 5 1 6 0 0 0 0
	Sample Output 1 :
	1
 */
import java.util.Scanner;

public class NodeHavingSumOfChildrenAndNodeIsMax {


	private static TreeNode<Integer> maxSumNode(TreeNode<Integer> root) {
		if(root == null) {
			return null;
		}
		maxNode node = maxSumNodeHelper(root);
		return node.maxNode;
	}


	private static maxNode maxSumNodeHelper(TreeNode<Integer> root) {
		int sum =root.data;
		int childSum=0;
		for(int j =0; j<root.children.size(); j++) {
			childSum += root.children.get(j).data;
		}
		sum += childSum;
		maxNode ans = new maxNode();
		ans.max = sum;
		ans.maxNode=root;

		for(int i=0; i<root.children.size(); i++) {
			maxNode smallAns = maxSumNodeHelper(root.children.get(i));
			if(smallAns.max > ans.max){
				ans = smallAns;
			}
		}
		return ans;

	}


	static Scanner s = new Scanner(System.in);

	public static TreeNode<Integer> takeInputLevelWise(){
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>();  // Queue of node that are entered themselves but their children aren't added yet
		//		System.out.println("Enter root Data");
		int rootData = s.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);
		while(!pendingNodes.isEmpty()){
			TreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
				//				System.out.println("Enter number of children of "+currentNode.data);
				int numChild = s.nextInt();
				for(int i = 0 ; i < numChild; i++){
					//					System.out.println("Enter "+ i + "th child of " + currentNode.data);
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
		TreeNode<Integer> ans = maxSumNode(root);
		if(ans == null){
			System.out.println(Integer.MIN_VALUE);
		}else{
			System.out.println(ans.data);
		}

	}
}
