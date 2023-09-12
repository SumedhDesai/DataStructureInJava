/*
 * check if array is sorted by recursion
 */
import java.util.Scanner;

public class IsSorted {

	public static void main(String[] args) {
		
		Scanner s = new Scanner (System.in);
		int n = s.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=s.nextInt();
		}
		System.out.println(isSorted(arr));
		s.close();
	}

	private static boolean isSorted(int[] arr) {
		if(arr.length==1) {
			return true;
		}
		if(arr[0]>arr[1]) {
			return false;
		}
		int[] smallArr= new int[arr.length-1];
		for(int i=1; i<arr.length; i++) {
			smallArr[i-1]=arr[i];
		}
		boolean isSmallSort=isSorted(smallArr);
		return isSmallSort;
	}

}
