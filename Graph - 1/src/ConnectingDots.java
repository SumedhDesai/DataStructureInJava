/*
 * Connecting Dots
	
	Gary has a board of size NxM. Each cell in the board is a coloured dot. 
	There exist only 26 colours denoted by uppercase Latin characters 
	(i.e. A,B,...,Z). Now Gary is getting bored and wants to play a game. 
	The key of this game is to find a cycle that contain dots of same colour. 
	Formally, we call a sequence of dots d1, d2, ..., dk a cycle if and only 
	if it meets the following condition:
	1. These k dots are different: if i ≠ j then di is different from dj.
	2. k is at least 4.
	3. All dots belong to the same colour.
	4. For all 1 ≤ i ≤ k - 1: di and di + 1 are adjacent. Also, dk and d1 should 
	also be adjacent. Cells x and y are called adjacent if they share an edge.
	Since Gary is colour blind, he wants your help. Your task is to determine if 
	there exists a cycle on the board.
	Input Format :
	The first line of input contains two space separated integers N and M, where N 
	is number of rows and M is the number of columns of the board. 
	Each of the following N lines contain M characters. Please note that characters 
	are not space separated. Each character is an uppercase Latin letter.
	Output Format :
	Print true if there is a cycle in the board, else print false.
	Constraints :
	2 <= N <= 1000
	2 <= M <= 1000
	Time Limit: 1 second
	Sample Input 1:
	3 4
	AAAA
	ABCA
	AAAA
	Sample Output 1:
	true
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ConnectingDots {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static String[] takeInput() throws IOException {
		String[] strNums;
		strNums = br.readLine().split("\\s");

		int N = Integer.parseInt(strNums[0]);
		int M = Integer.parseInt(strNums[1]);

		String[] Graph = new String[N];

		for (int i = 0; i < N; ++i) {
			Graph[i] = br.readLine();
		}

		return Graph;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {


		String[] Graph = takeInput();
		if (solve(Graph,Graph.length,Graph[0].length())==1){
			System.out.print("true");
		}
		else{
			System.out.print("false");
		}


	}

	private static int solve(String[] graph, int N, int M) {

		char[][] mat = new char[N][M];
		for(int i=0; i<N; i++) {
			String str = graph[i];
			for(int j=0; j<M; j++) {
				mat[i][j] = str.charAt(j);
			}
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		boolean[][] visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visited[i][j] == false) {
					int count =0;
					boolean ans = DFS(mat, i, j, i, j, count, visited);
					if(ans) {
						return 1;
					}
				}
			}
		}
		return 0;
	}

	private static int[] xDir = {-1, 0, 1, 0};
	private static int[] yDir = {0, 1, 0, -1};


	private static boolean DFS(char[][] mat, int i, int j, int si, int sj, int count, boolean[][] visited) {
		if(i==si && j==sj && count>=4) {
			return true;
		}
		if(i<0 || i>=mat.length || j<0 || j>=mat[0].length || visited[i][j]==true) {
			return false;
		}
		if(mat[i][j] != mat[si][sj]) {
			return false;
		}
		visited[i][j]=true;
		if(mat[i][j] == mat[si][sj]) {
			count++;
			for(int k=0; k<4; k++) {
				int xStep = i+xDir[k];
				int yStep = j+yDir[k];
				
//				System.out.println(xStep+" "+yStep);

				boolean smallAns = DFS(mat, xStep, yStep, si, sj, count, visited);
				
//				System.out.println(smallAns);
				if(smallAns) {
					return true;
				}
			}
		}
		visited[i][j] = false;
		return false;
	}
}