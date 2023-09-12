/*
 * Is binary tree balance ? with better approach
 */
import java.util.Scanner;

public class IsBalanceImprove {
	public static void main(String[] args) {
		BinaryTree<Integer> root = takeInputBetter(0, true, false);
		BinaryOutput ans = isBalanced(root);
		System.out.println(ans.isBalance);
	}
	private static BinaryOutput isBalanced(BinaryTree<Integer> root) {
		if(root==null) {
			BinaryOutput output = new BinaryOutput(0, true);
			return output;
		}
		BinaryOutput outputLeft = isBalanced(root.left);
		BinaryOutput outputRight = isBalanced(root.right);
		int hight = 1+ Math.max(outputLeft.hight, outputRight.hight);
		boolean bal = true; 
		if(Math.abs(outputLeft.hight-outputRight.hight)>1) {
			bal=false;
		}
		if(!outputLeft.isBalance || !outputRight.isBalance) {
			bal=false;
		}
		BinaryOutput output = new BinaryOutput(hight, bal);
		return output;
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