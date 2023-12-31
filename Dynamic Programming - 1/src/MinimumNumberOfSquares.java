/*
 * Minimum Number Of Squares

	Given an integer N, find and return the count of minimum numbers 
	required to represent N as a sum of squares.
	That is, if N is 4, then we can represent it as : 
	{1^2 + 1^2 + 1^2 + 1^2} and {2^2}. 
	The output will be 1, as 1 is the minimum count of numbers required 
	to represent N as sum of squares.
	Input format :
	The first and the only line of input contains an integer value, 'N'.
	 Output format :
	Print the minimum count of numbers required.
	Constraints :
	0 <= n <= 10 ^ 4
	
	Time Limit: 1 sec
	Sample Input 1 :
	12
	Sample Output 1 :
	3
	Explanation of Sample Output 1 :
	12 can be represented as : 
	A) (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2)
	
	B) (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2)  + (2 ^ 2)
	
	C) (1^2) + (1^2) + (1^2) + (1^2) + (2 ^ 2) + (2 ^ 2)
	
	D) (2 ^ 2) + (2 ^ 2) + (2 ^ 2)
	
	As we can see, the output should be 3.
	Sample Input 2 :
	9
	Sample Output 2 :
	1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumNumberOfSquares {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
            int n = Integer.parseInt(br.readLine().trim());
            System.out.println(minCount(n));
            System.out.println(minCountIterative(n));

    }

	private static int minCount(int n) {
		int[] dp = new int[n+1];
		for(int i=0; i<=n; i++) {
			dp[i]=-1;
		}
		return minCountRecursive(n,dp);
	}

	private static int minCountRecursive(int n, int[] dp) {
		if(n==0) {
			return 0;
		}
		int ans = Integer.MAX_VALUE;
//		time complexity is O(n*n^1/2)
		for(int i=1; i*i<=n; i++) {
			int currAns;
			if(dp[n-i*i]==-1) {
			currAns = minCountRecursive(n-i*i,dp);
			dp[n-i*i]=currAns;
			}else {
				currAns = dp[n-i*i];
			}
			ans = Math.min(ans, currAns);
		}
		return ans+1;
	}
	
	private static int minCountIterative(int n) {
		if(n==0) {
			return 0;
		}
		if(n==1) {
			return 1;
		}
		int[] dp = new int[n+1];
		dp[0]=0;
		dp[1]=1;
		for(int i=2; i<=n; i++) {
			int ans = Integer.MAX_VALUE;
			int currAns;
			for(int j=1; j*j<=i; j++) {
				currAns = dp[i-j*j];
				ans = Math.min(ans, currAns);
			}
			dp[i]=1+ans;
		}
		return dp[n];
	}

}