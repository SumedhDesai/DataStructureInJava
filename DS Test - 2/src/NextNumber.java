/*
 * Next Number

	Given a large number represented in the form of a linked list. Write code to increment 
	the number by 1 in-place(i.e. without using extra space).
	Note: You don't need to print the elements, just update the elements and return the 
	head of updated LL.
	Input Constraints:
	1 <= Length of Linked List <=10^6.
	Input format :
	Line 1 : Linked list elements (separated by space and terminated by -1)
	Output Format :
	Line 1: Updated linked list elements 
	Sample Input 1 :
	3 9 2 5 -1
	Sample Output 1 :
	3 9 2 6
	Sample Input 2 :
	9 9 9 -1
	Sample Output 1 :
	1 0 0 0 
 */
import java.util.Scanner;

class LinkedListNode<T> {
	T data;
	LinkedListNode<T> next;
	
	public LinkedListNode(T data) {
		this.data = data;
	}
}
public class NextNumber {
	static Scanner s = new Scanner(System.in);

	public static LinkedListNode<Integer> takeInput() {
		LinkedListNode<Integer> head = null, tail = null;
		int data = s.nextInt();
		while(data != -1) {
			LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
			if(head == null) {
				head = newNode;
				tail = newNode;
			}
			else {
				tail.next = newNode;
				tail = newNode;
			}
			data = s.nextInt();
		}
		return head;
	}
	
	public static void print(LinkedListNode<Integer> head){
		while(head != null){
			System.out.print(head.data +" ");
			head = head.next;
		}
		System.out.println();
	}
		
	public static void main(String[] args) {
		
		LinkedListNode<Integer> head = takeInput();
		head = nextLargeNumber(head);
		print(head);
		
	}

	private static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head) {
		if(head==null) {
			return head;
		}
		LinkedListNode<Integer> revHead=reverseLL(head);
		LinkedListNode<Integer> temp = revHead;
		LinkedListNode<Integer> prev = null;
		int carry=1;
		while(temp!=null) {
			int num =(temp.data+carry)%10;
			carry= (temp.data+carry)/10;
			temp.data=num;
			prev=temp;
			temp=temp.next;
		}
		if(carry!=0) {
			LinkedListNode<Integer> newNode = new LinkedListNode<>(carry);
			prev.next=newNode;
		}
		LinkedListNode<Integer> newHead= reverseLL(revHead);
		return newHead;
	}

	private static LinkedListNode<Integer> reverseLL(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> pre = null, fwd=null, curr=head;
		
		while(curr!=null) {
			fwd=curr.next;
			curr.next=pre;
			pre=curr;
			curr=fwd;
		}
		return pre;
	}

}
