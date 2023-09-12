
public class Dequeue {

	private int[] data;
	private int  front;
	private int  rear;
	private int size;

	public Dequeue(int capacity) {
		data = new int[capacity];
		front=-1;
		rear=0;
		size=0;
	}

	public Dequeue() {
		data = new int[10];
		front=-1;
		rear=0;
		size=0;

	}

	public void insertFront(int ele) {
		if(size==data.length) {
			System.out.println("-1");
			return;
		}
		if(size==0) {
			front=0;
			rear=0;
		}else {
//			if(front==0) {
//				front=data.length-1;
//			}else {
//				front--;
//			}
			front=((front-1)+data.length)%data.length;
			// use this formulae for traveling array from left to right in circle
		}
		data[front]=ele;
		size++;
	}
	public void insertRear(int ele) {
		if(size==data.length) {
			System.out.println("-1");
			return;
		}
//		rear++;
//		if(rear==data.length) {
//			rear=0;
//		}
		if(size==0) {
			front=0;
			rear=0;
		}else{
			rear=(rear+1)%data.length;
			//use this formulae to traveling array from right to left in circle
		}
		data[rear]=ele;
		size++;
	}
	public void deleteFront() {
		if(size==0) {
			System.out.println("-1");
			return;
		}
//		front++;
//		if(front==data.length) {
//			front=0;
//		}
		if(front==rear) {
			front=-1;
			rear=-1;
		}else{
			front=(front+1)%data.length;
		}
		size--;
	}
	public void deleteRear() {
		if(size==0) {
			System.out.println("-1");
		}
//		rear--;
//		if(rear==-1) {
//			rear=data.length-1;
//		}
		if(front==rear) {
			front=-1;
			rear=-1;
		}else{
			rear=((rear-1)+data.length)%data.length;
		}
		size--;
	}
	public int getFront() {
		if(size==0) {
			return -1;
		}
		return data[front];
	}
	public int getRear() {
		if(size==0) {
			return -1;
		}
		return data[rear];
	}

/*
	public Dequeue(int capacity) {
		data = new int[capacity];
		front=5;
		rear=4;
		size=0;
	}

	public Dequeue() {
		data = new int[10];
		front=5;
		rear=4;
		size=0;

	}

	public void insertFront(int ele) {
		if(size==data.length) {
			System.out.println("-1");
			return;
		}
		front--;
		if(front==-1 && size!=data.length) {
			front=data.length-1;
		}
		data[front]=ele;
		size++;
	}

	public void insertRear(int ele) {
		if(size==data.length) {
			System.out.println("-1");
			return;
		}
		rear++;
		if(rear==data.length && size!=0) {
			rear=0;
		}
		data[rear]=ele;
		size++;
	}

	public void deleteFront() {
		if(size==0) {
			System.out.println("-1");
			return;
		}
		front++;
		if(front==data.length) {
			front=0;
		}
		size--;
	}

	public void deleteRear() {
		if(size==0) {
			System.out.println("-1");
			return;
		}
		rear--;
		if(rear==-1) {
			rear=data.length-1;
		}
		size--;
	}

	public int getFront() {
		if(size==0) {
			return -1;
		}
		return data[front];
	}

	public int getRear() {
		if(size==0) {
			return -1;
		}
		return data[rear];
	}
	*/

}
