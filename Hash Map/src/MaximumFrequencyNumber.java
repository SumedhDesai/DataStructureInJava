/*
 * Maximum Frequency Number

	You are given an array of integers that contain numbers in random order. 
	Write a program to find and return the number which occurs the maximum 
	times in the given input.
	If two or more elements contend for the maximum frequency, return the 
	element which occurs in the array first.
	Input Format:
	The first line of input contains an integer, that denotes the value of 
	the size of the array. Let us denote it with the symbol N.
	The following line contains N space separated integers, that denote the 
	value of the elements of the array.
	Output Format :
	The first and only line of output contains most frequent element in the 
	given array.
	Constraints:
	0 <= N <= 10^8
	Time Limit: 1 sec
	Sample Input 1 :
	13
	2 12 2 11 12 2 1 2 2 11 12 2 6 
	Sample Output 1 :
	2
	Sample Input 2 :
	3
	1 4 5
	Sample Output 2 :
	1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MaximumFrequencyNumber {
	
	private static int maxFrequencyNumber(int[] arr) {
		
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		for(int i : arr) {
			if(hm.containsKey(i)) {
				int v = hm.get(i);
				v=v+1;
				hm.put(i, v);
//				hm.put(i, hm.get(i)+1);
			}else {
				hm.put(i, 1);
			}
		}
		int maxNum = Integer.MIN_VALUE;
		int max =0;
		
		for(Integer i : arr) {
			if(max < hm.get(i)) {
				maxNum = i;
				max=hm.get(i);
			}
		}
		return maxNum;
	}
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


        int[] arr = takeInput();
        System.out.println(maxFrequencyNumber(arr));


    }
}