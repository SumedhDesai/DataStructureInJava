/*
 * Implement Min priority queue
 */
public class PriorityQueueTest{

	public static void main(String[] args) throws PriorityQueueException{

		PriorityQueue<Integer> pq= new PriorityQueue<Integer>();

		pq.insert(15, 15);
		pq.insert(13, 13);
		pq.insert(90, 90);
		pq.insert(150, 150);
		pq.insert(120, 120);

		for(int i=0; i< pq.heap.size(); i++) {
			System.out.println(pq.heap.get(i).priority);
		}
		System.out.println();
		while(!pq.isEmpty()){
			System.out.println(pq.getMin());
			pq.removeMin();
		}

	}
}
