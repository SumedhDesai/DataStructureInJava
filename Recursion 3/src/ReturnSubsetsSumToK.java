/*
 * Return subsets sum to K

	Given an array A of size n and an integer K, return all subsets 
	of A which sum to K.
	Subsets are of length varying from 0 to n, that contain elements of 
	the array. But the order of elements should remain same as in the 
	input array.
	Note : The order of subsets are not important.
	Input format :
	Line 1 : Integer n, Size of input array
	Line 2 : Array elements separated by space
	Line 3 : K 
	Constraints :
	1 <= n <= 20
	Sample Input :
	9 
	5 12 3 17 1 18 15 3 17 
	6
	Sample Output :
	3 3
	5 1
 */
import java.util.Scanner;

public class ReturnSubsetsSumToK {
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
		int output[][] = subsetsSumK(input, k);
		for(int i = 0; i < output.length; i++) {
			for(int j = 0; j < output[i].length; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int[][] subsetsSumK(int[] input, int k) {
		return subsetsSumHelper(input, k, 0);
	}

	private static int[][] subsetsSumHelper(int[] arr, int k, int si) {
		if(si == arr.length) {
			if(k==0) {
				int[][] ans = new int[1][0];
				return ans;
			}else {
				int[][] ans = new int[0][0];
				return ans;
			}
		}
		int[][] temp1 = subsetsSumHelper(arr, k, si+1);
		int[][] temp2 = subsetsSumHelper(arr, k-arr[si], si+1);
		int index=0;
		int[][] output = new int[temp1.length+temp2.length][];

		for(int i=0; i<temp1.length; i++) {
//			creating column for ith array
			output[i] = new int[temp1[i].length];

			for(int j=0; j<temp1[i].length; j++) {
				output[i][j] = temp1[i][j];
			}
			index++;
		}
		
//		directly coping temp2 column reference to output array
//		for(int i=0;i<temp1.length;i++){
//			output[index ++]=temp1[i];
//		}

		for(int i=0; i<temp2.length; i++) {
//			creating column for ith array
			output[index] = new int[temp2[i].length+1];
			
//			storing first element from which we call the function
			output[index][0]=arr[si];
			
			for(int j=0; j<temp2[i].length; j++) {
				output[index][j+1]= temp2[i][j];
			}
			index++;
		}
		return output;
	}
}
