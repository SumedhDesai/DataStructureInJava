/*
Coding Ninjas

	Given a NxM matrix containing Uppercase English Alphabets only. Your task is 
	to tell if there is a path in the given matrix which makes the sentence “CODINGNINJA” .
	There is a path from any cell to all its neighbouring cells. For a particular cell, 
	neighbouring cells are those cells that share an edge or a corner with the cell.
	Input Format :
	The first line of input contains two space separated integers N and M, where N is 
	number of rows and M is the number of columns in the matrix. 
	Each of the following N lines contain M characters. Please note that characters 
	are not space separated.
	Output Format :
	Print 1 if there is a path which makes the sentence “CODINGNINJA” else print 0.
	Constraints :
	1 <= N <= 1000
	1 <= M <= 1000
	Time Limit: 1 second
	Sample Input 1:
	2 11
	CXDXNXNXNXA
	XOXIXGXIXJX
	Sample Output 1:
	1
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class CodingNinjas {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static String[] takeInput() throws IOException {
		String[] strNums;
		strNums = br.readLine().split("\\s");
		int size = 2;
		int[] input = new int[size];
		for (int i = 0; i < size; ++i) {
			input[i] = Integer.parseInt(strNums[i]);
		}


		String[] Graph = new String[input[0]];

		for (int i = 0; i < input[0]; ++i) {
			Graph[i] = br.readLine();
		}

		return Graph;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {


		String[] Graph = takeInput();
		System.out.println(solve(Graph,Graph.length,Graph[0].length()));


	}

	public static int solve(String[] graph, int N, int M) {
		
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
		boolean isPossible = false;
		String toFind ="CODINGNINJA";
		boolean[][] visited = new boolean[N][M];

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(mat[i][j]=='C') {
					isPossible = find(mat, i, j, toFind, visited);
					if(isPossible) {
						return 1;
					}
				}
			}
		}
		return 0;
	}
	
	private static int[] xDir = {-1, -1, 0, 1, 1, 1, 0, -1};
	private static int[] yDir = {0, 1, 1, 1, 0, -1, -1, -1};

	private static boolean find(char[][] mat, int i, int j, String toFind, boolean[][] visited) {
		if(toFind.length()==0) {
			return true;
		}
		if(i<0 || i>=mat.length || j<0 || j>=mat[0].length || visited[i][j]==true) {
			return false;
		}
		
		if(mat[i][j] != toFind.charAt(0)) {
			return false;
		}
		visited[i][j]=true;
		for(int k=0; k<8; k++) {
			int xStep = i+xDir[k];
			int yStep = j+yDir[k];
			System.out.println(i+xStep+" "+yStep);
			System.out.println(toFind.substring(1));
			boolean ans = find(mat, xStep, yStep, toFind.substring(1), visited);
			System.out.println(ans);
			if(ans) {
				return true;
			}
		}
		visited[i][j]=false;
		return false;
	}
}