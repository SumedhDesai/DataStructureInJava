/*
 * Print Subset Sum to K

	Given an array A and an integer K, print all subsets of A 
	which sum to K.
	Subsets are of length varying from 0 to n, that contain elements 
	of the array. But the order of elements should remain same as 
	in the input array.
	Note : The order of subsets are not important. Just print them 
	in different lines.
	Input format :
	Line 1 : Size of input array
	Line 2 : Array elements separated by space
	Line 3 : K 
	Sample Input:
	9 
	5 12 3 17 1 18 15 3 17 
	6
	Sample Output:
	3 3
	5 1
 */
import java.util.Scanner;

public class PrintSubsetSumToK {
	
	private static void printSubsetsSumTok(int[] input, int k) {
		int[] output = new int[0];
		printSubsetsSumTokHelper(input,0, k, output);
	}

	private static void printSubsetsSumTokHelper(int[] input,int si, int k, int[] output) {
		if(si == input.length) {
			if(k==0) {
				for(int i: output) {
					System.out.print(i+" ");
				}
				System.out.println();
				return;
			}else {
				return;
			}
		}
		int[] newOutput = new int[output.length+1];
		int i;
		for(i=0; i<output.length ;i++) {
			newOutput[i] = output[i];
		}
		newOutput[i] = input[si];
		printSubsetsSumTokHelper(input, si+1, k, output);
		printSubsetsSumTokHelper(input, si+1, k-input[si], newOutput);
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
		int k = s.nextInt();
		printSubsetsSumTok(input, k);
	}
}