/*
 * Check tree is BST or not
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IsBST {

	public static void main(String[] args) {
		BinaryTree<Integer>root = takeInputLevelwise();
		System.out.println(isTreeBST(root));
		BSTReturn ans = isBSTbetter(root);
		System.out.println(ans.isBST + " "+ ans.max+ " "+ ans.min);
		System.out.println(isBSTbyRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
	
	public static boolean isBSTbyRange(BinaryTree<Integer> root, int minRange, int maxRange) {
		if(root == null) {
			return true;
		}
		if(root.data < minRange || root.data > maxRange ){
			return false;
		}
		boolean leftAns = isBSTbyRange(root.left, minRange, root.data-1);
		boolean rightAns = isBSTbyRange(root.right, root.data, maxRange);
		return leftAns && rightAns;
	}
	
	
	public static BSTReturn isBSTbetter(BinaryTree<Integer> root) {
		if (root==null) {
			BSTReturn ans = new BSTReturn(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
			return ans;
		}
		BSTReturn leftAns = isBSTbetter(root.left);
		BSTReturn rightAns = isBSTbetter(root.right);
		
		int min = Math.min(root.data, Math.min(leftAns.min, rightAns.min));
		int max = Math.max(root.data, Math.max(leftAns.max, rightAns.max));
		boolean isBST = true;
		
		if(leftAns.max >= root.data) {
			isBST= false;
		}
		if(rightAns.min < root.data) {
			isBST=false;
		}
		if(!leftAns.isBST) {
			isBST= false;
		}
		if(!rightAns.isBST) {
			isBST= false;
		}
		BSTReturn ans = new BSTReturn(min, max, isBST);
		return ans;
	}
	
//	time complexity is O(nh) and in worst case it is O(n^2)
	private static boolean isTreeBST(BinaryTree<Integer> root) {
		if(root == null) {
			return true;
		}
		int leftMax = maximum(root.left);
		if(leftMax>=root.data) {
			return false;
		}
		int rightMin = minimum(root.right);
		if(rightMin<root.data) {
			return false;
		}
		return isTreeBST(root.left) && isTreeBST(root.right);
	}
	private static int minimum(BinaryTree<Integer> root) {
		if(root==null) {
			return Integer.MAX_VALUE;
		}
		int minLeft = minimum(root.left);
		int minRight = minimum(root.right);
		return Math.min(root.data, Math.min(minLeft, minRight));
	}
	private static int maximum(BinaryTree<Integer> root) {
		if(root==null) {
			return Integer.MIN_VALUE;
		}
		int maxLeft = maximum(root.left);
		int maxRight = maximum(root.right);
		return Math.max(root.data, Math.max(maxLeft, maxRight));
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
}
