/*
 * Take Input of tree Level wise
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TakeInputLevelwise {
	
	public static void main(String[] args) {
		TreeNode<Integer> root = takeInput();
		printTreeDetailed(root);
	}
	private static TreeNode<Integer> takeInput() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter root data");
		int rootData = s.nextInt();
		if(rootData == -1) {
			return null;
		}
		Queue<TreeNode<Integer>> pending = new LinkedList<>();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		pending.add(root);
		
		while(!pending.isEmpty()) {
			TreeNode<Integer> front = pending.remove();
			System.out.println("Enter number of childeren for"+ front.data);
			int numChild = s.nextInt();
			for(int i= 0; i<numChild; i++) {
				System.out.println("Enter "+(i+1)+"th child of "+ front.data);
				int child = s.nextInt();
				TreeNode<Integer> newNode = new TreeNode<Integer>(child);
				front.children.add(newNode);
				pending.add(newNode);
				}
		}
		return root;
	}
	private static void printTreeDetailed(TreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data+ ": ");
		for(int i=0; i< root.children.size(); i++) {
			System.out.print(root.children.get(i).data+" ");
		}
		System.out.println();
		for(int i=0; i< root.children.size(); i++) {
			printTreeDetailed(root.children.get(i));
		}
	}

}
