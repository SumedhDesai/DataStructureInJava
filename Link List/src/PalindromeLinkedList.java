/*
 * Palindrome LinkedList

	You have been given a head to a singly linked list of integers. Write a function check to 
	whether the list given is a 'Palindrome' or not.
	 Input format :
	The first line contains an Integer 't' which denotes the number of test cases or queries 
	to be run. Then the test cases follow.
	
	First and the only line of each test case or query contains the the elements of the singly 
	linked list separated by a single space.
	 Remember/Consider :
	While specifying the list elements for input, -1 indicates the end of the singly linked 
	list and hence, would never be a list element.
	 Output format :
	For each test case, the only line of output that print 'true' if the list is Palindrome or 
	'false' otherwise.
	 Constraints :
	1 <= t <= 10^2
	0 <= M <= 10^5
	Time Limit: 1sec
	
	Where 'M' is the size of the singly linked list.
	Sample Input 1 :
	1
	9 2 3 3 2 9 -1
	Sample Output 1 :
	true
	Sample Input 2 :
	2
	0 2 3 2 5 -1
	-1
	Sample Output 2 :
	false
	true
	Explanation for the Sample Input 2 :
	For the first query, it is pretty intuitive that the the given list is not a palindrome, 
	hence the output is 'false'.
	
	For the second query, the list is empty. An empty list is always a palindrome , 
	hence the output is 'true'.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PalindromeLinkedList {

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
		int t = Integer.parseInt(br.readLine().trim());

		while (t > 0) {

			LinkedListNode<Integer> head = takeInput(); 

			boolean ans = isPalindrome(head);
			ans = isPalindromeWithoutArrayaList(head);
			System.out.println(ans);
			t -= 1;

		}
	}
	
	private static boolean isPalindrome(LinkedListNode<Integer> head) {
		
		if(head==null || head.next==null) {
			return true;
		}
		
		LinkedListNode<Integer> temp = head;
		ArrayList<Integer> arr = new ArrayList<>();

		while(temp!=null) {
			arr.add(temp.data);
			temp= temp.next;
		}

		int si=0, ei=arr.size()-1;

		while(si<ei) {
			if(arr.get(si)!=arr.get(ei)) {
				return false;
			}
			si++;
			ei--;
		}
		return true;
	}
	
	private static boolean isPalindromeWithoutArrayaList(LinkedListNode<Integer> head) {
		
		if(head==null || head.next==null) {
			return true;
		}
		
//		finding mid point in list
		
		LinkedListNode<Integer> fast = head;
		LinkedListNode<Integer> slow = head;
		
		while(fast.next!=null && fast.next.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		LinkedListNode<Integer> secHead = slow.next;
		slow.next = null;

		LinkedListNode<Integer> secListHead = revList(secHead);
		LinkedListNode<Integer> firstListHead = head;
		
//		coping head of two list for rejoining before traveling throw the list
		LinkedListNode<Integer> firstSubList=firstListHead;
		LinkedListNode<Integer> secSubList = secListHead;
		
//		Compare two list
		while(secListHead!=null) {
			if(secListHead.data != firstListHead.data) {
				return false;
			}
			secListHead=secListHead.next;
			firstListHead=firstListHead.next;
		}
		
//		rejoing two list
		secSubList = revList(secSubList);
		while(firstSubList.next!=null) {
			firstSubList=firstSubList.next;
		}
		firstSubList.next=secSubList;
		return true;
	}

	private static LinkedListNode<Integer> revList(LinkedListNode<Integer> head) {
		
		LinkedListNode<Integer> curr = head;
		LinkedListNode<Integer> prev = null;
		LinkedListNode<Integer> fwd = null;
		
		while(curr != null) {
			fwd = curr.next;
			curr.next = prev;
			prev=curr;
			curr=fwd;
		}
		return prev;
	}
}
