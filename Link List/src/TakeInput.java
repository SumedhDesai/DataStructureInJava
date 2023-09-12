/*
 * Taking input of linked list.
 */
import java.util.Scanner;

public class TakeInput {

	public static void main(String[] args) {
		
		LinkedListNode<Integer> head= takeInputBetter();
		LinkedListNode<Integer> head2= takeInput();
		printLinkedList(head);
		printLinkedList(head2);
		
	}

	private static void printLinkedList(LinkedListNode<Integer> head) {
		
		LinkedListNode<Integer> temp= head;
		while(temp != null) {
			System.out.println(temp.data);
			temp=temp.next;
		}
		
	}

	private static LinkedListNode<Integer> takeInput() {
		Scanner s = new Scanner(System.in);
		int data=s.nextInt();
		LinkedListNode<Integer> head=null;
		
		while(data != -1) {
			LinkedListNode<Integer> currentNode = new LinkedListNode<>(data);
			if(head == null) {
				head=currentNode;
			}else {
				LinkedListNode<Integer> tail=head;
				while(tail.next != null) {
					tail=tail.next;
				}
				tail.next=currentNode;
			}
			data=s.nextInt();
		}
//		s.close();
		return head;
	}
	private static LinkedListNode<Integer> takeInputBetter() {
		Scanner s = new Scanner(System.in);
		int data=s.nextInt();
		LinkedListNode<Integer> head=null;
		LinkedListNode<Integer> tail=null;

		while(data != -1) {
			LinkedListNode<Integer> currentNode = new LinkedListNode<>(data);
			if(head == null) {
				head=currentNode;
				tail=currentNode;
			}else {
				tail.next = currentNode;
				tail = currentNode;
			}
			data=s.nextInt();
		}
//		s.close();
		return head;
	}

}
