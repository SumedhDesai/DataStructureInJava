/*
 * Take input level wise
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TakeInputLevelwise {

	public static void main(String[] args) {
		BinaryTree<Integer> root = takeInputLevelwise();
		printTree(root);

	}
	private static BinaryTree<Integer> takeInputLevelwise() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter root data");
		int rootData = s.nextInt();
		if(rootData==-1) {
			return null;
		}
		BinaryTree<Integer> root = new BinaryTree<Integer>(rootData);
		Queue<BinaryTree<Integer>> pending = new LinkedList<BinaryTree<Integer>>();
		pending.add(root);

		while(!pending.isEmpty()) {
			BinaryTree<Integer> node = pending.remove();
			System.out.println("Enter left node of "+node.data);
			int leftData = s.nextInt();
			if(leftData!=-1) {
				BinaryTree<Integer> newNode = new BinaryTree<Integer>(leftData);
				node.left= newNode;
				pending.add(newNode);
			}
			System.out.println("Enter right node of "+node.data);
			int rightData = s.nextInt();
			if(rightData!=-1) {
				BinaryTree<Integer> newNode = new BinaryTree<Integer>(rightData);
				node.right= newNode;
				pending.add(newNode);
			}
		}
		return root;
	}
	private static void printTree(BinaryTree<Integer> root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data+" : ");
		if(root.left!=null) {
			System.out.print("L"+root.left.data+" ");
		}
		if(root.right!=null) {
			System.out.print("R"+root.right.data);
		}
		System.out.println();
		printTree(root.left);
		printTree(root.right);
	}

}


