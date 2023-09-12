/*
 * Is binary tree is balance  
 */
import java.util.Scanner;

public class IsBalance {
	public static void main(String[] args) {
		BinaryTree<Integer> root = takeInputBetter(0, true, false);
		System.out.println(height(root));
		System.out.println(isBalanced(root));
	}
	private static boolean isBalanced(BinaryTree<Integer> root) {
		if(root == null) {
			return true;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		
	// tree is balance if || leftHight-rightHight|| <=1
		
		if(Math.abs(leftHeight-rightHeight)>1) {
			return false;
		}
		boolean isLeftBalance = isBalanced(root.left);
		boolean isRightBalance = isBalanced(root.right);
		
		return isLeftBalance && isRightBalance;
	}
	private static int height(BinaryTree<Integer> root) {
		if(root==null) {
			return 0;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		return 1+Math.max(leftHeight,rightHeight);
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