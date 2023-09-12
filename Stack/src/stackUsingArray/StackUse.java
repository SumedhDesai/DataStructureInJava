/*
 * Create stack using array
 */

package stackUsingArray;

public class StackUse {
	
	public static void main(String[] args) throws StackOverFlowException, StackEmptyExeption {
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
		
		StackUsingArray stack = new StackUsingArray();
	
		for(int i=0; i<arr.length; i++) {
			stack.push(arr[i]);
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}

	}
}
