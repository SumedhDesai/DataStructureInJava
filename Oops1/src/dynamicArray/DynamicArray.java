package dynamicArray;

public class DynamicArray {
	
	private int[] arr;
	private int nextEntry;
	
	public DynamicArray(){
		
		arr = new int[5];
		nextEntry=0;
		
	}
	
	public int size() {
		
		return nextEntry;
		
	}
	
	public boolean isEmpty() {
		
		return nextEntry==0;
		
	}
	
	public int get(int i) {
		if(i>=nextEntry) {
//			thows error
			return -1;
		}
		return arr[i];
		
	}
	
	public void set(int i, int val) {
		if(i>=nextEntry) {
//			thows error
			return ;
		}
		arr[i]=val;
		
	}
	
	public void add(int val) {
		if(nextEntry==arr.length) {
			extendArray();
		}
		arr[nextEntry]=val;
		nextEntry++;
		
	}

	private void extendArray() {
		
		int[] temp = new int[arr.length*2];
		
		for(int i=0; i<arr.length; i++) {
			temp[i]=arr[i];
		}
		arr=temp;
	}
	
	public int removeLast() {
		if(nextEntry==0) {
//			throw error
			return -1;
		}
		int temp= arr[nextEntry-1];
		nextEntry--;
		return temp;
	}

}
