/*
 * Insert Node In LL

	You have been given a singly linked list of integers, an integer value called 
	'data' and a position with the name 'pos.'
	 Write a function to add a node to the list with the 'data' at the specified 
	 position, 'pos.'
	Note :
	Assume that the Indexing for the singly linked list always starts from 0.
	
	If the position is greater than the length of the singly linked list, you should 
	return the same linked list without any change.
	 Illustration :
	
	Input format :
	The first line contains an Integer 't' which denotes the number of test cases or 
	queries to be run. Then the test cases follow.
	
	The first line of each test case or query contains the elements of the linked list 
	separated by a single space. 
	
	The second line contains the two integer values of 'data' and 'pos' separated by a 
	single space, respectively
	Reminder/Consider :
	While specifying the list elements for input, -1 indicates the end of the singly 
	linked list and hence, would never be a list element.
	Output format :
	For each test case, print the resulting singly linked list of integers in a row, 
	separated by a single space.
	
	Output for every test case will be printed in a seperate line.
	 Constraints :
	1 <= t <= 10^2
	0 <= N <= 10^5
	pos >= 0
	Time Limit: 1sec
	Sample Input 1 :
	1
	3 4 5 2 6 1 9 -1
	3 100
	Sample Output 1 :
	3 4 5 100 2 6 1 9
	Sample Input 2 :
	2
	3 4 5 2 6 1 9 -1
	0 20
	10 98 7 66 8 -1
	5 99
	Sample Output 2 :
	20 3 4 5 2 6 1 9
	10 98 7 66 8 99 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InsertNodeInLL {
    
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
            String[] pos_data = br.readLine().trim().split("\\s");

            int pos = Integer.parseInt(pos_data[0]);
            int data = Integer.parseInt(pos_data[1]);

            head = insert(head, pos, data);
            print(head);

            t -= 1;
        }
    }

	private static LinkedListNode<Integer> insert(LinkedListNode<Integer> head, int i, int data) {
		
		LinkedListNode<Integer> temp = head;
		LinkedListNode<Integer> curr= new LinkedListNode<Integer>(data);
		
		if(i==0) {
			curr.next=head;
			head=curr;
		}else {
			int count=0;
			while(temp!= null && count<i-1) {
				temp=temp.next;
				count++;
			}
			if(temp==null) {
				return head;
			}
			curr.next=temp.next;
			temp.next=curr;
		}
		return head;
	}
}