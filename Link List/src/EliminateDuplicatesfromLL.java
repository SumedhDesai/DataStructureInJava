/*
 * Eliminate duplicates from LL

	You have been given a singly linked list of integers where the elements are 
	sorted in ascending order. Write a function that removes the consecutive duplicate 
	values such that the given list only contains unique elements and returns the head 
	to the updated list.
	 Input format :
	The first line contains an Integer 't' which denotes the number of test cases or 
	queries to be run. Then the test cases follow.
	
	The first and the only line of each test case or query contains the elements
	(in ascending order) of the singly linked list separated by a single space.
	 Remember/Consider :
	While specifying the list elements for input, -1 indicates the end of the singly linked 
	list and hence, would never be a list element.
	 Output format :
	For each test case/query, print the resulting singly linked list of integers in a row, 
	separated by a single space.
	
	Output for every test case will be printed in a seperate line.
	Constraints :
	1 <= t <= 10^2
	0 <= M <= 10^5
	Time Limit: 1sec
	
	Where 'M' is the size of the singly linked list.
	Sample Input 1 :
	1
	1 2 3 3 3 3 4 4 4 5 5 7 -1
	Sample Output 1 :
	1 2 3 4 5 7 
	Sample Input 2 :
	2
	10 20 30 40 50 -1
	10 10 10 10 -1
	Sample Output 2 :
	10 20 30 40 50
	10
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EliminateDuplicatesfromLL {
    
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

            head = removeDuplicates(head);
            print(head);

            t -= 1;
        }
        
    }

	private static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
		if(head==null) {
			return head;
		}
		LinkedListNode<Integer> curr =head;
		
		while(curr.next!=null) {	
			if(curr.data.equals(curr.next.data)) {
				curr.next=curr.next.next;
			}else {
				curr=curr.next;
			}
		}
		return head;
	}
}