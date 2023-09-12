package stackUsingArray;

public class StackUsingArray {
	
	private int[] data;
	private int topIndex;
	
	public StackUsingArray() {
		data = new int[10];
		topIndex=-1;
	}
	
	public boolean isEmpty() {
		return topIndex==-1;
	}
	
	public int size() {
		return topIndex+1;
	}
	
	public void push(int elem) throws StackOverFlowException {
		if(topIndex==data.length-1) {
//			StackOverFlowException e = new StackOverFlowException();
//			throw e;
			doubleCapacity();
		}
		topIndex++;
		data[topIndex]=elem;
	}
	
	private void doubleCapacity() {
		int[] temp = data;
		data = new int[2*temp.length];
		for(int i=0; i<temp.length; i++) {
			data[i]=temp[i];
		}
	}

	public int top() {
		return data[topIndex];
	}
	
	public int pop() throws StackEmptyExeption {
		if(topIndex==-1) {
			StackEmptyExeption e =new StackEmptyExeption();
			throw e;
		}
		int temp = data[topIndex];
		topIndex--;
		return temp;
	}

}
