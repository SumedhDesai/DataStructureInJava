/*
 * Binary Search using Recursion
 */
import java.util.Scanner;

public class BinarySearchWithRecursion {
	public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		s.close();
		return arr;
	}

	public static void main(String[] args) {
		int[] input = takeInput();
		System.out.println(BinarySearch(input, 0, input.length-1, 4));
	}

	private static int BinarySearch(int[] arr, int si, int ei, int x) {
		
		if(arr.length==0 || si>ei){
			return -1;
		}
		int mid=(si+ei)/2;
		if(arr[mid]==x) {
			return mid;
		}else if(arr[mid]<x) {
			return BinarySearch(arr, mid+1 , ei , x);
		}else {
			return BinarySearch(arr, si , mid+1 , x);
		}
	}
}
