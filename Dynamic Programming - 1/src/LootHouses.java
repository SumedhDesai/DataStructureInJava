/*
 * Loot Houses

	A thief wants to loot houses. He knows the amount of money in each house. 
	He cannot loot two consecutive houses. Find the maximum amount of money 
	he can loot.
	Input format :
	The first line of input contains an integer value of 'n'. It is the total 
	number of houses.
	
	The second line of input contains 'n' integer values separated by a single 
	space denoting the amount of money each house has.
	Output format :
	Print the the maximum money that can be looted.
	Constraints :
	0 <= n <= 10 ^ 4
	
	Time Limit: 1 sec
	Sample Input 1 :
	6
	5 5 10 100 10 5
	Sample Output 1 :
	110
	Sample Input 2 :
	6
	10 2 30 20 3 50
	Sample Output 2 :
	90
	Explanation of Sample Output 2 :
	Looting first, third, and the last houses([10 + 30 + 50]) will result in the 
	maximum loot, and all the other possible combinations would result in less than 90.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LootHouses {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static int[] takeInput() throws IOException {
		int n = Integer.parseInt(br.readLine().trim());

		if (n == 0) {
			return new int[0];
		}

		String[] strNums = br.readLine().trim().split("\\s");
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(strNums[i]);
		}

		return arr;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] arr = takeInput();
		System.out.println(maxMoneyLooted(arr));
		System.out.println(maxMoneyLootedterative(arr));

	}

	private static int maxMoneyLooted(int[] arr) {
		int[] dp = new int[arr.length];
		for(int i=0; i<dp.length; i++) {
			dp[i]=-1;
		}
		return maxMoneyLootedHelper(arr, 0, arr.length-1,dp);
	}

	private static int maxMoneyLootedHelper(int[] arr, int si, int ei, int[] dp) {
		if(si == arr.length) {
			return 0;
		}
		if(si==ei) {
			return arr[si];
		}
		int ans1 , ans2 , ans;
		if(dp[si]==-1) {
			ans1 =arr[si]+ maxMoneyLootedHelper(arr, si+2, ei,dp);
			dp[si] = ans1;
		}else {
			ans1=dp[si];
		}
		if(dp[si+1]==-1) {
			ans2 = maxMoneyLootedHelper(arr, si+1, ei,dp);
			dp[si+1]=ans2;
		}else {
			ans2=dp[si+1];
		}
		ans = Math.max(ans1, ans2);
		return ans;
	}

	private static int maxMoneyLootedterative(int[] arr) {
		if(arr.length==0) {
			return 0;
		}
		if(arr.length==1) {
			return arr[0];
		}
		if(arr.length==2) {
			return Math.max(arr[0], arr[1]);
		}
		int[] dp = new int[arr.length];
		dp[0] = arr[0];
		dp[1] = Math.max(arr[0], arr[1]);
		
		for(int i=2; i<arr.length; i++) {
			int ans1 = arr[i]+dp[i-2];
			int ans2 = dp[i-1];
			dp[i]=Math.max(ans1, ans2);
		}
		return dp[arr.length-1];
	}
}