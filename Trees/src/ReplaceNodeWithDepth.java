/*
 * Replace node with depth
	
	In a given Generic Tree, replace each node with its depth value. You need to just
	 update the data of each node, no need to return or print anything.
	Input format :
	
	Line 1 : Elements in level order form separated by space (as per done in class). 
	Order is -
	
	Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element
	
	Sample Input 1 :
	10 3 20 30 40 2 40 50 0 0 0 0 
	Sample Output 1 : (Level wise, each level in new line)
	0 
	1 1 1 
	2 2
 */
import java.util.Scanner;

public class ReplaceNodeWithDepth {
	
	private static void replaceWithDepthValue(TreeNode<Integer> root) {
		if(root ==null) {
			return;
		}
		replaceWithDepthValueHelper(root, 0);
	}

	private static void replaceWithDepthValueHelper(TreeNode<Integer> root, int depth) {
		
		root.data= depth;
		
		for(int i=0; i< root.children.size(); i++) {
			replaceWithDepthValueHelper(root.children.get(i), depth+1);
		}
	}

	static Scanner s = new Scanner(System.in);

	public static TreeNode<Integer> takeInputLevelWise(){
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>();  // Queue of node that are entered themselves but their children aren't added yet
		int rootData = s.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);
		while(!pendingNodes.isEmpty()){
			TreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
				int numChild = s.nextInt();
				for(int i = 0 ; i < numChild; i++){
					int currentChild = s.nextInt();
					TreeNode<Integer> childNode = new TreeNode<Integer>(currentChild);
					pendingNodes.enqueue(childNode);
					currentNode.children.add(childNode);
				}
			} catch (QueueEmptyException e) {
			}
		}
		return root;
	}

  public static void printTreeLevelWise(TreeNode<Integer> root){
  		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>();
  		pendingNodes.enqueue(root);
  		pendingNodes.enqueue(null);
  		while(!pendingNodes.isEmpty()){
  			TreeNode<Integer> currentNode;
  			try {
  				currentNode = pendingNodes.dequeue();
  				if(currentNode==null){
  					System.out.println();
  					if(!pendingNodes.isEmpty()){
  						pendingNodes.enqueue(null);
  						continue;
  					}else{
  						break;
  					}
  				}
  				System.out.print(currentNode.data+" ");
  				int numChild = currentNode.children.size();
  				for(int i = 0 ; i < numChild; i++){
  					pendingNodes.enqueue(currentNode.children.get(i));
  				}

  			} catch (QueueEmptyException e) {
  			}
  		}
  	}
// Test case will have tree printed -
	public static void main(String[] args) {
		TreeNode<Integer> root =  takeInputLevelWise();
		replaceWithDepthValue(root);
		printTreeLevelWise(root);
	}

	
}
