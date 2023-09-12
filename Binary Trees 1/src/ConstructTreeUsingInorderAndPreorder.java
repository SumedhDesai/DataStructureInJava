/*
 * Construct Tree using Inorder and Preorder
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class ConstructTreeUsingInorderAndPreorder {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	private static Pair3 takeInput() throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine().trim());

		int pre[] = new int[n];
		int in[] = new int[n];

		String[] preOrder = br.readLine().trim().split(" ");
		String[] inOrder = br.readLine().trim().split(" ");


		for (int i = 0; i < n; i++) {
			pre[i] = Integer.parseInt(preOrder[i].trim());
			in[i] = Integer.parseInt(inOrder[i].trim());
		}

		return new Pair3(pre, in);

	}

	public static void printLevelWise(BinaryTreeNode<Integer> root) {

		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
		pendingNodes.add(root);
		pendingNodes.add(null);

		while(!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> frontNode = pendingNodes.poll();


			if (frontNode == null) {
				System.out.println();

				if (!pendingNodes.isEmpty()) {
					pendingNodes.add(null);
				}

			} else {
				System.out.print(frontNode.data + " ");

				if (frontNode.left != null) {
					pendingNodes.add(frontNode.left);
				} 

				if (frontNode.right != null) {
					pendingNodes.add(frontNode.right);
				} 
			}

		}

	}
	public static void main(String[] args) throws NumberFormatException, IOException {

		Pair3 input = takeInput();

		int[] preOrder = input.preOrder;
		int[] inOrder = input.inOrder;

		BinaryTreeNode<Integer> root = buildTree(preOrder, inOrder);

		printLevelWise(root);

	}

	private static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
		if(preOrder.length==0 || inOrder.length==0) {
			return null;
		}
		int rootData = preOrder[0];
		int rootIndex = -1;
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		for(int i=0; i< inOrder.length; i++) {
			if(inOrder[i]==rootData) {
				rootIndex=i;
				break;
			}
		}
		int[] smallInOrderL = creatArray(inOrder, 0, rootIndex-1);
		int[] smallInOrderR = creatArray(inOrder, rootIndex+1, inOrder.length-1);
		
		int preIndex = smallInOrderL.length;
		
		int[] smallPreOrderL = creatArray(preOrder, 1, preIndex);
		int[] smallPreOrderR = creatArray(preOrder, preIndex+1, preOrder.length-1);
		
		BinaryTreeNode<Integer> leftRoot = buildTree(smallPreOrderL, smallInOrderL);
		BinaryTreeNode<Integer> rightRoot = buildTree(smallPreOrderR, smallInOrderR);
		
		root.left = leftRoot;
		root.right=rightRoot;

		return root;
	}

	private static int[] creatArray(int[] input, int si, int ei) {
		int[] arr = new int[ei-si+1];
		for(int i=si, j=0; i<=ei; i++,j++) {
			arr[j]=input[i];
		}
		return arr;
	}
}