/*
 * Stair Case

	A child runs up a staircase with 'n' steps and can hop either 1 step, 
	2 steps or 3 steps at a time. Implement a method to count and return 
	all possible ways in which the child can run-up to the stairs.
	Input format :
	The first and the only line of input contains an integer value, 'n', 
	denoting the total number of steps.
	Output format :
	Print the total possible number of ways.
	 Constraints :
	0 <= n <= 10 ^ 4
	
	Time Limit: 1 sec
	Sample Input 1:
	4
	Sample Output 1:
	7
	Sample Input 2:
	10
	Sample Output 2:
	274
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StairCase {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
            int n = Integer.parseInt(br.readLine().trim());
            System.out.println(staircase(n));
            System.out.println(stairCaseHeplerIterative(n));
    }

	private static long staircase(int n) {
		long[] dp = new long[n+1];
		for(int i=0; i<dp.length; i++) {
			dp[i]=-1;
		}
		return stairCaseHepler(n, dp);
	}

	private static long stairCaseHepler(int n, long[] dp) {
		if(n==0 || n==1) {
			return 1;
		}
		if(n==2) {
			return 2;
		}
		long ans1, ans2, ans3;
		if(dp[n-1]==-1) {
			ans1=stairCaseHepler(n-1, dp);
			dp[n-1] = ans1;
		}else {
			ans1 = dp[n-1];
		}
		if(dp[n-2]==-1) {
			ans2=stairCaseHepler(n-2, dp);
			dp[n-2] = ans2;
		}else {
			ans2 = dp[n-2];
		}
		if(dp[n-3]==-1) {
			ans3=stairCaseHepler(n-3, dp);
			dp[n-3] = ans3;
		}else {
			ans3 = dp[n-3];
		}
		return ans1+ans2+ans3;
	}
	
	private static long stairCaseHeplerIterative(int n) {
		if(n==0 || n==1) {
			return 1;
		}
		if(n==2) {
			return 2;
		}
		long[] dp = new long[n+1];
		dp[0]=1;
		dp[1]=1;
		dp[2]=2;
		
		for(int i=3; i<=n; i++) {
			dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
		}
		return dp[n];
	}

}