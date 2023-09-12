/*
 * Merge Sort - Problem Statement

	Sort an array A using Merge Sort.
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
	2 1 5 2 3
	Sample Output 2 :
	1 2 2 3 5 
 */
import java.util.Scanner;

public class MergeSortWithRecursion {
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

	public static void printArray(int input[]) {
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}

	public static void main(String[] args) {
		int[] input = takeInput();
		mergeSort(input);
		printArray(input);
	}

	private static void mergeSort(int[] input) {
		if(input.length<=1) {
			return;
		}
		int mid = input.length/2;
		int[] s1= new int [mid];
		for(int i=0; i<mid; i++) {
			s1[i]=input[i];
		}

		int[] s2= new int [input.length-mid];
		for(int i=0; i<s2.length; i++) {
			s2[i]=input[mid+i];
		}
		
		mergeSort(s1);
		mergeSort(s2);

		mearge(s1, s2, input);
	}

	private static void mearge(int[] a, int[] b, int[] c) {
		int i=0, j=0, k=0;
		while(i<a.length && j<b.length) {
			if(a[i]<b[j]) {
				c[k]=a[i];
				i++;
				k++;
			}else{
				c[k]=b[j];
				j++;
				k++;
			}
		}
		while(i<a.length) {
			c[k]=a[i];
			i++;
			k++;
		}
		while(j<b.length) {
			c[k]=b[j];
			j++;
			k++;
		}
	}
}
