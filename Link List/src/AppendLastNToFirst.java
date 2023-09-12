/*
 * AppendLastNToFirst

	You have been given a singly linked list of integers along with an integer 'N'. 
	Write a function to append the last 'N' nodes towards the front of the singly 
	linked list and returns the new head to the list.
	Input format :
	The first line contains an Integer 't' which denotes the number of test cases or 
	queries to be run. Then the test cases follow.
	
	The first line of each test case or query contains the elements of the singly 
	linked list separated by a single space. 
	
	The second line contains the integer value 'N'. It denotes the number of nodes 
	to be moved from last to the front of the singly linked list.
	Remember/Consider :
	While specifying the list elements for input, -1 indicates the end of the singly 
	linked list and hence, would never be a list element.
	Output format :
	For each test case/query, print the resulting singly linked list of integers in 
	a row, separated by a single space.
	
	Output for every test case will be printed in a seperate line.
	Constraints :
	1 <= t <= 10^2
	0 <= M <= 10^5
	0 <= N < M
	Time Limit: 1sec
	
	Where 'M' is the size of the singly linked list.
	Sample Input 1 :
	2
	1 2 3 4 5 -1
	3
	10 20 30 40 50 60 -1
	5
	Sample Output 1 :
	3 4 5 1 2
	20 30 40 50 60 10
	Sample Input 2 :
	1
	10 6 77 90 61 67 100 -1
	4
	Sample Output 2 :
	90 61 67 100 10 6 77 
	 Explanation to Sample Input 2 :
	We have been required to move the last 4 nodes to the front of the list. Here, 
	"90->61->67->100" is the list which represents the last 4 nodes. When we move this 
	list to the front then the remaining part of the initial list which is, "10->6->77" is 
	attached after 100. Hence, the new list formed with an updated head pointing to 90.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppendLastNToFirst {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static LinkedListNode<Integer> takeInput() throws IOException {
		LinkedListNode<Integer> head = null, tail = null;

		String[] datas = br.readLine().trim().split("\\s");

		int i = 0;
		while (i < datas.length && !datas[i].equals("-1")) {
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
		int t = Integer.parseInt(br.readLine().trim());

		while (t > 0) {

			LinkedListNode<Integer> head = takeInput(); 

			int n = Integer.parseInt(br.readLine().trim());
//			head = appendLastNToFirst(head, n);
//			print(head);
			head = appendLastNToFirstBetter(head, n);

			print(head);

			t -= 1;
		}

	}

	private static LinkedListNode<Integer> appendLastNToFirstBetter(LinkedListNode<Integer> head, int n) {
		if(head==null || n==0) {
			return head;
		}
		LinkedListNode<Integer> pointer1 = head;
		LinkedListNode<Integer> pointer2 = head;
		LinkedListNode<Integer> intialHead = head;
		
		for(int i=1; i<=n; i++) {
			pointer1=pointer1.next;
		}
		System.out.println(pointer1.data);
		while(pointer1.next!=null) {
			pointer2=pointer2.next;
			pointer1=pointer1.next;
		}
		pointer1.next=intialHead;
		head=pointer2.next;
		pointer2.next=null;
		
		return head;
	}

	private static LinkedListNode<Integer> appendLastNToFirst(LinkedListNode<Integer> head, int n) {

		if(head==null || n==0){
			return head;
		}
		int count=0;
		LinkedListNode<Integer> temp = head, prev = null;
		while(temp.next!=null) {
			count++;
			temp=temp.next;
		}
		count++;
		int headIndex=count-n;

		LinkedListNode<Integer> newHead = head;
		int index=0;
		while(index < headIndex && newHead!=null) {
			prev=newHead;
			newHead=newHead.next;
			index++;
		}

		temp.next=head;
		head=newHead;
		prev.next=null;
		return head;
	}
}