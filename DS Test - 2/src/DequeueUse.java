/*
 * Dequeue

	You need to implement a class for Dequeue i.e. for double ended queue. In this 
	queue, elements can be inserted and deleted from both the ends.
	You don't need to double the capacity.
	You need to implement the following functions -
	1. constructor
	You need to create the appropriate constructor. Size for the queue passed is 10.
	2. insertFront -
	This function takes an element as input and insert the element at the front of queue. 
	Insert the element only if queue is not full. And if queue is full, print -1 and return.
	3. insertRear -
	This function takes an element as input and insert the element at the end of queue. 
	Insert the element only if queue is not full. And if queue is full, print -1 and return.
	4. deleteFront -
	This function removes an element from the front of queue. Print -1 if queue is empty.
	5. deleteRear -
	This function removes an element from the end of queue. Print -1 if queue is empty.
	6. getFront -
	Returns the element which is at front of the queue. Return -1 if queue is empty.
	7. getRear -
	Returns the element which is at end of the queue. Return -1 if queue is empty.
	
	Sample Input 1:
	5 1 49 1 64 2 99 5 6 -1
	Sample Output 1:
	-1
	64
	99
	Explanation:
	The first choice code corresponds to getFront. Since the queue is empty, hence the output is -1. 
	The following input adds 49 at the top and the resultant queue becomes: 49.
	The following input adds 64 at the top and the resultant queue becomes: 64 -> 49
	The following input add 99 at the end and the resultant queue becomes: 64 -> 49 -> 99
	The following input corresponds to getFront. Hence the output is 64.
	The following input corresponds to getRear. Hence the output is 99.
 */
import java.util.Scanner;

public class DequeueUse {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        Dequeue dq = new Dequeue(10);
        
	while(true){
        int choice = s.nextInt(),input;
        switch (choice) {
            case 1:
                input = s.nextInt();
                dq.insertFront(input);
                break;
            case 2:
                input = s.nextInt();
                dq.insertRear(input);
                break;
            case 3:
                dq.deleteFront();
                break;
            case 4:
                dq.deleteRear();
                break;
            case 5:
                System.out.println(dq.getFront());
                break;
            case 6:
                System.out.println(dq.getRear());
                break;
            default:
                return ;
      }
        s.close();
    }
}
}