package stackUsingLL;

public class Stack {
	private Node head;
	private int size;

	public Stack() {
		head = null;
		size = 0;
	}
	public void push(int input) {
		Node temp = new Node(input);
			temp.next=head;
			head=temp;
		size++;

	}
	public int pop() {
		if(head==null) {
			return -1;
		}
		int data = head.data;
		head=head.next;
		size--;
		return data;
	}
	public int top() {
		if(head==null) {
			return -1;
		}
		int data = head.data;
		return data;
	}
	public int getSize() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}

}
