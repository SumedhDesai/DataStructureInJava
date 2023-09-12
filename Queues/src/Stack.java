import java.util.LinkedList;
import java.util.Queue;

public class Stack {
	
	Queue <Integer> q1;
	Queue <Integer> q2;
	
	public Stack() {
		q1= new LinkedList<>();
		q2= new LinkedList<>();
	}

	public void push(int input) {
		q1.add(input);	
	}

	public int getSize() {
		return q1.size();
	}

	public boolean isEmpty() {
		return q1.size()==0;
	}

	public int pop() {
		if(q1.size()==0) {
			return -1;
		}
		while(q1.size()!=1) {
			q2.add(q1.remove());
		}
		int temp = q1.remove();
		while(!q2.isEmpty()) {
			q1.add(q2.remove());
		}
		return temp;
	}

	public int top() {
		if(q1.size()==0) {
			return -1;
		}
		while(q1.size()!=1) {
			q2.add(q1.remove());
		}
		int temp = q1.peek();
		q2.add(q1.remove());
		while(!q2.isEmpty()) {
			q1.add(q2.remove());
		}
		return temp;
	}
	
}
