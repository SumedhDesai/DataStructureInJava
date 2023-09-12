/*
 * Print Subsets of Array

	Given an integer array (of length n), find and print all the subsets of 
	input array.
	Subsets are of length varying from 0 to n, that contain elements of the array. 
	But the order of elements should remain same as in the input array.
	Note : The order of subsets are not important. Just print the subsets 
	in different lines.
	Input format :
	Line 1 : Integer n, Size of array
	Line 2 : Array elements (separated by space)
	Constraints :
	1 <= n <= 15
	Sample Input:
	3
	15 20 12
	Sample Output:
	[] (this just represents an empty array, don't worry about the square brackets)
	12 
	20 
	20 12 
	15 
	15 12 
	15 20 
	15 20 12 
 */
import java.util.Scanner;

public class PrintSubsetOfArray {

	private static void printSubsets(int[] input) {
		int[] output = new int[0];
		printSubsetsHelper(input,0 ,output);
	}

	private static void printSubsetsHelper(int[] input, int si, int[] output) {
		if(si == input.length) {
			for(int i: output) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		int[] newOutput = new int[output.length+1];
		int i;
		for(i=0; i<output.length; i++) {
			newOutput[i] = output[i];
		}
		newOutput[i] = input[si];
		printSubsetsHelper(input, si+1, output);
		printSubsetsHelper(input, si+1, newOutput);
	}

	static Scanner s = new Scanner(System.in);

	public static int[] takeInput() {
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] input = takeInput();
		printSubsets(input);
	}

}
