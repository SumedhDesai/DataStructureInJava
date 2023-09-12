/*
 * Print Minimum In Array Function
 */
public class PrintMinimumInArrayFunction {
	public static void main(String[] args) {
		
		int[] arr = {9,4,6,3,5,1};
		printMin(arr,0, Integer.MAX_VALUE);
	}

	private static void printMin(int[] arr,int si, int minValue) {
		if(si==arr.length) {
			System.out.println(minValue);
			return;
		}
		if(arr[si]<minValue) {
			minValue=arr[si];
		}
		printMin(arr, si+1, minValue);
	}
}
