/*
 * Level wise linkedlist

	Given a binary tree, write code to create a separate linked list for 
	each level. You need to return the array which contains head of each 
	level linked list.
	Input format :
	The first line of input contains data of the nodes of the tree in level 
	order form. The data of the nodes of the tree is separated by space. If 
	any node does not have left or right child, take -1 in its place. Since -1 
	is used as an indication whether the left or right nodes exist, therefore, 
	it will not be a part of the data of any node.
	Output format :
	Each level linked list is printed in new line (elements are separated by space).
	Constraints:
	Time Limit: 1 second
	Sample Input 1:
	5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
	Sample Output 1:
	5 
	6 10 
	2 3 
	9
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class LevelWiseLinkedList {

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

	private static void print(LinkedListNode<Integer> temp)
	{
		while(temp != null){
			System.out.print(temp.data + " ") ;
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		BinaryTreeNode<Integer> root = takeInput();
		ArrayList<LinkedListNode<Integer>> output = constructLinkedListForEachLevel(root);
		if(output!=null)
		{
			for(LinkedListNode<Integer> head : output){
				print(head);

			}
		}
	}

	private static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root) {
		if (root==null) {
			return null;
		}
		Queue<BinaryTreeNode<Integer> > pending = new LinkedList<BinaryTreeNode<Integer> >();
		ArrayList<LinkedListNode<Integer>> arr = new ArrayList<LinkedListNode<Integer>>();

		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> tail = null;

		pending.add(root);
		pending.add(null);

		while(!pending.isEmpty()) {
			BinaryTreeNode<Integer> node = pending.remove();
			if(node==null) {
				arr.add(head);
				head=null;
				tail=null;
				if(!pending.isEmpty()) {
					pending.add(null);
				}
			}else {
				LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(node.data);
				if(head == null) {
					head = newNode;
					tail = newNode;
				}else {
					tail.next=newNode;
					tail = tail.next;
				}
				if(node.left!=null) {
					pending.add(node.left);
				}
				if(node.right!=null) {
					pending.add(node.right);
				}

			}
		}
		return arr;
	}

}