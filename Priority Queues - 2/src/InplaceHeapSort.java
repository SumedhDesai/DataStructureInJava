/*
 * Inplace Heap Sort
	Send Feedback
	Given an integer array of size N. Sort this array (in decreasing order) 
	using heap sort.
	Note: Space complexity should be O(1).
	Input Format:
	The first line of input contains an integer, that denotes the value of 
	the size of the array or N.
	The following line contains N space separated integers, that denote the 
	value of the elements of the array.
	Output Format :
	The first and only line of output contains array elements after sorting. 
	The elements of the array in the output are separated by single space.
	Constraints :
	1 <= n <= 10^6
	Time Limit: 1 sec
	Sample Input 1:
	6 
	2 6 8 5 4 3
	Sample Output 1:
	8 6 5 4 3 2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InplaceHeapSort {

	public static void inplaceHeapSort(int[] input) {
		if(input.length == 0 || input.length == 1) {
			return;
		}
		int n = input.length;
		creatHeap(input, n);
		sortHeap(input, n);

	}

	private static void creatHeap(int[]arr, int n) {
		for(int i= (n/2)-1 ; i>=0 ; i--) {
			downHeap(arr, i, n);
		}
	}

	private static void sortHeap(int[] arr, int n) {

		for(int i=n-1; i>=0; i--) {
			int min = arr[i];
			arr[i] = arr[0];
			arr[0] = min;
			downHeap(arr, 0, i);
		}
	}

	private static void downHeap(int [] arr,int parent, int endIndex) {
		int parentIndex = parent;
		int leftChildIndex = (2*parentIndex)+1;
		int rightChildIndex = (2*parentIndex)+2;
		while(leftChildIndex < endIndex) {
			int minIndex = parentIndex;
			if(arr[leftChildIndex] < arr[minIndex]) {
				minIndex = leftChildIndex;
			}
			if(rightChildIndex < endIndex && arr[rightChildIndex] < arr[minIndex]) {
				minIndex = rightChildIndex;
			}
			if(minIndex==parentIndex) {
				break;
			}
			int temp = arr[minIndex];
			arr[minIndex] = arr[parentIndex];
			arr[parentIndex]=temp;
			parentIndex = minIndex;
			leftChildIndex = (2*parentIndex)+1;
			rightChildIndex = (2*parentIndex)+2;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int input[] = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		inplaceHeapSort(input);
		for (int i : input) {
			System.out.print(i + " ");
		}
	}
}