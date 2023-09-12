/*
 * Structurally identical
	
	Given two Generic trees, return true if they are structurally identical i.e. 
	they are made of nodes with the same values arranged in the same way.
	Input format :
	
	Line 1 : Tree 1 elements in level order form separated by space (as per done 
	in class). Order is -
	
	Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element
	
	Line 2 : Tree 2 elements in level order form separated by space (as per done 
	in class). Order is -
	
	Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element
	
	Output format : true or false
	
	Sample Input 1 :
	10 3 20 30 40 2 40 50 0 0 0 0 
	10 3 20 30 40 2 40 50 0 0 0 0
	Sample Output 1 :
	true
	Sample Input 2 :
	10 3 20 30 40 2 40 50 0 0 0 0 
	10 3 2 30 40 2 40 50 0 0 0 0
	Sample Output 2:
	false 
 */
import java.util.Scanner;

public class StructurallyIdentical {

	private static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if(root1==null || root2==null) {
			return false;
		}
		if(root1.children.size()!=root2.children.size()) {
			return false;
		}
		boolean ans = false;
		if(root1.data == root2.data) {
			ans = true;
		}
		
		for(int i=0; i<root1.children.size(); i++) {
			boolean smallAns = checkIdentical(root1.children.get(i), root2.children.get(i));
			if(!smallAns ) {
				ans =false;
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
		TreeNode<Integer> root1 =  takeInputLevelWise();
		TreeNode<Integer> root2 = takeInputLevelWise();
		System.out.println(checkIdentical(root1, root2));
	}
}
