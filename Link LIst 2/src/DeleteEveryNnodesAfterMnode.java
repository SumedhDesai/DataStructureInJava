/*
 * Delete every N nodes

	You have been given a singly linked list of integers along with two integers, 
	'M,' and 'N.' Traverse the linked list such that you retain the 'M' nodes, then 
	delete the next 'N' nodes. Continue the same until the end of the linked list.
	To put it in other words, in the given linked list, you need to delete N nodes 
	after every M nodes.
	Note :
	No need to print the list, it has already been taken care. Only return the new 
	head to the list.
	Input format :
	The first line contains an Integer 't' which denotes the number of test cases or 
	queries to be run. Then the test cases follow.
	
	The first line of each test case or query contains the elements of the singly linked 
	list separated by a single space.
	
	The second line of input contains two integer values 'M,' and 'N,' respectively. 
	A single space will separate them.
	 Remember/Consider :
	While specifying the list elements for input, -1 indicates the end of the singly 
	linked list and hence, would never be a list element
	Output format :
	For each test case/query, print the elements of the updated singly linked list.
	
	Output for every test case will be printed in a seperate line.
	Constraints :
	1 <= t <= 10^2
	0 <= P <= 10^5
	Where P is the size of the singly linked list.
	0 <= M <= 10^5
	0 <= N <= 10^5 
	
	Time Limit: 1sec
	Sample Input 1 :
	1
	1 2 3 4 5 6 7 8 -1
	2 2
	Sample Output 1 :
	1 2 5 6
	Sample Input 2 :
	2
	10 20 30 40 50 60 -1
	0 1
	1 2 3 4 5 6 7 8 -1
	2 3
	Sample Output 2 :
	1 2 6 7
	Explanation of Sample Input 2 :
	For the first query, we delete one node after every zero elements hence removing all 
	the items of the list. Therefore, nothing got printed.
	
	For the second query, we delete three nodes after every two nodes, resulting in the 
	final list, 1 -> 2 -> 6 -> 7.	
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeleteEveryNnodesAfterMnode {

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
			String[] m_n = br.readLine().trim().split("\\s");

			int m = Integer.parseInt(m_n[0]);
			int n = Integer.parseInt(m_n[1]);
			LinkedListNode<Integer> newHead = skipMdeleteN(head, m, n);
			print(newHead);

			t -= 1;
		}

	}

	private static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int m, int n) {
		if(head==null) {
			return head;
		}
		if(m==0) {
			return null;
		}
		if(n==0) {
			return head;
		}
		LinkedListNode<Integer> curr = head;
		LinkedListNode<Integer> temp = null;

		while(curr!=null) {
			int skip =0;
			int take =0;
			while(curr!=null && take<m) {
				if(temp==null) {
					temp=curr;
				}else {
					temp.next=curr;
					temp=curr;
				}
				curr=curr.next;
				take++;
			}
			while(curr!=null && skip<n) {
				curr=curr.next;
				skip++;
			}
		}
		if(temp.next!=null) {
			temp.next=null;
		}
		return head;
	}
}