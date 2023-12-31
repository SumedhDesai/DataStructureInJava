/*
 * Rotate array
 
	You have been given a random integer array/list(ARR) of size N. Write a 
	function that rotates the given array/list by D elements(towards the left).
	 Note:
	Change in the input array/list itself. You don't need to return or print 
	the elements.
	Input format :
	The first line contains an Integer 't' which denotes the number of test cases 
	or queries to be run. Then the test cases follow.
	
	First line of each test case or query contains an integer 'N' representing 
	the size of the array/list.
	
	Second line contains 'N' single space separated integers representing the 
	elements in the array/list.
	
	Third line contains the value of 'D' by which the array/list needs to be rotated.
	Output Format :
	For each test case, print the rotated array/list in a row separated by a single space.
	
	Output for every test case will be printed in a separate line.
	Constraints :
	1 <= t <= 10^4
	0 <= N <= 10^6
	0 <= D <= N
	Time Limit: 1 sec
	Sample Input 1:
	1
	7
	1 2 3 4 5 6 7
	2
	Sample Output 1:
	3 4 5 6 7 1 2
	Sample Input 2:
	2
	7
	1 2 3 4 5 6 7
	0
	4
	1 2 3 4
	2
	Sample Output 2:
	1 2 3 4 5 6 7
	3 4 1 2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotateArray {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static int[] takeInput() throws IOException {
        int size = Integer.parseInt(br.readLine().trim());
        int[] input = new int[size];

        if (size == 0) {
            return input;
        }
        
        String[] strNums; 
        strNums = br.readLine().split("\\s");
        

        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }

        return input;
    }

    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine().trim());

        while(t > 0) {

            int[] input = takeInput();
            int d = Integer.parseInt(br.readLine().trim());
            rotate(input, d);
            printArray(input);

            t -= 1;
        }
    }

	private static void rotate(int[] arr, int d) {
		if(arr.length==0) {
			return;
		}
		reverse(arr,0,arr.length-1);
		reverse(arr,0, arr.length-1-d);
		reverse(arr,arr.length-d, arr.length-1);
	}

	private static void reverse(int[] arr, int si, int ei) {
		while(si<ei) {
			swap(arr, si, ei);
			si++;
			ei--;
		}
	}

	private static void swap(int[] arr, int si, int ei) {
		int temp=arr[si];
		arr[si]=arr[ei];
		arr[ei]=temp;
	}
}