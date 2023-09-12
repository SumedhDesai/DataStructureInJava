/*
 * Return subset of an array

	Given an integer array (of length n), find and return all the subsets 
	of input array.
	Subsets are of length varying from 0 to n, that contain elements of the array. 
	But the order of elements should remain same as in the input array.
	Note : The order of subsets are not important.
	Input format :
	
	Line 1 : Size of array
	
	Line 2 : Array elements (separated by space)
	
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

public class ReturnSubsetOfAnArray {
	
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
		int output[][] = subsets(input);
		for(int i = 0; i < output.length; i++) {
			for(int j = 0; j < output[i].length; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static int[][] subsets(int[] arr) {

		return subsetsHelper(arr, 0);
	}
	
	private static int[][] subsetsHelper(int[] arr, int si) {
		if(si == arr.length) {
			return new int[1][0];
		}

		int[][] temp = subsetsHelper(arr, si+1);

		int[][] output = new int[2*temp.length][];
		int index=0;

		for(int i=0; i<temp.length; i++) {
			output[index]=temp[i];
			index++;
		}

//		for(int i=0;i<temp.length;i++){
//			output[index]= new int[temp[i].length];
//			for(int j=0;j<temp[i].length;j++){
//				output[index][j]=temp[i][j];
//			}
//			index++;
//		}

		for(int i=0; i<temp.length; i++) {
			output[index] = new int[temp[i].length+1];
			output[index][0] = arr[si];
			for(int j=0; j<temp[i].length; j++) {
				output[index][j+1]=temp[i][j];
			}
			index++;
		}
		return output;
	}

}	