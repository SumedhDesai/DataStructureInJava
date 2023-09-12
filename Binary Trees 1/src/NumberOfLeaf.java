/*
 * Number of leaf node in Binary Tree
 */
import java.util.Scanner;

public class NumberOfLeaf {
	
	public static void main(String[] args) {
		BinaryTree<Integer> root= takeInputBetter(0,true,false);
		int leaf = numberOfLeaf(root);
		System.out.println(leaf);
	}
	
	private static int numberOfLeaf(BinaryTree<Integer> root) {
		if(root==null) {
			return 0;
		}
		if(root.left==null && root.right==null) {
			return 1;
		}
		int leftLeaf = numberOfLeaf(root.left);
		int rightLeaf = numberOfLeaf(root.right);
		return leftLeaf+rightLeaf;
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
