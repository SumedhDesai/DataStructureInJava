/*
 * Count number of nodes 
 */
import java.util.Scanner;

public class NumberOfNodes {

	public static void main(String[] args) {
		BinaryTree<Integer> root = takeInputBetter(0, true, false);
		int numNode= numNode(root);
		System.out.println(numNode);

	}
	private static int numNode(BinaryTree<Integer> root) {
		if(root==null) {
			return 0;
		}
		int leftNode = numNode(root.left);
		int rightNode = numNode(root.right);
		return 1+ leftNode+rightNode;
	}
	private static BinaryTree<Integer> takeInputBetter(int parentData, boolean isRoot, boolean isLeft){
		if(isRoot) {
			System.out.println("Enter root");
		}else {
			if(isLeft) {
				System.out.println("Enter left child of "+ parentData);
			}else {
				System.out.println("Enter right child of"+ parentData);
			}
		}
		Scanner s= new Scanner (System.in);
		int rootData=s.nextInt();
		if(rootData==-1) {
			return null;
		}
		BinaryTree<Integer> root = new BinaryTree<Integer>(rootData);
		BinaryTree<Integer> leftChild=takeInputBetter(rootData, false, true);
		BinaryTree<Integer> rightChild= takeInputBetter(rootData, false, false);
		root.left=leftChild;
		root.right=rightChild;
		return root;
	}

}
