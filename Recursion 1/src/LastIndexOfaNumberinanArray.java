/*
 * Last Index Of a Number in an Array - Question

	Given an array of length N and an integer x, you need to find and return the last 
	index of integer x present in the array. Return -1 if it is not present in the array.
	Last index means - if x is present multiple times in the array, return the index at 
	which x comes last in the array.
	You should start traversing your array from 0, not from (N - 1).
	Do this recursively. Indexing in the array starts from 0.
	Input Format :
	Line 1 : An Integer N i.e. size of array
	Line 2 : N integers which are elements of the array, separated by spaces
	Line 3 : Integer x
	Output Format :
	last index or -1
	Constraints :
	1 <= N <= 10^3
	Sample Input :
	4
	9 8 10 8
	8
	Sample Output :
	3
 */
import java.util.Scanner;

public class LastIndexOfaNumberinanArray {

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
		int x = s.nextInt();
		System.out.println(lastIndexSearchFormStart(input, x));
		System.out.println(lastIndexSearchFormEnd(input, x));
		System.out.println(lastIndexByCopingArray(input, x));


	}

	private static int lastIndexByCopingArray(int[] input, int x) {
		if(input.length==0) {
			return -1;
		}
		int[] smallArr= new int[input.length-1];
		for(int i=1; i<input.length; i++) {
			smallArr[i-1]=input[i];
		}
		int index= lastIndexByCopingArray(smallArr, x);
		if(index!=-1) {
			return index+1;
		}else {
			if(input[0]==x) {
				return 0;
			}else {
				return -1;
			}
		}
	}

	private static int lastIndexSearchFormStart(int[] input, int x) {

		int index= IndexSearchFormStart(input, x, 0);

		return index;
	}

	private static int IndexSearchFormStart(int[] input, int x, int i) {
		if(i==input.length) {
			return -1;
		}
		int index=IndexSearchFormStart(input, x, i+1);
		if(index!=-1) {
			return index;
		}else {
			if(input[i]==x) {
				return i;
			}else {
				return -1;
			}
		}
	}
	private static int lastIndexSearchFormEnd(int[] input, int x) {

		int index= IndexSearchFormEnd(input, x, input.length-1);
		return index;

	}

	private static int IndexSearchFormEnd(int[] input, int x, int i) {

		if(i<0) {
			return -1;
		}
		if(input[i]==x) {
			return i;
		}
		int index= IndexSearchFormEnd(input, x, i-1);

		return index;
	}
}