/*
 * 0 1 Knapsack - Problem

	A thief robbing a store can carry a maximal weight of W into his knapsack. 
	There are N items, and i-th item weigh 'Wi' and the value being 'Vi.' What 
	would be the maximum value V, that the thief can steal?
	Input Format :
	The first line of the input contains an integer value N, which denotes the 
	total number of items.
	
	The second line of input contains the N number of weights separated by a 
	single space.
	
	The third line of input contains the N number of values separated by a single 
	space.
	
	The fourth line of the input contains an integer value W, which denotes the 
	maximum weight the thief can steal.
	Output Format :
	Print the maximum value of V that the thief can steal.
	Constraints :
	1 <= N <= 20
	1<= Wi <= 100
	1 <= Vi <= 100
	
	Time Limit: 1 sec
	Sample Input 1 :
	4
	1 2 4 5
	5 4 8 6
	5
	Sample Output 1 :
	13
	Sample Input 2 :
	5
	12 7 11 8 9
	24 13 23 15 16
	26
	Sample Output 2 :
	51
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Knapsack {

	private static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
		int[][] dp = new int[n+1][maxWeight+1];
		//		here maxWeight allow and i is changes so we make array with them
		//		we are making column of allow maxWeight like 0 kgwt, 1kgwt, 2kgwt .... W kgwt;

		for(int i=0; i<n+1; i++) {
			for(int j=0; j<maxWeight+1; j++) {
				dp[i][j]=-1;
			}
		}
		return knapsackHelper(weights,0, values, n, maxWeight, dp);
	}

	private static int knapsackHelper(int[] weights, int i, int[] values, int n, int maxWeight, int[][]dp) {
		if(i==weights.length) {
			return 0;
		}
		if(dp[i][maxWeight]!=-1){
			return dp[i][maxWeight];
		}
		int ans, ans1, ans2;
		if(weights[i]>maxWeight) {
			ans = knapsackHelper(weights, i+1, values, n, maxWeight, dp);
			dp[i][maxWeight]=ans;
		}else {
			ans1 = values[i]+knapsackHelper(weights, i+1, values, n, maxWeight-weights[i], dp);
			ans2 = knapsackHelper(weights, i+1, values, n, maxWeight, dp);
			ans = Math.max(ans1, ans2);
			dp[i][maxWeight]=ans;
		}
		return ans;
	}
	
	private static int knapsackIterstive(int[] weights, int[] values, int n, int maxWeightAllow) {

		int[][] dp = new int[n+1][maxWeightAllow+1];

		for(int i=0; i<=n; i++) {

			for(int w=0; w<=maxWeightAllow; w++) {
//				i=0 means no item included
//				w=0 means no weight is included
//				if either no item or no weight no profit
//				so dp[i][w]=0
				if(i==0 || w==0) {
					dp[i][w]=0;
				}else {
//					to get first item weight it is at 0th index in weights array.
					if(weights[i-1]>w) {
						dp[i][w]=dp[i-1][w];
					}else {
						dp[i][w]=Math.max(values[i-1]+dp[i-1][w-weights[i-1]], dp[i-1][w]);
					}
				}	
			}
		}
		return dp[n][maxWeightAllow];
	}

	public static int knapsackI(int W, int val[], int wt[])  {

		int n = val.length;
		int[][] dp = new int[n+1][W+1];

		for(int i=n-1; i>=0; i--) {
			for(int w=0;w<=W;w++) {

				int ans;
				if(wt[i] <= w) {
					int ans1 = val[i] + dp[i+1][w-wt[i]];
					int ans2 = dp[i+1][w];
					ans = Math.max(ans1, ans2);
				}else{
					ans = dp[i+1][w];
				}
				dp[i][w] = ans;
			}
		}
//		dp[i][w] is maxValue generated if stating from i th item and max weight allow that is w.
//		there for ans is maxValue generated if it start from 0th index ans max weight allow is capital W
		return dp[0][W];
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static Input takeInput() throws NumberFormatException, IOException {

		int n = Integer.parseInt(br.readLine().trim());

		if (n == 0) {
			return (new Input(new int[0], new int[0], 0, 0));
		}

		String[] strWeights = br.readLine().trim().split(" ");
		String[] strValues = br.readLine().trim().split(" ");
		int maxWeight = Integer.parseInt(br.readLine().trim());

		int[] weights = new int[n];
		int[] values = new int[n];

		for (int i = 0; i < n; i++) {
			weights[i] = Integer.parseInt(strWeights[i]);
			values[i] = Integer.parseInt(strValues[i]);
		}

		return (new Input(weights, values, n, maxWeight));

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		Input input = takeInput();

		int n = input.getSize();
		int[] weights = input.getWeights();
		int[] values = input.getValues();
		int maxWeight = input.getMaxWeight();


		System.out.println(knapsack(weights, values, n, maxWeight));
		System.out.println(knapsackI(maxWeight, values, weights));
		System.out.println(knapsackIterstive(weights, values, n, maxWeight));
	}
}
class Input {
	private int n;
	private int[] weights;
	private int[] values;
	private int maxWeight;

	public Input(int[] weights, int[] values, int n, int maxWeight) {
		this.n = n;
		this.weights = weights;
		this.values = values;
		this.maxWeight = maxWeight;
	}

	public int getSize() {
		return this.n;
	}

	public int[] getWeights() {
		return this.weights;
	}

	public int[] getValues() {
		return this.values;
	}

	public int getMaxWeight() {
		return this.maxWeight;
	}
}