/*
 * LCS - Problem

	Given two strings, 'S' and 'T' with lengths 'M' and 'N', find the length 
	of the 'Longest Common Subsequence'.
	For a string 'str'(per se) of length K, the subsequences are the strings 
	containing characters in the same relative order as they are present in 
	'str,' but not necessarily contiguous. Subsequences contain all the strings 
	of length varying from 0 to K.
	Example :
	Subsequences of string "abc" are:  ""(empty string), a, b, c, ab, bc, ac, 
	abc.
	Input format :
	The first line of input contains the string 'S' of length 'M'.
	
	The second line of the input contains the string 'T' of length 'N'.
	Output format :
	Return the length of the Longest Common Subsequence.
	Constraints :
	0 <= M <= 10 ^ 3
	0 <= N <= 10 ^ 3
	
	Time Limit: 1 sec
	Sample Input 1 :
	adebc
	dcadb
	Sample Output 1 :
	3
	Explanation of the Sample Output 1 :
	Both the strings contain a common subsequence 'adb', which is the longest 
	common subsequence with length 3. 
	Sample Input 2 :
	ab
	defg
	Sample Output 2 :
	0
	Explanation of the Sample Output 2 :
	The only subsequence that is common to both the given strings is an empty 
	string("") of length 0.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {

		String s = br.readLine().trim();
		String t = br.readLine().trim();


		System.out.println(lcs(s, t));
		System.out.println(lcs2(s, t));
		System.out.println(lcsMemoization(s, t));
		System.out.println(lcsIterative(s, t));
	}

	private static int lcsIterative(String s, String t) {
		
		int m = s.length();
		int n = t.length();
		int[][] dp = new int[m+1][n+1];

		for(int i=m-1; i>=0; i-- ) {
			for(int j=n-1; j>=0; j--) {
				if(s.charAt(i)==t.charAt(j)) {
					dp[i][j]=1+ dp[i+1][j+1];
				}else {
					dp[i][j]= Math.max(dp[i+1][j], dp[i][j+1]);
				}
			}
		}
		return dp[0][0];
	}

	private static int lcsMemoization(String s, String t) {
		int[][] dp = new int[s.length()+1][t.length()+1];
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				dp[i][j]=-1;
			}
		}
		return lcsMemoizationHelper(s, t, 0, 0, dp);
	}

	private static int lcsMemoizationHelper(String s, String t, int i, int j, int[][] dp) {
		
		if(i==s.length() || j==t.length()) {
			return 0;
		}
		
		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		if(s.charAt(i)==t.charAt(j)) {
			
			return dp[i][j] = 1+lcsMemoizationHelper(s, t, i+1, j+1, dp);

		}else {
			
			int ans1 = lcsMemoizationHelper(s,t, i+1, j,dp);
			int ans2 = lcsMemoizationHelper(s,t, i, j+1,dp);
			return dp[i][j] = Math.max(ans1, ans2);
			
		}
	}
		private static int lcs(String s, String t) {
		if(s.length()==0 || t.length()==0) {
			return 0;
		}
		int ans;
		if(s.charAt(0)==t.charAt(0)) {
			ans = 1+ lcs(s.substring(1), t.substring(1));
		}else {
			int ans1 = lcs(s.substring(1),t);
			int ans2 = lcs(s,t.substring(1));
			ans = Math.max(ans1, ans2);
		}
		return ans;
	}
	private static int lcs2(String s, String t ) {
		return lcs2(s,t,0,0);
	}
	private static int lcs2(String s, String t, int i, int j) {
		if(s.length()==i || t.length()==j) {
			return 0;
		}
		int ans;
		if(s.charAt(i)==t.charAt(j)) {
			ans = 1+ lcs2(s, t, i+1, j+1);
		}else {
			int ans1 = lcs2(s,t, i+1, j);
			int ans2 = lcs2(s,t, i, j+1);
			ans = Math.max(ans1, ans2);
		}
		return ans;
	}

}