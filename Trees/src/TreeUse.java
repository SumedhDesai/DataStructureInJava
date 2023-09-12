/*
 * Count tree node and print tree recursively
 */
public class TreeUse {

	public static void main(String[] args) {

		TreeNode<Integer> root = new TreeNode<>(0);
		TreeNode<Integer>node1 = new TreeNode<>(1);
		TreeNode<Integer> node2 = new TreeNode<>(2);
		TreeNode<Integer> node3 = new TreeNode<>(3);
		TreeNode<Integer> node4 = new TreeNode<>(4);
		TreeNode<Integer> node5 = new TreeNode<>(5);

		root.children.add(node1);
		root.children.add(node2);
		root.children.add(node3);

		node2.children.add(node4);
		node2.children.add(node5);
		
		printTree(root);
		System.out.println();
		printTreeDetailed(root);
		int count = countNode(root);
		System.out.println(count);
	}

	private static int countNode(TreeNode<Integer> root) {
		if(root==null) {
			return 0; // special case
		}
		int count =1;
		for(int i=0; i<root.children.size(); i++) {
			int childCount = countNode(root.children.get(i));
			count = count + childCount;
		}
		return count;
	}

	private static void printTreeDetailed(TreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data+ ": ");
		for(int i=0; i< root.children.size(); i++) {
			System.out.print(root.children.get(i).data+" ");
		}
		System.out.println();
		for(int i=0; i< root.children.size(); i++) {
			printTreeDetailed(root.children.get(i));
		}
	}

	public static void printTree(TreeNode<Integer> root) {
		if(root == null) {
			return; // this is sprcial case not base case of recursion
		}
		System.out.print(root.data+ " ");
		
		for(int i=0; i<root.children.size(); i++) {
			// base cse is taken care at in loop candition
			TreeNode<Integer> child = root.children.get(i);
			printTree(child);
		}
	}
}

