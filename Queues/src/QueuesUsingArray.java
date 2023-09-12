
public class QueuesUsingArray {
	
	private int[] data;
	private int size ;
	private int front;
	private int rear;

	public QueuesUsingArray() {
		data = new int[3];
		front =-1;
		rear = -1;
		size = 0;
	}
	public QueuesUsingArray(int capacity) {
		data = new int[capacity];
		front =-1;
		rear = -1;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public void enque(int ele) {
		if(size==data.length) {
			dobleCapacity();
			
		}
		if(size==0) {
			front++;
		}
//		rear++;
//		if(rear==data.length) {  
//			rear=0;					//to create circular queue
//		}
		rear = (rear+1) % data.length;
		data[rear]=ele;
		size++;
	}
	
	private void dobleCapacity() {
		int[] temp = data;
		data = new int [2*temp.length];
		int index=0;
		for(int i= front ; i<temp.length; i++) {
			data[index++]=temp[i];
		}
		for(int i=0; i<front-1; i++) {
			data[index++]=temp[i];
		}
		front=0;
		rear=temp.length-1;
	}
	public int deque() throws QueEmptyException {
		if(size==0) {
			QueEmptyException e = new QueEmptyException();
			throw e;
		}
		int temp = data[front];
//		front++;
//		if(front==data.length) {
//			front=0;				//to create circular queue;
//		}
		front = (front+1) % data.length;
		size--;
		if(size==0) {
			front = -1;
			rear = -1;
		}
		return temp;
	}
	
	 public int front() throws QueEmptyException {
		 if(size==0) {
				QueEmptyException e = new QueEmptyException();
				throw e;
			}
		 return data[front];
	 }
}
