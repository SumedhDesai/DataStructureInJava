/*
 * Queue using two stack
 */
public class QueueUsingTwoStack {

	public static void main(String[] args) throws QueFullException, QueEmptyException {

		StackQueue q = new StackQueue();

		int[] arr = {10,20,30,40,50};


		for(int ele : arr) {
			q.enqueue(ele);
		}

		while(!q.isEmpty()) {
			System.out.println(q.dequeue());
		}
	}

}

