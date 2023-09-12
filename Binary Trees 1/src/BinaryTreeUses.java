/*
 * Taking input and Printing Binary Tree
 */
import java.util.Scanner;

public class BinaryTreeUses {

	public static void main(String[] args) {
		
//		BinaryTree<Integer> root = new BinaryTree<Integer>(1);
//		BinaryTree<Integer> rootLeft = new BinaryTree<Integer>(2);
//		BinaryTree<Integer> rootRight = new BinaryTree<Integer>(3);
//		root.left=rootLeft;
//		root.right=rootRight;
//		BinaryTree<Integer> twoRight = new BinaryTree<Integer>(4);
//		rootLeft.right=twoRight;
//		BinaryTree<Integer> threeLeft = new BinaryTree<Integer>(5);
//		rootRight.left=threeLeft;

		BinaryTree<Integer> root = takeInputBetter(0, true, false);
		printTree(root);

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

	private static BinaryTree<Integer> takeInput() {
		System.out.println("enter root");
		Scanner s = new Scanner(System.in);
		int rootData= s.nextInt();
		
		if(rootData==-1) {
			return null;
		}
		
		BinaryTree<Integer> root = new BinaryTree<Integer>(rootData);
		BinaryTree<Integer> rootLeft = takeInput();
		BinaryTree<Integer> rootRight = takeInput();
		root.left=rootLeft;
		root.right=rootRight;
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
