/*
 * Smallest Super-Sequence

	 Given two strings S and T with lengths M and N. Find and return the 
	 length of their shortest 'Super Sequence'.
	 The shortest 'Super Sequence' of two strings is defined as the smallest 
	 string possible that will have both the given strings as its subsequences.
	Note :
	If the two strings do not have any common characters, then return the sum 
	of the lengths of the two strings. 
	Input Format:
	The first only line of input contains a string, that denotes the value of 
	string S. The following line contains a string, that denotes the value of string T.
	Output Format:
	Length of the smallest super-sequence of given two strings. 
	Constraints :
	0 <= M <= 10 ^ 3
	0 <= N <= 10 ^ 3
	
	Time Limit: 1 sec
	Sample Input 1 :
	ab
	ac
	Sample Output 1 :
	3
	Explanation of Sample Output 1 :
	Their smallest super sequence can be "abc" which has length = 3.
	Sample Input 2 :
	pqqrpt
	qerepct
	Sample Output 2 :
	9
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmallestSuperSequence {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException  {
		String str1 = br.readLine();
		String str2 = br.readLine();
		int min_len = smallestSuperSequence(str1, str2);
		System.out.println(min_len);
		System.out.println(smallestSuperSequenceIterative(str1, str2));
		System.out.println(smallestSuperSequenceSubString(str1, str2));
	}
	private static int smallestSuperSequence(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		int[][] dp = new int[m+1][n+1];
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				dp[i][j]=-1;
			}
		}
		return smallestSuperSequence(str1, str2, 0,0, m, n, dp);
	}
	private static int smallestSuperSequence(String s, String t, int i, int j, int m, int n, int[][] dp) {
		if(i==m) {
			return n-j;
		}
		if(j==n) {
			return m-i;
		}
		if(dp[i][j]!=-1) {
			return dp[i][j];
		}
		int ans, ans1, ans2;
		if(s.charAt(i)==t.charAt(j)) {
			ans = 1+ smallestSuperSequence(s, t, i+1, j+1, m, n, dp);
			dp[i][j]=ans;
		}else {
			ans1 = smallestSuperSequence(s, t, i+1, j, m, n, dp);
			ans2 = smallestSuperSequence(s, t, i, j+1, m, n, dp);
			ans = 1+ Math.min(ans1, ans2);
			dp[i][j]=ans;
		}
		return ans;
	}

	private static int smallestSuperSequenceIterative(String s, String t) {
		int m = s.length();
		int n = t.length();

		int[][] dp = new int[m+1][n+1];
		for(int i=0; i<m+1; i++) {
			dp[i][n]=m-i;
		}
		for(int j=0; j<=n; j++) {
			dp[m][j]=n-j;
		}

		for(int i=m-1; i>=0; i--) {
			for(int j=n-1; j>=0; j--) {
				if(s.charAt(i)==t.charAt(j)) {
					dp[i][j]=1+dp[i+1][j+1];
				}else {
					dp[i][j]=1+Math.min(dp[i+1][j], dp[i][j+1]);
				}
			}
		}
		return dp[0][0];
	}
	
	private static int smallestSuperSequenceSubString(String s, String t) {
		if(s.length()==0) {
			return t.length();
		}
		if(t.length()==0) {
			return s.length();
		}
		
		int ans, ans1, ans2;
		if(s.charAt(0)==t.charAt(0)) {
			System.out.println(s.substring(1));
			System.out.println(t.substring(1));
			System.out.println();
			ans = 1+ smallestSuperSequenceSubString(s.substring(1),t.substring(1));
		}else {
			System.out.println(s.substring(1));
			System.out.println(t);
			System.out.println();
			ans1 = smallestSuperSequenceSubString(s.substring(1),t);
			System.out.println(ans1);
			System.out.println(t.substring(1));
			System.out.println(s);
			System.out.println();
			ans2 = smallestSuperSequenceSubString(s, t.substring(1));
			System.out.println(ans2);
			ans = 1+ Math.min(ans1, ans2);
			System.out.println(ans);
			
		}
		return ans;
	}


}