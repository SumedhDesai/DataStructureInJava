/*
 * Creat queue using array
 */
public class QueueUse {

	public static void main(String[] args) throws QueFullException, QueEmptyException {
	
		QueuesUsingArray q = new QueuesUsingArray();
		

		
		int[] arr = {10,20,30,40,50};
		
		
		for(int ele : arr) {
			q.enque(ele);
		}
		
		while(!q.isEmpty()) {
			System.out.println(q.deque());
		}
	}

}
