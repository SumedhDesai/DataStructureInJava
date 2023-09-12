/*
 * Magic Grid

	You are given a magic grid A with R rows and C columns. In the 
	cells of the grid, you will either get magic juice, which increases 
	your strength by |A[i][j]| points, or poison, which takes away |A[i][j]| 
	strength points. If at any point of the journey, the strength points 
	become less than or equal to zero, then you will die.
	You have to start from the top-left corner cell (1,1) and reach at 
	the bottom-right corner cell (R,C). From a cell (i,j), you can only 
	move either one cell down or right i.e., to cell (i+1,j) or cell (i,j+1) 
	and you can not move outside the magic grid. You have to find the minimum 
	number of strength points with which you will be able to reach the 
	destination cell.
	Input format:
	The first line contains the number of test cases T. T cases follow. Each 
	test case consists of R C in the first line followed by the description of 
	the grid in R lines, each containing C integers. Rows are numbered 1 to R 
	from top to bottom and columns are numbered 1 to C from left to right. 
	Cells with A[i][j] < 0 contain poison, others contain magic juice.
	Output format:
	Output T lines, one for each case containing the minimum strength you should 
	start with from the cell (1,1) to have a positive strength through out his 
	journey to the cell (R,C).
	Constraints:
	1 ≤ T ≤ 5
	2 ≤ R, C ≤ 500
	-10^3 ≤ A[i][j] ≤ 10^3
	A[1][1] = A[R][C] = 0
	Time Limit: 1 second
	Sample Input 1:
	3
	2 3
	0 1 -3
	1 -2 0
	2 2
	0 1
	2 0
	3 4
	0 -2 -3 1
	-1 4 0 -2
	1 -2 -3 0
	Sample Output 1:
	2
	1
	2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class MagicGrid {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int[][] takeInput() throws IOException {

		String[] nm;
		nm = br.readLine().split("\\s");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		int arr[][]=new int[n][m];

		if (n == 0) {
			return arr;
		}


		String[] strNums;
		for (int i = 0; i < n; ++i) {            
			strNums = br.readLine().split("\\s");
			for (int j = 0; j < m; ++j){
				arr[i][j] = Integer.parseInt(strNums[j]);
			}

		}

		return arr;
	}

	public static void main(String[] args) throws IOException {

		int t = Integer.parseInt(br.readLine().trim());
		while (t!=0){
			int[][] grid = takeInput();
			
//			System.out.println(getMinimumStrength(grid));
//			System.out.println(getMinimumStrength2(grid));
			
			System.out.println(getMinimumStrengthIterative(grid));
			System.out.println(getMinimumStrengthIterative2(grid));
			
			t--;
		}

	}

	private static int getMinimumStrengthIterative2(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m+1][n+1];

		for(int[] row : dp) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}
//		dp[m][n-1]=1;
//		dp[m-1][n]=1;
		
		for(int i=m-1; i>=0; i--) {
			for(int j=n-1; j>=0; j--) {
				if(i==m-1 && j==n-1) {
					int smallAns = 1- grid[i][j];
					dp[i][j] = Math.max(1, smallAns);
					continue;
				}
				int ans1 = dp[i][j+1];
				int ans2 = dp[i+1][j];
				int ans = Math.min(ans1, ans2)-grid[i][j];
				int finalAns = Math.max(ans, 1);
				dp[i][j]=finalAns;
			}
		}
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp.length; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		return dp[0][0];
	}

	private static int getMinimumStrengthIterative(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m+1][n+1];

		for(int[] row : dp) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		//		dp[i][j] means from ith and jth index how many health is required to survived

		for(int i=m-1; i>=0; i--) {
			for(int j=n-1; j>=0; j--) {
				if(i==m-1 && j==n-1) {
					dp[i][j]=1;
					continue;
				}
				int ans1 = dp[i][j+1];
				int ans2 = dp[i+1][j];
				int ans = Math.min(ans1, ans2)-grid[i][j];
				int finalAns = Math.max(ans, 1);
				dp[i][j]=finalAns;
			}
		}
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp.length; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		return dp[0][0];
	}

	private static int getMinimumStrength(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m+1][n+1];
		for(int[] row: dp) {
			Arrays.fill(row, -1);
		}

		return getMinimumStrengthHelper(grid, 0, 0,m,n, dp);
	}

	private static int getMinimumStrengthHelper(int[][] grid, int i, int j, int m, int n, int[][] dp) {
		if(i==m || j==n) {
			return 0;
		}
		if(i==m-1 && j==n-1) {
			return 1;
		}
		if(dp[i][j]!=-1) {
			return dp[i][j];
		}
		//		getMinimumStrengthHelper this function gives me minimum health from next cell or down cell
		//		excluding own value so need to subtract own grid to transfer answer
		int ans1=Integer.MAX_VALUE, ans2=Integer.MAX_VALUE, ans, finalAns;
		if(j+1<n) {
			//			when I call on function it will give health required up to i & j+1
			//			so i need to subtract its grid value to transfer answer

			ans1 = getMinimumStrengthHelper(grid, i, j+1, m, n, dp)-grid[i][j+1];
		}
		if(i+1<m) {
			ans2 = getMinimumStrengthHelper(grid, i+1, j, m, n, dp)-grid[i+1][j];
		}
		ans = Math.min(ans1, ans2);
		finalAns = Math.max(ans, 1);
		dp[i][j]=finalAns;
		return finalAns;
	}
	public static int getMinimumStrength2(int[][] grid) {

		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m+1][n+1];
		for(int[] row: dp) {
			Arrays.fill(row, -1);
		}

		return getMinimumStrengthHelper2(grid, 0, 0,m,n, dp);
	}

	private static int getMinimumStrengthHelper2(int[][] grid, int i, int j, int m, int n, int[][] dp) {
		if(i==m || j==n) {
			return 0;
		}
		if(i==m-1 && j==n-1) {
            int BcAns =1-grid[i][j];
			return Math.max(BcAns , 1);
		}
		if(dp[i][j]!=-1) {
			return dp[i][j];
		}
		int ans1=Integer.MAX_VALUE, ans2=Integer.MAX_VALUE, ans, finalAns;
		if(j+1<n) {
            ans1 = getMinimumStrengthHelper2(grid, i, j+1, m, n, dp);
		}
		if(i+1<m) {
            ans2 = getMinimumStrengthHelper2(grid, i+1, j, m, n, dp);
		}
		int smallAns = Math.min(ans1, ans2);
        ans = smallAns - grid[i][j];
		finalAns = Math.max(ans, 1);
    
		dp[i][j]=finalAns;
		return finalAns;
	}
}

