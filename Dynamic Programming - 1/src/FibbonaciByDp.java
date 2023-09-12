/*
 * Fibbonaci By Dp
 */
public class FibbonaciByDp {

	public static void main(String[] args) {
		int n=10;
		int[] dp = new int[n+1];
		for(int i=0; i<dp.length; i++) {
			dp[i]=-1;
		}
		int ans = fibboRecursion(n,dp);
		System.out.println(ans);
		ans = fibboIterative(n);
		System.out.println(ans);
	}
	
	private static int fibboRecursion(int n, int[] dp) {
		if(n==0 || n==1) {
			return n;
		}
		int ans1, ans2;
		if(dp[n-1]==-1) {
			ans1 = fibboRecursion(n-1, dp);
			dp[n-1]=ans1;
		}else {
			ans1 = dp[n-1];
		}
		if(dp[n-2]==-1) {
			ans2 = fibboRecursion(n-2, dp);
			dp[n-2] = ans2;
		}else {
			ans2 = dp[n-2];
		}
		return ans1+ans2;
	}
	
	private static int fibboIterative(int n) {
		
		if(n==0 || n==1) {
			return n;
		}
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i=2; i<=n; i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		return dp[n];
	}


}
