/*
 * Subset Sum

	You are given a set of N integers. You have to return true if there 
	exists a subset that sum up to K, otherwise return false.
	Input Format
	The first line of the test case contains an integer 'N' representing the total elements in the set.

	The second line of the input contains N integers separated by a single space.    

	The third line of the input contains a single integer, denoting the value of K.
	Output Format
	Output Yes if there exists a subset whose sum is k, else output No.
	Constraints :
	1 <= N <= 10^3
	1 <= a[i] <= 10^3, where a[i] denotes an element of the set 
	1 <= K <= 10^3

	Time Limit: 1 sec
	Sample Input 1 :
	4
	4 3 5 2
	13
	Sample Output 1 :
	No
	Sample Input 2 :
	5
	4 2 5 6 7
	14
	Sample Output 2 :
	Yes
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class SubsetSum {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int size = Integer.parseInt(br.readLine().trim());
		int[] input = new int[size];

		if (size == 0) {
			System.out.print("No");
			return;
		}

		String[] strNums;
		strNums = br.readLine().split("\\s");

		for (int i = 0; i < size; ++i) {
			input[i] = Integer.parseInt(strNums[i]);
		}

		int sum = Integer.parseInt(br.readLine().trim());
		if (isSubsetPresent(input,size,sum)){
			System.out.print("Yes");
		}
		else{
			System.out.print("No");
		}
		System.out.println();
		if (isSubsetSum(input,size,sum)){
			System.out.print("Yes");
		}
		else{
			System.out.print("No");
		}
		System.out.println();
		if (isSubsetPresentIterative(input,size,sum)){
			System.out.print("Yes");
		}
		else{
			System.out.print("No");
		}


	}

	private static boolean isSubsetPresentIterative(int[] arr, int n, int sum) {

		boolean dp[][] = new boolean[n+1][sum+1];

		// If sum is 0, then answer is true
		for (int i = 0; i <= n; i++) {
			dp[i][0] = true;
		}

		// If sum is not 0 and set is empty,
		// then answer is false
		for (int i = 1; i <= sum; i++) {
			dp[0][i] = false;		
		}

		for(int i=1; i<=n; i++) {
			for(int j=1; j<=sum; j++) {
				if(arr[i-1]>j) {
					dp[i][j]=dp[i-1][j];
				}else {
					dp[i][j]=dp[i-1][j] || dp[i-1][j-arr[i-1]];
				}
			}
		}
		return dp[n][sum];

	}

	private static boolean isSubsetPresent(int[] input, int size, int sum) {
		boolean[][] dp = new boolean[size+1][sum+1];
		for(boolean[] row : dp) {
			Arrays.fill(row, false );
		}
		return isSubsetPresentHelper(input, 0, size, sum, dp);
	}

	private static boolean isSubsetPresentHelper(int[] input, int i, int size, int sum, boolean[][] dp) {
		if(sum==0) {
			return true;
		}
		if(i==size) {
			return false;
		}
		if(dp[i][sum]) {
			return true;
		}
		boolean ans, ans1 = false, ans2 = false;
		if(input[i]>sum) {
			ans = isSubsetPresentHelper(input, i+1, size, sum, dp);
			dp[i][sum]=ans;
		}else {
			ans1 = isSubsetPresentHelper(input, i+1, size, sum-input[i], dp);
			ans2 = isSubsetPresentHelper(input, i+1, size, sum, dp);
			ans=ans2||ans1;
			dp[i][sum]=ans;
		}
		return ans;
	}
	static boolean isSubsetSum(int set[],int n, int sum)
	{
		// Base Cases
		if (sum == 0)
			return true;
		if (n == 0)
			return false;

		// If last element is greater than
		// sum, then ignore it
		if (set[n - 1] > sum)
			return isSubsetSum(set, n - 1, sum);

		/* else, check if sum can be obtained 
			by any of the following
			(a) including the last element
			(b) excluding the last element */
		return isSubsetSum(set, n - 1, sum)
				|| isSubsetSum(set, n - 1, sum - set[n - 1]);
	}

}