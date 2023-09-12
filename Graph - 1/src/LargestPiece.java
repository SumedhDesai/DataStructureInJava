/*
 * Largest Piece

	It's Gary's birthday today and he has ordered his favourite square cake 
	consisting of '0's and '1's . But Gary wants the biggest piece of '1's and 
	no '0's . A piece of cake is defined as a part which consist of only '1's, 
	and all '1's share an edge with each other on the cake. Given the size of 
	cake N and the cake, can you find the count of '1's in the biggest piece 
	of '1's for Gary ?
	Input Format :
	The first line of input contains an integer, that denotes the value of N. 
	Each of the following N lines contain N space separated integers.
	Output Format :
	Print the count of '1's in the biggest piece of '1's, according to the 
	description in the task.
	Constraints :
	1 <= N <= 1000
	Time Limit: 1 sec
	Sample Input 1:
	2
	1 1
	0 1
	Sample Output 1:
	3
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestPiece {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static String[] takeInput() throws IOException {
		int n = Integer.parseInt(br.readLine().trim());


		String[] edge = new String[n];
		for (int i = 0; i < n; i++) {
			edge[i] = br.readLine().replaceAll("\\s", "");
		}
		return edge;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		String[] edge = takeInput();
		int ans = dfs(edge,edge.length);
		System.out.println(ans);   
	}

	public static int dfs(String[] graph, int N) {
		int[][] mat = new int[N][N];
		for(int i=0; i<N; i++) {
			String str = graph[i];
			for(int j=0; j<N; j++) {
				mat[i][j] = str.charAt(j) - '0';
			}
		}

		boolean visited[][] = new boolean[N][N]; 
		int maxAns = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(mat[i][j]==1 && !visited[i][j]) {
					int ans = DFS(mat, i, j, visited);
					maxAns = Math.max(maxAns, ans);
				}
			}
		}
		return maxAns;
	}

	private static int[] xDir = {-1, 0, 1, 0};
	private static int[] yDir = {0, 1, 0, -1};


	private static int DFS(int[][] mat, int i, int j, boolean[][] visited) {


		if(i<0 || i>=mat.length || j<0 || j>=mat[0].length || visited[i][j]==true) {
			return 0;
		}
		visited[i][j]=true;
		int count = 0 ;

		if(mat[i][j]==0) {
			return 0;
		}else {
//			count=1 ;
			int smallCount =0;
			for(int k=0; k<4; k++) {
				int xStep = i+xDir[k];
				int yStep = j+yDir[k];

				// to add all answer from call we have to add count variable with call answer
				// if add 1 to it it will return only last call answer + 1
				
				smallCount = smallCount + DFS(mat, xStep, yStep, visited);
			
			}
			count = 1+ smallCount;
		}
		return count;
	}	
}