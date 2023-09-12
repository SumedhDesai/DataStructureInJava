/*
 * Even after Odd LinkedList

	For a given singly linked list of integers, arrange the elements such that all the even numbers are placed after the odd numbers. The relative order of the odd and even terms should remain unchanged.
	Note :
	No need to print the list, it has already been taken care. Only return the 
	new head to the list.
	Input format:
	The first line contains an Integer 't' which denotes the number of test cases 
	or queries to be run. Then the test cases follow.
	
	The first line of each test case or query contains the elements of the singly 
	linked list separated by a single space. 
	 Remember/Consider :
	While specifying the list elements for input, -1 indicates the end of the singly 
	linked list and hence, would never be a list element
	Output format:
	For each test case/query, print the elements of the updated singly linked list.
	
	Output for every test case will be printed in a seperate line.
	Constraints :
	1 <= t <= 10^2
	0 <= M <= 10^5
	Where M is the size of the singly linked list.
	
	Time Limit: 1sec
	Sample Input 1 :
	1
	1 4 5 2 -1
	Sample Output 1 :
	1 5 4 2 
	Sample Input 2 :
	2
	1 11 3 6 8 0 9 -1
	10 20 30 40 -1
	Sample Output 2 :
	1 11 3 9 6 8 0
	10 20 30 40
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EvenAfterOddLinkedList {
    
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

            LinkedListNode<Integer> newHead = evenAfterOdd(head);
            print(newHead);

            t -= 1;
        }

    }

	private static LinkedListNode<Integer> evenAfterOdd(LinkedListNode<Integer> head) {
		if(head == null) {
			return head;
		}
		LinkedListNode<Integer> oddHead=null , oddTail=null, evenHead=null , evenTail=null;
		
		while(head!=null) {
			if(head.data%2==0) {
				if(evenHead==null) {
					evenHead=head;
					evenTail=head;
				}else {
					evenTail.next=head;
					evenTail=evenTail.next;
				}
			}else {
				if(oddHead==null) {
					oddHead=head;
					oddTail=head;
				}else {
					oddTail.next=head;
					oddTail=oddTail.next;
				}
			}
			head= head.next;
		}
		if(oddHead==null) {   //means no odd element is present
			return evenHead; 
		}else {
//			if odd elements are present then attach even head to odd tail
			oddTail.next=evenHead; 
		}
		if(evenHead!=null) {
//			if even elements are present  make even tail null
			evenTail.next=null;
		}
		return oddHead;
	}
}