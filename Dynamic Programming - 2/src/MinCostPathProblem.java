/*
 * Min Cost Path Problem

	An integer matrix of size (M x N) has been given. Find out the minimum cost to reach from the cell (0, 0) to (M - 1, N - 1).
	From a cell (i, j), you can move in three directions:
	1. ((i + 1),  j) which is, "down"
	2. (i, (j + 1)) which is, "to the right"
	3. ((i+1), (j+1)) which is, "to the diagonal"
	The cost of a path is defined as the sum of each cell's values through which the route passes.
	 Input format :
	The first line of the test case contains two integer values, 'M' and 'N', separated by a single space. They represent the 'rows' and 'columns' respectively, for the two-dimensional array/list.

	The second line onwards, the next 'M' lines or rows represent the ith row values.

	Each of the ith row constitutes 'N' column values separated by a single space.
	Output format :
	Print the minimum cost to reach the destination.
	Constraints :
	1 <= M <= 10 ^ 2
	1 <= N <=  10 ^ 2

	Time Limit: 1 sec
	Sample Input 1 :
	3 4
	3 4 1 2
	2 1 8 9
	4 7 8 1
	Sample Output 1 :
	13
	Sample Input 2 :
	3 4
	10 6 9 0
	-23 8 9 90
	-200 0 89 200
	Sample Output 2 :
	76
	Sample Input 3 :
	5 6
	9 6 0 12 90 1
	2 7 8 5 78 6
	1 6 0 5 10 -4 
	9 6 2 -10 7 4
	10 -2 0 5 5 7
	Sample Output 3 :
	18
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinCostPathProblem {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static int[][] take2DInput() throws IOException {
		String[] strRowsCols = br.readLine().trim().split("\\s");
		int mRows = Integer.parseInt(strRowsCols[0]);
		int nCols = Integer.parseInt(strRowsCols[1]);

		if (mRows == 0) {
			return new int[0][0];
		}


		int[][] mat = new int[mRows][nCols];

		for (int row = 0; row < mRows; row++) {
			String[] strNums; 
			strNums = br.readLine().trim().split("\\s");

			for (int col = 0; col < nCols; col++) {
				mat[row][col] = Integer.parseInt(strNums[col]);
			}
		}

		return mat;
	}


	public static void main(String[] args) throws NumberFormatException, IOException {
		int[][] mat = take2DInput();
		System.out.println(minCostPath(mat));
		System.out.println(minCostPathMemoization(mat));
		System.out.println(minCostPathIterative(mat));


	}

	private static int minCostPath(int[][] mat) {
		return minCostPathRecursion(mat, 0, 0);
	}


	private static int minCostPathRecursion(int[][] mat, int i, int j) {

		if(i==mat.length || j==mat[i].length ) {
			return Integer.MAX_VALUE;
		}
		if(i==mat.length-1 && j==mat[i].length-1) {
			return mat[i][j];
		}
		int ans1 = minCostPathRecursion(mat, i+1, j);
		int ans2 = minCostPathRecursion(mat, i, j+1);
		int ans3 = minCostPathRecursion(mat, i+1, j+1);

		return mat[i][j]+Math.min(ans1, Math.min(ans2, ans3));
	}

	private static int minCostPathMemoization(int[][] mat) {

		int row = mat.length;
		int col = mat[0].length;

		int[][] dp = new int[row+1][col+1];	

		for(int i=0; i<=row; i++) {
			for(int j=0; j<=col; j++) {
				dp[i][j]=Integer.MIN_VALUE;
			}
		}
		return minCostPathMemoizatioHelpern(mat,0,0,dp,row, col);
	}

	private static int minCostPathMemoizatioHelpern(int[][] mat, int i, int j, int[][] dp, int row, int col) {

		if(i==row || j==col ) {
			return Integer.MAX_VALUE;
		}
		if(i==row-1 && j==col-1) {
			dp[i][j]=mat[i][j];
			return mat[i][j];
		}
		int ans1, ans2, ans3;

		if(dp[i+1][j]==Integer.MIN_VALUE) {
			ans1 = minCostPathMemoizatioHelpern(mat, i+1, j, dp, row, col);
			dp[i+1][j]=ans1;
		}else {
			ans1 = dp[i+1][j];
		}
		if(dp[i][j+1]==Integer.MIN_VALUE) {
			ans2 = minCostPathMemoizatioHelpern(mat, i, j+1, dp, row, col);
			dp[i][j+1]=ans2;
		}else {
			ans2 = dp[i][j+1];
		}
		if(dp[i+1][j+1]==Integer.MIN_VALUE) {
			ans3 = minCostPathMemoizatioHelpern(mat, i+1, j+1, dp, row, col);
			dp[i+1][j+1]=ans3;
		}else {
			ans3=dp[i+1][j+1];
		}
		return mat[i][j]+Math.min(ans1, Math.min(ans2, ans3));
	}

	private static int minCostPathIterative(int[][] mat) {
		int row = mat.length;
		int col = mat[0].length;

		int[][] dp = new int[row+1][col+1];

		for(int i=0; i<=row; i++) {
			for(int j=0; j<=col; j++) {
				dp[i][j]=Integer.MAX_VALUE;
			}
		}
		
		for(int i=row-1; i>=0; i--) {
			for(int j=col-1; j>=0; j--) {
				if(i==row-1 && j==col-1) {
					dp[i][j]=mat[i][j];
					continue;
				}
				dp[i][j] =mat[i][j]+Math.min(dp[i+1][j+1], Math.min(dp[i+1][j], dp[i][j+1]));
			}
		}
		return dp[0][0];
	}

}