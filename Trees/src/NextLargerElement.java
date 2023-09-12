/*
 * Next larger element

	Given a generic tree and an integer n. Find and return the node 
	with next larger element in the Tree i.e. find a node with value 
	just greater than n.
	Return NULL if no node is present with value greater than n.
	Input format :
	Line 1 : Integer n
	Line 2 : Elements in level order form separated by space (as per 
	done in class). Order is -
	Root_data, n (No_Of_Child_Of_Root), n children, and so on for 
	every element
	Output format : Node with value just greater than n.
	
	Sample Input 1 :
	18
	10 3 20 30 40 2 40 50 0 0 0 0 
	Sample Output 1 :
	20
	Sample Input 2 :
	21
	10 3 20 30 40 2 40 50 0 0 0 0 
	Sample Output 2:
	30
 */
import java.util.Scanner;

public class NextLargerElement {

	private static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n) {
		if(root == null ) {
			return null;
		}
		TreeNode<Integer> ans = null;
		if(root.data > n) {
			ans = root;
		}
		
		for(TreeNode<Integer> child : root.children) {
			TreeNode<Integer> smallAns = findNextLargerNode(child, n);
	
			if (smallAns != null ) {
				if(ans==null || smallAns.data < ans.data) {
					ans = smallAns;
				}
			}
		}
		return ans;
	}


	static Scanner s = new Scanner(System.in);

	public static TreeNode<Integer> takeInputLevelWise(){
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>();  // Queue of node that are entered themselves but their children aren't added yet
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
   int n = s.nextInt();
    TreeNode<Integer> root =  takeInputLevelWise();

		TreeNode<Integer> ans = findNextLargerNode(root, n);
		if(ans == null){
			System.out.println(Integer.MIN_VALUE);
		}else{
			System.out.println(ans.data);
		}

	}
}
