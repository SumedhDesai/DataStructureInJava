public class BinarySearchTree {

	private BinaryTreeNode<Integer> root;

	public void insert(int input) {
		root = insertHelper(root, input);
	}

	private BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> node, int input) {
		if(node == null) {
			BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(input);
			return newNode;
		}
		if(input <= node.data) {
			node.left = insertHelper(node.left, input);
		}else {
			node.right = insertHelper(node.right, input);
		}
		return node;
	}

	public void remove(int input) {
		root=removeHelper(root,input);
	}

	private BinaryTreeNode<Integer>  removeHelper(BinaryTreeNode<Integer> node, int input) {
		if(node==null) {
			return null;
		}
		if(node.data==input) {
			if(node.left==null && node.right ==null) {
				return null;
			}else if(node.left==null ) {
				return node.right;
			}else if(node.right==null ) {
				return node.left;
			}else {
				int rightMin = findMinimum(node.right);
				/*Another way to calculate rightMin
				 * 
				 * BinaryTreeNode<Integer> minNode = node.right
				 * while(minNode.left != null){
				 * minNode = minNode.left;
				 * }
				 * int rightMin = minNode.data;
				 */
				/* 
				 * we have to replace root with either maximum of left side
				 * or minimum of right side
				 * it is asked in question to use minimum in right side 
				 */
				node.data = rightMin;
				node.right = removeHelper(node.right, rightMin);
			}
		}else if(input < node.data) {
			node.left = removeHelper(node.left, input);
		}else {
			node.right = removeHelper(node.right, input);
		}
		return node;
	}


	public int findMinimum(BinaryTreeNode<Integer> node) {
		if(node == null) {
			return Integer.MAX_VALUE;
		}
		int leftMin = findMinimum(node.left);
		int rightMin = findMinimum(node.right);

		return Math.min(node.data, Math.min(leftMin, rightMin));
	}

	public boolean search(int input) {
		return searchHelper(root, input);
	}

	private boolean searchHelper(BinaryTreeNode<Integer> root, int x) {
		if(root == null) {
			return false;
		}
		if(root.data == x) {
			return true;
		}
		if(x <= root.data) {
			return searchHelper(root.left, x);
		}else {
			return searchHelper(root.right, x);
		}
	}

	public void printTree() {
		printTreeHelper(root);
	}

	private void printTreeHelper(BinaryTreeNode<Integer> node) {
		if(node == null) {
			return;
		}
		System.out.print(node.data+":");
		if(node.left != null) {
			System.out.print("L:"+node.left.data+",");
		}
		if(node.right != null) {
			System.out.print("R:"+node.right.data);
		}
		System.out.println();
		printTreeHelper(node.left);
		printTreeHelper(node.right);

	}

}
