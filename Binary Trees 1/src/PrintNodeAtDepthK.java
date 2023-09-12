/*
 * Print node at depth k
 */
import java.util.Scanner;

public class PrintNodeAtDepthK {
	public static void main(String[] args) {
		
		BinaryTree<Integer>root=takeInputBetter(0, true , false);
		printNodeAtDepthK(root, 2);
		
	}
	private static void printNodeAtDepthK(BinaryTree<Integer> root, int k) {
		
		if(root==null) {
			return;
		}
		if(k==0) {
			System.out.println(root.data);
			return;
		}
		printNodeAtDepthK(root.left, k-1);
		printNodeAtDepthK(root.right, k-1);
		
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
