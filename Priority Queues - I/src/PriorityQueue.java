import java.util.*;

public class PriorityQueue<T> {

	public ArrayList<Element<T>> heap ;

	public PriorityQueue() {
		heap = new ArrayList<>();
	}

	public T getMin() throws PriorityQueueException {
		if(heap.size()==0) {
			throw new PriorityQueueException();
		}
		return heap.get(0).value;

	}

	public int size() {
		return heap.size();
	}

	public boolean isEmpty() {
		return heap.size()==0;
	}

	public void insert(T value, int priority) {
		Element<T> e = new Element<T>(value, priority);
		heap.add(e);

		int childIndex = heap.size()-1;
		int parentIndex = (childIndex-1)/2;

		while(childIndex>0 && (heap.get(childIndex).priority < heap.get(parentIndex).priority)) {

			Element<T> temp = heap.get(childIndex);
			heap.set(childIndex, heap.get(parentIndex));
			heap.set(parentIndex, temp);
			childIndex = parentIndex;
			parentIndex = (childIndex-1)/2;
		}


	}

	public T removeMin() throws PriorityQueueException {
		if(heap.size()==0) {
			throw new PriorityQueueException();
		}

		Element<T> removed= heap.get(0);
		T ans = removed.value;
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);

		int parentIndex = 0;
		int leftChildIndex = (2*parentIndex)+1;
		int rightChildIndex = (2* parentIndex)+2;

		while(leftChildIndex < heap.size()) {
			int minIndex = parentIndex;
			if(heap.get(leftChildIndex).priority < heap.get(minIndex).priority) {
				minIndex = leftChildIndex;
			}
			if((rightChildIndex < heap.size()) && (heap.get(rightChildIndex).priority < heap.get(minIndex).priority)) {
				minIndex = rightChildIndex;
			}
			if(parentIndex == minIndex) {
				break;
			}
			Element<T> temp = heap.get(minIndex);
			heap.set(minIndex, heap.get(parentIndex));
			heap.set(parentIndex, temp);
			parentIndex = minIndex;
			leftChildIndex = (2*parentIndex)+1;
			rightChildIndex = (2* parentIndex)+2;		

		}

		return ans;
	}
}
