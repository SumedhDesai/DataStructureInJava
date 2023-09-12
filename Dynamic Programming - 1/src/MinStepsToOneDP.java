/*
 * Min Steps To 1 Using DP
	
	Given a positive integer 'n', find and return the minimum number of steps 
	that 'n' has to take to get reduced to 1. You can perform any one of the 
	following 3 steps:
	1.) Subtract 1 from it. (n = n - ­1) ,
	2.) If n is divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
	3.) If n is divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).  
	Input format :
	The first and the only line of input contains an integer value, 'n'.
	Output format :
	Print the minimum number of steps.
	Constraints :
	1 <= n <= 10 ^ 6
	Time Limit: 1 sec
	Sample Input 1 :
	4
	Sample Output 1 :
	2 
	Explanation of Sample Output 1 :
	For n = 4
	Step 1 :  n = 4 / 2  = 2
	Step 2 : n = 2 / 2  =  1 
	Sample Input 2 :
	7
	Sample Output 2 :
	3
	Explanation of Sample Output 2 :
	For n = 7
	Step 1 :  n = 7 ­- 1 = 6
	Step 2 : n = 6  / 3 = 2 
	Step 3 : n = 2 / 2 = 1  
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinStepsToOneDP {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine().trim());
		System.out.println(countMinStepsToOne(n));
		System.out.println(countMinStepsToIterative(n));
	}

	private static int countMinStepsToOne(int n) {
		int[] dp = new int[n+1];
		for(int i=0; i<dp.length; i++) {
			dp[i]=-1;
		}
		return countMinStepsToOneHelper(n,dp);
	}

	private static int countMinStepsToOneHelper(int n, int[] dp) {
		if(n==1) {
			return 0;
		}
		int ans1=Integer.MAX_VALUE; 
		int ans2=Integer.MAX_VALUE;
		int ans3=Integer.MAX_VALUE;
		if(dp[n-1]==-1) {
			ans1 = countMinStepsToOne(n-1);
			dp[n-1]=ans1;
		}else {
			ans1=dp[n-1];
		}
		if(n%2 == 0) {
			if(dp[n/2]==-1) {
				ans2 = countMinStepsToOne(n/2);
				dp[n/2]=ans2;
			}else {
				ans2=dp[n/2];
			}
		}
		if(n%3 == 0) {
			if(dp[n/3]==-1) {
				ans3 = countMinStepsToOne(n/3);
				dp[n/3]=ans3;
			}else {
				ans3=dp[n/3];
			}
		}
		return 1+Math.min(ans1, Math.min(ans2, ans3));
	}
	
	private static int countMinStepsToIterative(int n) {
		if(n==1) {
			return 0;
		}
		if(n==2 || n==3) {
			return 1;
		}
		int[] dp = new int[n+1];
		dp[0]=0;
		dp[1]=0;
		dp[2]=1;
		dp[3]=1;

		for(int i=4; i<=n; i++) {
			int ans1=Integer.MAX_VALUE; 
			int ans2=Integer.MAX_VALUE;
			int ans3=Integer.MAX_VALUE;
			
			ans1 = dp[i-1];
			if(i%2 == 0) {
				ans2=dp[i/2];
			}
			if(i%3==0) {
				ans3=dp[i/3];
			}
			dp[i]=1+Math.min(ans1, Math.min(ans2, ans3));
		}
		return dp[n];
	}

}