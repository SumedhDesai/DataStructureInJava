/*
 * Array Intersection

	You have been given two integer arrays/list(ARR1 and ARR2) of size N and M, 
	respectively. You need to print their intersection; An intersection for this 
	problem can be defined when both the arrays/lists contain a particular value 
	or to put it in other words, when there is a common value that exists in both 
	the arrays/lists.
	Note :
	Input arrays/lists can contain duplicate elements.
	
	The intersection elements printed would be in the order they appear in the 
	first sorted array/list(ARR1).
	
	
	Input format :
	The first line contains an Integer 't' which denotes the number of test 
	cases or queries to be run. Then the test cases follow.
	
	The first line of each test case or query contains an integer 'N' representing 
	the size of the first array/list.
	
	The second line contains 'N' single space separated integers representing the 
	elements of the first the array/list.
	
	The third line contains an integer 'M' representing the size of the second array/list.
	
	The fourth line contains 'M' single space separated integers representing the 
	elements of the second array/list.
	Output format :
	For each test case, print the intersection elements in a row, separated by a single space.
	
	Output for every test case will be printed in a separate line.
	Constraints :
	1 <= t <= 10^2
	0 <= N <= 10^6
	0 <= M <= 10^6
	
	Time Limit: 1 sec 
	Sample Input 1 :
	2
	6
	2 6 8 5 4 3
	4
	2 3 4 7 
	2
	10 10
	1
	10
	Sample Output 1 :
	2 3 4
	10
	Sample Input 2 :
	1
	4
	2 6 1 2
	5
	1 2 3 4 2
	Sample Output 2 :
	1 2 2
	Explanation for Sample Output 2 :
	Since, both input arrays have two '2's, the intersection of the arrays also
	 have two '2's. The first '2' of first array matches with the first '2' of 
	 the second array. Similarly, the second '2' of the first array matches with 
	 the second '2' if the second array.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArrayIntersection {

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
			int[] arr1 = takeInput();
			int[] arr2 = takeInput();
			intersection(arr1, arr2);
			System.out.println();

			t -= 1;
		}
	}

	private static void intersection(int[] arr1, int[] arr2) {
// time complexity is O(nlogn + mlogm)
		Arrays.sort(arr1);
		Arrays.sort(arr2);

		int i=0, j=0;

		while(i<arr1.length && j<arr2.length) {
			if(arr1[i]<arr2[j]){
				i++;
			}else if(arr2[j]<arr1[i]){
				j++;
			}else {
				System.out.println(arr1[i]+" ");
				i++;
				j++;
			}
		}

	}
}