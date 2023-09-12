/*
 * Remove leaf nodes
 */
import java.util.Scanner;

public class RemoveLeaf {

	public static void main(String[] args) {
		BinaryTree<Integer> root = takeInputBetter(0, true, false);
		print(root);
		System.out.println("*****");
		BinaryTree<Integer> newRoot = removeLeafNode(root);
		print(newRoot);

	}
	private static BinaryTree<Integer> removeLeafNode(BinaryTree<Integer> root) {
		if(root==null) {
			return null;
		}
		if(root.left==null && root.right==null) {
			return null;
		}
		BinaryTree<Integer> rootLeft = removeLeafNode(root.left);
		BinaryTree<Integer> rootRight = removeLeafNode(root.right);
		root.left = rootLeft;
		root.right = rootRight;
		return root;
	}
	private static void print(BinaryTree<Integer> root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data + ":");
		if(root.left!=null) {
			System.out.print(" L"+root.left.data);
		}
		if(root.right!=null) {
			System.out.print(" R"+root.right.data);
		}
		System.out.println();
		print(root.left);
		print(root.right);
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
