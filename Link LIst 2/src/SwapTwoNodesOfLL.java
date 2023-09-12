/*
 * Swap two Nodes of LL

	You have been given a singly linked list of integers along with two integers, 
	'i,' and 'j.' Swap the nodes that are present at the 'i-th' and 'j-th' positions.
	Note :
	Remember, the nodes themselves must be swapped and not the datas.
	
	No need to print the list, it has already been taken care. Only return the new head to the list.
	Input format :
	The first line contains an Integer 't' which denotes the number of test cases or 
	queries to be run. Then the test cases follow.
	
	The first line of each test case or query contains the elements of the singly 
	linked list separated by a single space.
	
	The second line of input contains two integer values 'i,' and 'j,' respectively. 
	A single space will separate them.
	 Remember/consider :
	While specifying the list elements for input, -1 indicates the end of the singly 
	linked list and hence, would never be a list element
	Output format :
	For each test case/query, print the elements of the updated singly linked list.
	
	Output for every test case will be printed in a seperate line.
	Constraints :
	1 <= t <= 10^2
	0 <= M <= 10^5
	Where M is the size of the singly linked list.
	0 <= i < M
	0 <= j < M
	
	Time Limit: 1sec
	Sample Input 1 :
	1
	3 4 5 2 6 1 9 -1
	3 4
	Sample Output 1 :
	3 4 5 6 2 1 9 
	 Sample Input 2 :
	2
	10 20 30 40 -1
	1 2
	70 80 90 25 65 85 90 -1
	0 6
	 Sample Output 2 :
	10 30 20 40 
	90 80 90 25 65 85 70 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwapTwoNodesOfLL {
    
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
            String[] i_j = br.readLine().trim().split("\\s");

            int i = Integer.parseInt(i_j[0]);
            int j = Integer.parseInt(i_j[1]);

            LinkedListNode<Integer> newHead = swapNodes(head, i, j);
            print(newHead);
            
            t -= 1;
        }

    }

	private static LinkedListNode<Integer> swapNodes(LinkedListNode<Integer> head, int i, int j) {
		
		if(head==null || i==j) {
			return head;
		}
		int pos=0;
		LinkedListNode<Integer> curr=head,prev=null, first=null, preFirst=null, sec=null, preSec=null;
		while(curr!=null) {
			if(pos==i) {
				first= curr;
				preFirst=prev;
			}else if(pos==j) {
				sec=curr;
				preSec=prev;
			}
			prev=curr;
			curr= curr.next;
			pos++;
		}
		
		if(preFirst!=null) {
			preFirst.next=sec;
		}else {
			head = sec;
		}
		if(preSec!=null) {
			preSec.next=first;
		}else {
			head= first;
		}
		LinkedListNode<Integer> temp= sec.next;
		sec.next=first.next;
		first.next=temp;
		return head;
	}
}