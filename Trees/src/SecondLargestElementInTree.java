/*
 * Second Largest Element In Tree

	Given a generic tree, find and return the node with second largest value in given tree. 
	Return NULL if no node with required value is present.
	Input format :
	Elements in level order form separated by space (as per done in class). Order is - 

	Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 
	Output format:
	Second Largest node data
	Sample Input 1 :
	10 3 20 30 40 2 40 50 0 0 0 0 
	Sample Output 1 :
	40
 */
import java.util.Scanner;

public class SecondLargestElementInTree {

	private static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root) {
		if(root == null) {
			return null ;
		}
		LargePair p = findSecondLargestHelper(root);
		return p.second;
	}


	private static LargePair findSecondLargestHelper(TreeNode<Integer> root) {
		if(root == null) {
			return new LargePair(null, null);
		}
		LargePair ans = new LargePair();
		ans.first = root;
		ans.second=null;
		for(TreeNode<Integer> child : root.children) {
			LargePair childAns = findSecondLargestHelper(child);
			if(ans.first.data < childAns.first.data) {
				if(childAns.second == null || ans.first.data > childAns.second.data) {
					ans.second = ans.first;
					ans.first=childAns.first;
				}else {
					ans.first = childAns.first;
					ans.second = childAns.second;
				}
			}else if(ans.first.data.equals(childAns.first.data) && childAns.second !=null) {
				if(ans.second==null || ans.second.data < childAns.second.data) {
					ans.second = childAns.second;
				}
			}else if(ans.first.data > childAns.first.data) {
				if(ans.second==null || ans.second.data < childAns.first.data) {
					ans.second = childAns.first;
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
		TreeNode<Integer> root =  takeInputLevelWise();
		TreeNode<Integer> ans = findSecondLargest(root);
		if(ans == null){
			System.out.println(Integer.MIN_VALUE);
		}else{
			System.out.println(ans.data);
		} 
	}
}
