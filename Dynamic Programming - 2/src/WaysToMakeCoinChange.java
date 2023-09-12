/*
 * Ways To Make Coin Change

	For the given infinite supply of coins of each of denominations, 
	D = {D0, D1, D2, D3, ...... Dn-1}. You need to figure out the total number 
	of ways W, in which you can make the change for Value V using coins of 
	denominations D.
	Return 0 if the change isn't possible.
	Input Format
	The first line of the input contains an integer value N, which denotes 
	the total number of denominations.

	The second line of input contains N values, separated by a single space. 
	These values denote the value of denomination.

	The third line of the input contains an integer value, that denotes the value of V.
	Output Format
	Print the total total number of ways i.e. W.
	Constraints :
	1 <= n <= 10
	1 <= V <= 1000

	Time Limit: 1sec
	Sample Input 1 :
	3
	1 2 3
	4
	Sample Output 1 :
	4
	Explanation to Sample Input 1 :
	Number of ways are - 4 total i.e. (1,1,1,1), (1,1, 2), (1, 3) and (2, 2).
	Sample Input 2 :
	6
	1 2 3 4 5 6
	250
	Sample Output 2 :
	13868903
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class WaysToMakeCoinChange {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {

		int numDenominations = Integer.parseInt(br.readLine().trim());

		int denominations[] = new int[numDenominations];
		String[] strNums;
		strNums = br.readLine().split("\\s");

		for (int i = 0; i < numDenominations; ++i) {
			denominations[i] = Integer.parseInt(strNums[i]);
		}
		int value = Integer.parseInt(br.readLine().trim());


		System.out.println(countWaysToMakeChange(denominations, value));
		System.out.println(countWaysToMakeChange2(denominations, value));


	}
	private static int countWaysToMakeChange(int[] coin, int value) {
		int m = coin.length;
		int[][] dp = new int[m+1][value+1];
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				dp[i][j]=-1;
			}
		}
		return countWaysToMakeChangeRecursion(coin,0, value, dp);
	}
	private static int countWaysToMakeChangeRecursion(int[] coin, int i, int value, int[][] dp) {
		if(value==0) {
			return 1;
		}
		if(value<0) {
			return 0;
		}
		if(i==coin.length) {
			return 0;
		}
		if(dp[i][value]!=-1) {
			return dp[i][value];
		}
		//		int ans =0
		//		this for method create duplicate call like {1,2} and {2,1}
		//		which is not allowed.
		//		for(int i=0; i<coin.length; i++) {
		//			ans = ans+countWaysToMakeChangeRecursion(coin, value-coin[i]);
		//		}

		//		this include exclude method makes all unique call like if it starting from 1
		//		then it will explore all possible answer from 1
		//		and doesn't repeat 1 in next answer thats why once {1,2} call is done
		//		then {2,1} will not call

		int ans1 = countWaysToMakeChangeRecursion(coin,i, value-coin[i], dp);
		int ans2 = countWaysToMakeChangeRecursion(coin, i+1, value,dp);
		int ans = ans1+ans2;
		dp[i][value]=ans;
		return ans;
	}
	private static int countWaysToMakeChange2(int[] coin, int value) {
		int m = coin.length;
		int[][] dp = new int[m+1][value+1];
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				dp[i][j]=-1;
			}
		}
		return countWaysToMakeChangeRecursion2(coin,0, value, dp);
	}
	private static int countWaysToMakeChangeRecursion2(int[] coin, int i, int value, int[][] dp) {
		if(value==0) {
			return 1;
		}
		if(i==coin.length) {
			return 0;
		}
		if(dp[i][value]!=-1) {
			return dp[i][value];
		}
		int ans, ans1, ans2;
		if(coin[i]>value) {
			ans = countWaysToMakeChangeRecursion2(coin, i+1, value, dp);
			dp[i][value]=ans;
		}else {
			ans1 = countWaysToMakeChangeRecursion2(coin,i, value-coin[i], dp);
			ans2 = countWaysToMakeChangeRecursion2(coin, i+1, value,dp);
			ans = ans1+ans2;
			dp[i][value]=ans;
		}
		return ans;
	}

}