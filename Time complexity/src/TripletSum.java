/*
 * Triplet sum

	You have been given a random integer array/list(ARR) and a number X. 
	Find and return the triplet(s) in the array/list which sum to X.
	Note :
	Given array/list can contain duplicate elements.
	Input format :
	The first line contains an Integer 't' which denotes the number of test 
	cases or queries to be run. Then the test cases follow.
	
	First line of each test case or query contains an integer 'N' representing 
	the size of the first array/list.
	
	Second line contains 'N' single space separated integers representing the 
	elements in the array/list.
	
	Third line contains an integer 'X'.
	Output format :
	For each test case, print the total number of triplets present in the array/list.
	
	Output for every test case will be printed in a separate line.
	Constraints :
	1 <= t <= 10^2
	0 <= N <= 10^3
	0 <= X <= 10^9
	
	Time Limit: 1 sec
	Sample Input 1:
	1
	7
	1 2 3 4 5 6 7 
	12
	Sample Output 1:
	5
	Sample Input 2:
	2
	7
	1 2 3 4 5 6 7 
	19
	9
	2 -5 8 -6 0 5 10 11 -3
	10
	Sample Output 2:
	0
	5
	
	
	 Explanation for Input 2:
	Since there doesn't exist any triplet with sum equal to 19 for the first query, 
	we print 0.
	
	For the second query, we have 5 triplets in total that sum up to 10. 
	They are, (2, 8, 0), (2, 11, -3), (-5, 5, 10), (8, 5, -3) and (-6, 5, 11)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TripletSum {

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

            int[] arr = takeInput();
            int num = Integer.parseInt(br.readLine().trim());
            System.out.println(tripletSum(arr, num));

            t -= 1;
        }
    }

	private static int tripletSum(int[] arr, int num) {
		
//		time coplexity is O(n3)
//		int count=0;
//		for(int i=0; i<arr.length-2; i++) {
//			for(int j=i+1; j<arr.length-1; j++) {
//				for(int k=j+1; k<arr.length; k++) {
//					if(arr[i]+arr[j]+arr[k]==num) {
//						count++;
//					}
//				}
//			}
//		}
//		return count;
		Arrays.sort(arr);
		int numtriplet=0;
		for(int i=0; i<arr.length; i++) {
			int pairForNum=num-arr[i];
			int numPair=findPair(arr, i+1, arr.length-1, pairForNum);
			
			numtriplet+=numPair;
		}
		return numtriplet;
	}

	private static int findPair(int[] arr, int si, int ei, int num) {
		int numPair=0;
		
		while(si<ei) {
			if(arr[si]+arr[ei]<num) {
				si++;
			}else if(arr[si]+arr[ei]>num) {
				ei--;
			}else {
				int elementAtStart=arr[si];
				int elementAtEnd=arr[ei];
				
				if(elementAtStart==elementAtEnd) {
					int elementFromStratToEnd=ei-si+1;
					numPair+=((elementFromStratToEnd)*(elementFromStratToEnd-1))/2;
					return numPair;
				}
				int tsi=si+1;
				int tei=ei-1;
				
				while(arr[tsi]==elementAtStart) {
					tsi++;
				}
				while(arr[tei]==elementAtEnd) {
					tei--;
				}
				int elementFromStrat=tsi-si;
				int elementFromEnd=ei-tei;
				
				numPair+=elementFromStrat*elementFromEnd;
				si=tsi;
				ei=tei;
			}
				
		}
		return numPair;
	}
}