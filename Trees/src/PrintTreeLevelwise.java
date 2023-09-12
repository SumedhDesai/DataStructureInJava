/*
 * Print Tree Level-wise
	Send Feedback
	Given a generic tree, print the input tree in level wise order. 
	That is, print the elements at same level in one line (separated by space). 
	Print different levels in differnet lines.
	Input format :
	Elements in level order form separated by space (as per done in class). Order is - 
	Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 
	Output Format :
	Level wise print
	Sample Input :
	10 3 20 30 40 2 40 50 0 0 0 0 
	Sample Output :
	10
	20 30 40 
	40 50
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrintTreeLevelwise {

	private static void printLevelWise(TreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		Queue<TreeNode<Integer>> pending = new LinkedList<>();
		System.out.println(root.data);
		pending.add(root);
		pending.add(null);
		while(!pending.isEmpty()) {
			TreeNode<Integer> front  = pending.remove();
			if(front==null) {
				System.out.println();
				if(!pending.isEmpty()) {
					pending.add(null);
				}
			}else {
				for(int i=0; i<front.children.size(); i++) {
					System.out.print(front.children.get(i).data+" ");
					pending.add(front.children.get(i));
				}
			}
		}
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
		printLevelWise(root); 
	}




}
