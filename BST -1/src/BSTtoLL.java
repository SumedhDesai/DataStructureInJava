/*
 * BST to LL

	Given a BST, convert it into a sorted linked list. You have to return 
	the head of LL.
	Input format:
	The first and only line of input contains data of the nodes of the tree in 
	level order form. The data of the nodes of the tree is separated by space. 
	If any node does not have left or right child, take -1 in its place. Since -1 
	is used as an indication whether the left or right nodes exist, therefore, 
	it will not be a part of the data of any node.   
	Output Format:
	The first and only line of output prints the elements of sorted linked list.
	Constraints:
	Time Limit: 1 second
	Sample Input 1:
	8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
	Sample Output 1:
	2 5 6 7 8 10
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BSTtoLL {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static BinaryTreeNode<Integer> takeInput() throws IOException {
		st = new StringTokenizer(br.readLine());
		int rootData = Integer.parseInt(st.nextToken());
		if (rootData == -1) {
			return null;
		}
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);

		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}
			int leftChildData = Integer.parseInt(st.nextToken());
			if (leftChildData != -1) {
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.enqueue(leftChild);
			}
			int rightChildData = Integer.parseInt(st.nextToken());
			if (rightChildData != -1) {
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}
		return root;
	}

	public static void main(String[] args) throws IOException {
		BinaryTreeNode<Integer> root = takeInput();
		LinkedListNode<Integer> head = constructLinkedList(root);
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	private static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return null;
		}
		Pair p = LinkedList(root);
		LinkedListNode<Integer> head = p.head;
		return head;
	}

	private static Pair LinkedList(BinaryTreeNode<Integer> root) {
		if(root==null) {
			Pair ans = new Pair(null, null);
			return ans;
		}
		Pair leftAns = LinkedList(root.left);
		Pair rightAns = LinkedList(root.right);
		LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(root.data);
		Pair ans = new Pair();
		
		if(leftAns.head!=null) {
			ans.head=leftAns.head;
		}else {
			ans.head=newNode;
		}
		if(leftAns.tail!=null) {
			leftAns.tail.next = newNode;
		}
//		else {
//			leftAns.tail=newNode;
//		}
		newNode.next=rightAns.head;
		if(rightAns.tail!=null) {
			ans.tail = rightAns.tail;
		}else {
			ans.tail=newNode;
		}

		return ans;
	}

}