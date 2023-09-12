/*
 * Bubble Sort (Iterative) LinkedList

	Given a singly linked list of integers, sort it using 'Bubble Sort.'
	Note :
	No need to print the list, it has already been taken care. 
	Only return the new head to the list.
	Input format :
	The first and the only line of each test case or query contains the 
	elements of the singly linked list separated by a single space.
	Remember/Consider :
	While specifying the list elements for input, -1 indicates the end of the 
	singly linked list and hence, would never be a list element
	Output format :
	For each test case/query, print the elements of the sorted singly linked list.
	
	Output for every test case will be printed in a seperate line.
	Constraints :
	0 <= M <= 10^3
	Where M is the size of the singly linked list.
	
	Time Limit: 1sec
	Sample Input 1 :
	10 9 8 7 6 5 4 3 -1
	Sample Output 1 :
	 3 4 5 6 7 8 9 10 
	 Sample Output 2 :
	10 -5 9 90 5 67 1 89 -1
	Sample Output 2 :
	-5 1 5 9 10 67 89 90 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BubbleSortIterativeLinkedList {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static LinkedListNode<Integer> takeInput() throws IOException {
		LinkedListNode<Integer> head = null, tail = null;

		String[] datas = br.readLine().trim().split("\\s");

		int i = 0;
		while(i < datas.length && !datas[i].equals("-1")) {
			int data = Integer.parseInt(datas[i]);
			LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
			if(head == null) {
				head = newNode;
				tail = newNode;
			}
			else {
				tail.next = newNode;
				tail = newNode;
			}
			i += 1;
		}

		return head;
	}

	public static void print(LinkedListNode<Integer> head){
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}

		System.out.println();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		LinkedListNode<Integer> head = takeInput(); 

		head = bubbleSort2(head);
		print(head);
	}

	private static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head) {
		
		if(head==null || head.next==null) {
			return head;
		}
		LinkedListNode<Integer> curr = head ;
		LinkedListNode<Integer> pre;
		LinkedListNode<Integer> fwd;
		int count = count(head);
		
		for(int i=0; i<count; i++) {
			curr=head;
			pre=null;
			for(int j=0; j<count-i-1; j++) {
				if(curr.data<=curr.next.data) {
					pre=curr;
					curr=curr.next;
				}else {
					if(pre == null) {
						fwd=curr.next;
						head=head.next;
						curr.next=fwd.next;
						fwd.next=curr;
						pre=fwd;

					}else {
						fwd=curr.next;
						pre.next=fwd;
						curr.next=fwd.next;
						fwd.next=curr;
						pre=fwd;
					}
				}
			}
		}
		return head;
	}

	private static int count(LinkedListNode<Integer> head) {
		int count=0; 
		LinkedListNode<Integer> temp = head;
		while(temp!=null) {
			count++;
			temp= temp.next;
		}
		return count;
	}
	
private static LinkedListNode<Integer> bubbleSort2(LinkedListNode<Integer> head) {
		
		if(head==null || head.next==null) {
			return head;
		}
		LinkedListNode<Integer> curr = head ;
		LinkedListNode<Integer> pre;
		LinkedListNode<Integer> fwd;
		int count = count(head);
		
		for(int i=0; i<count; i++) {
			curr=head;
			pre=null;
			for(int j=0; j<count-i-1; j++) {
				if(curr.data<=curr.next.data) {
					pre=curr;
					curr=curr.next;
				}else {
					if(pre == null) {
						fwd = curr.next;
						curr.next= pre;
						pre = curr;
						curr = fwd;
						head = fwd;
					}else {
						fwd = curr.next;
						curr.next= pre;
						pre = curr;
						curr = curr.next;
					}
				}
			}
		}
		return head;
	}
}