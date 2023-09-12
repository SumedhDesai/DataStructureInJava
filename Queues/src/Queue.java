
public class Queue {
	
	private Node head;
	private Node tail;
	private int size;


	public Queue() {
		head=null;
		tail=null;
		size=0;
	}
	

	public int getSize() { 
		return size;
	}


    public boolean isEmpty() {
    	return size==0;
    }


    public void enqueue(int data) {
    	Node curr= new Node(data);
    	size++;
    	if(head==null) {
    		head=curr;
    		tail=curr;
    		return;
    	}
    	tail.next=curr;
    	tail=curr;	
    }


    public int dequeue() {
    	if(size==0) {
    		return -1;
    	}
    	int temp = head.data;
    	head=head.next;
    	size--;
    	if(head==null) {
    		tail=null;
    	}
    	return temp;
    }


    public int front() {
    	if(size==0) {
    		return -1;
    	}
    	return head.data;
    }
}

