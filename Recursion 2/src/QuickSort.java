/*
 * Quick Sort - Problem Statement

	Sort an array A using Quick Sort.
	Change in the input array itself. So no need to return or print anything.
	
	
	Input format :
	Line 1 : Integer n i.e. Array size
	Line 2 : Array elements (separated by space)
	Output format :
	Array elements in increasing order (separated by space)
	Constraints :
	1 <= n <= 10^3
	Sample Input 1 :
	6 
	2 6 8 5 4 3
	Sample Output 1 :
	2 3 4 5 6 8
	Sample Input 2 :
	5
	1 5 2 7 3
	Sample Output 2 :
	1 2 3 5 7 
 */
import java.util.Scanner;

public class QuickSort {
	
	static Scanner s = new Scanner(System.in);
	
	public static int[] takeInput(){
		int size = s.nextInt();
		int[] input = new int[size];
		for(int i = 0; i < size; i++){
			input[i] = s.nextInt();
		}
		return input;
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		quickSort(input);
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}


	private static int partition(int[] arr, int si, int ei) {
		int pivot=arr[si];
		int count=0;
		for(int i=si+1; i<=ei; i++) {
			if(pivot>arr[i]) {
				count++;
			}
		}
		int temp= arr[si+count];
		arr[si+count]=arr[si];
		arr[si]=temp;
		
		int i=si, j=ei;
		while(i<j) {
			if(arr[i]<pivot) {
				i++;
			}else if(arr[j]>=pivot) {
				j--;
			}else {
				int temp2=arr[j];
				arr[j]=arr[i];
				arr[i]=temp2;
				i++;
				j--;
			}
		}
		return si+count;
	}
	
	private static void quickSort(int[] input) {
		quickSort2(input, 0, input.length-1);
	}
	private static void quickSort2(int[] arr, int si, int ei) {
		if(si>=ei) {
			return;
		}
		int pivotINdex=partition(arr, si, ei);
		quickSort2(arr, si, pivotINdex-1);
		quickSort2(arr, pivotINdex+1, ei);
	}
}