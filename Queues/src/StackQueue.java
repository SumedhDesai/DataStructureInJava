import java.util.Stack;

public class StackQueue {
	private Stack<Integer> s1;
	private Stack<Integer> s2;
	
	public StackQueue(){
		s1=new Stack<>();
		s2=new Stack<>();
	}
	
	public int size() {
		return s1.size();
	}
	
	public boolean isEmpty() {
		return s1.isEmpty();
	}
	
	public void enqueue(int data) {
		s1.add(data);
	}
	
	public int dequeue() {
		if(s1.isEmpty()) {
			return -1;
		}
		while(s1.size()!=1) {
			s2.add(s1.pop());
		}
		int temp = s1.pop();
		
		while(!s2.isEmpty()) {
			s1.add(s2.pop());
		}
		return temp;
	}
	
	public int front() {
		if(s1.isEmpty()) {
			return -1;
		}
		while(s1.size()!=1) {
			s2.add(s1.pop());
		}
		int temp = s1.peek();
		s2.add(s1.pop());
		while(!s2.isEmpty()) {
			s1.add(s2.pop());
		}
		return temp;
	}

}
