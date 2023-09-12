/*
 * K Smallest Elements

	You are given with an integer k and an array of integers that contain 
	numbers in random order. Write a program to find k smallest numbers 
	from given array. You need to save them in an array and return it.
	Time complexity should be O(n * logk) and space complexity should 
	not be more than O(k).
	Note: Order of elements in the output is not important.
	Input Format :
	The first line of input contains an integer, that denotes the value of 
	the size of the array. Let us denote it with the symbol N.
	The following line contains N space separated integers, that denote the 
	value of the elements of the array.
	The following line contains an integer, that denotes the value of k.
	Output Format :
	The first and only line of output print k smallest elements. The elements 
	in the output are separated by a single space. 
	Constraints:
	Time Limit: 1 sec
	Sample Input 1 :
	13
	2 12 9 16 10 5 3 20 25 11 1 8 6 
	4
	Sample Output 1 :
	1 2 3 5 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.*;

public class KSmallestElements {

	private static ArrayList<Integer> kSmallest(int n, int[] arr, int k) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<k; i++) {
			pq.add(arr[i]);
		}
		for(int i=k; i<arr.length; i++) {
			int max = pq.peek();
			if(max > arr[i]) {
				pq.remove();
				pq.add(arr[i]);
			}
		}
		
		ArrayList<Integer> ans = new ArrayList<>();
		while(!pq.isEmpty()) {
			ans.add(pq.remove());
		}
		return ans;
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int input[] = new int[n];
		for(int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		int k = Integer.parseInt(br.readLine());
		ArrayList<Integer> output = kSmallest(n, input, k);
		Collections.sort(output);
		for (int i : output) {
			System.out.print(i + " ");
		}
	}
}