/*
 * Edit Distance

	You are given two strings S and T of lengths M and N, respectively. 
	Find the 'Edit Distance' between the strings.
	Edit Distance of two strings is the minimum number of steps required 
	to make one string equal to the other. In order to do so, you can 
	perform the following three operations:
	1. Delete a character
	2. Replace a character with another one
	3. Insert a character
	Note :
	Strings don't contain spaces in between.
	 Input format :
	The first line of input contains the string S of length M.
	
	The second line of the input contains the String T of length N.
	Output format :
	Print the minimum 'Edit Distance' between the strings.
	Constraints :
	0 <= M <= 10 ^ 3
	0 <= N <= 10 ^ 3
	
	Time Limit: 1 sec
	Sample Input 1 :
	abc
	dc
	Sample Output 1 :
	2
	 Explanation to the Sample Input 1 :
	 In 2 operations we can make string T to look like string S.
	First, insert character 'a' to string T, which makes it "adc".
	
	And secondly, replace the character 'd' of string T with 'b' from the 
	string S. This would make string T as "abc" which is also string S. 
	
	Hence, the minimum distance.
	Sample Input 2 :
	whgtdwhgtdg
	aswcfg
	Sample Output 2 :
	9
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditDistance {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {

		String s = br.readLine().trim();
		String t = br.readLine().trim();


		System.out.println(editDistance(s, t));
		System.out.println(editDistanceMemoization(s, t));
		System.out.println(editDistanceIteration(s, t));

	}

	private static int editDistanceIteration(String s, String t) {
		int m=s.length();
		int n=t.length();
		if(m==0) {
			return n;
		}
		if(n==0) {
			return m;
		}
		int[][] dp = new int[m+1][n+1];
		for(int i=0; i<m+1; i++) {
			dp[i][n]= m-i;
		}
		for(int i=0; i<n+1; i++) {
			dp[m][i]= n-i;
		}
		for(int i=m-1; i>=0; i--) {
			for(int j=n-1; j>=0; j--) {
				if(s.charAt(i)==t.charAt(j)) {
					dp[i][j]=dp[i+1][j+1];
				}else {
					dp[i][j] = 1+Math.min(dp[i+1][j+1], Math.min(dp[i+1][j], dp[i][j+1]));
				}
			}
		}
		return dp[0][0];
	}

	private static int editDistanceMemoization(String s, String t) {
		int m=s.length();
		int n=t.length();

		int[][] dp = new int[m+1][n+1];
		for(int i=0; i<m+1; i++) {
			for(int j=0; j<n+1; j++) {
				dp[i][j]=-1;
			}
		}
		return editDistanceMemoizationHelper(s, t, 0,0,m,n, dp);
	}

	private static int editDistanceMemoizationHelper(String s, String t, int i, int j, int m, int n, int[][] dp) {
		if(i==m) {
			return n-j;
		}
		if(j==n) {
			return m-i;
		}
		if(dp[i][j] != -1) {
			return dp[i][j];
		}
		int ans1, ans2, ans3, ans;
		if(s.charAt(i)==t.charAt(j)) {
			ans = editDistanceMemoizationHelper( s, t, i+1, j+1, m, n, dp);
			dp[i][j]=ans;
		}else {
			//			delete char at i in s String.
			ans1 = editDistanceMemoizationHelper(s, t, i+1, j, m, n, dp);
			//			replace char at i in s with char at j in t 
			//			so both char will cancel out. ans call is made on i+1 & j+1
			ans2 = editDistanceMemoizationHelper(s, t, i+1, j+1, m, n, dp);
			//			insert char at i-1 position ans it cancel with jth char of t
			ans3 = editDistanceMemoizationHelper(s, t, i, j+1, m, n, dp);
			ans = 1+Math.min(ans1, Math.min(ans2, ans3));
			dp[i][j]=ans;
		}
		return ans;
	}

	private static int editDistance(String s, String t) {

		return editDistanceHelper(s, t, 0,0);
	}

	private static int editDistanceHelper(String s, String t, int i, int j) {
		if(i == s.length()) {
			return t.length()-j;
		}
		if(j == t.length()) {
			return s.length()-i;
		}
		int ans1, ans2, ans3, ans;
		if(s.charAt(i)==t.charAt(j)) {
			ans = editDistanceHelper( s, t, i+1, j+1);
		}else {
			//			delete char at i in s String.
			ans1 = editDistanceHelper(s, t, i+1, j);
			//			replace char at i in s with char at j in t 
			//			so both char will cancel out. ans call is made on i+1 & j+1
			ans2 = editDistanceHelper(s, t, i+1, j+1);
			//			insert char at i-1 position ans it cancel with jth char of t
			ans3 = editDistanceHelper(s, t, i, j+1);
			ans = 1+Math.min(ans1, Math.min(ans2, ans3));
		}
		return ans;
	}
}