/*
 * Code : Remove Min

	Implement the function RemoveMin for the min priority queue class.
	For a minimum priority queue, write the function for removing the 
	minimum element present. Remove and return the minimum element.
	Note : main function is given for your reference which we are using 
	internally to test the code.

 */
import java.util.ArrayList;

public class PQMin {

	private ArrayList<Integer> heap;

	public PQMin() {
		heap = new ArrayList<Integer>();
	}

	boolean isEmpty() {
		return heap.size() == 0;
	}

	int size() {
		return heap.size();
	}

	int getMin() throws PriorityQueueException {
		if (isEmpty()) {
			// Throw an exception
			throw new PriorityQueueException();
		}
		return heap.get(0);
	}

	void insert(int element) {
		heap.add(element);
		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex - 1) / 2;

		while (childIndex > 0) {
			if (heap.get(childIndex) < heap.get(parentIndex)) {
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
			} else {
				return;
			}
		}
	}
	
	int removeMin() throws PriorityQueueException {
		if(heap.size()==0) {
			throw new PriorityQueueException();
		}

		int val = heap.get(0);
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);

		int parentIndex = 0;
		int leftChildIndex = (2*parentIndex)+1;
		int rightChildIndex = (2* parentIndex)+2;

		while(leftChildIndex < heap.size()) {
			int minIndex = parentIndex;
			if(heap.get(leftChildIndex) < heap.get(minIndex)) {
				minIndex = leftChildIndex;
			}
			if(rightChildIndex < heap.size() && (heap.get(rightChildIndex) < heap.get(minIndex))) {
				minIndex = rightChildIndex;
			}
			if(parentIndex == minIndex) {
				break;
			}
			int temp = heap.get(minIndex);
			heap.set(minIndex, heap.get(parentIndex));
			heap.set(parentIndex, temp);
			parentIndex = minIndex;
			leftChildIndex = (2*parentIndex)+1;
			rightChildIndex = (2* parentIndex)+2;		

		}

		return val;
	}
}

