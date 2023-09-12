/*
 * Longest subset zero sum

	Given an array consisting of positive and negative integers, find the 
	length of the longest sub array whose sum is zero.
	Input Format:
	The first line of input contains an integer, that denotes the value of 
	the size of the array. Let us denote it with the symbol N.
	The following line contains N space separated integers, that denote 
	the value of the elements of the array.
	Output Format
	The first and only line of output contains length of the longest sub 
	array whose sum is zero.
	Constraints:
	0 <= N <= 10^8
	Time Limit: 1 second
	Sample Input 1:
	10 
	 95 -97 -387 -435 -5 -70 897 127 23 284
	Sample Output 1:
	5
	Explanation:
	The five elements that form the longest sub array that sum up to zero 
	are: -387, -435, -5, -70, 897 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LongestSubsetZeroSum {

	private static int lengthOfLongestSubsetWithZeroSum(int[] arr) {
		int length = 0;
		for(int i =1; i<arr.length; i++) {
			arr[i]=arr[i]+arr[i-1];
		}
		
		for(int i =0; i<arr.length; i++) {
			System.out.print(arr[i]+ " ");;
		}
		HashMap<Integer, Integer> map = new HashMap<>();

		for(int i=0; i<arr.length; i++) {
			if(arr[i]==0) {
				if(length < i+1) {
					length=i+1;
				}
			}else if(map.containsKey(arr[i])) {
				if(length < (i-map.get(arr[i]))) {
					length =i-map.get(arr[i]);
				}
			}else {
				map.put(arr[i], i);
			}
		}
		for(int i =0; i<arr.length; i++) {
			System.out.println(arr[i]+ " "+map.get(arr[i]));;
		}
		return length;
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int arr[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(lengthOfLongestSubsetWithZeroSum(arr));
	}

}