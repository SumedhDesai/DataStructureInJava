/*
 * Code: Rat In a Maze All Paths

	You are given a N*N maze with a rat placed at maze[0][0]. Find and 
	print all paths that rat can follow to reach its destination i.e. 
	maze[N-1][N-1]. Rat can move in any direc�tion ( left, right, up and down).
	Value of every cell in the maze can either be 0 or 1. Cells with value 0 
	are blocked means rat can�not enter into those cells and those with value 1 are open.
	Input Format
	The first line of input contains an integer 'N' representing 
	the dimension of the maze.
	The next N lines of input contain N space-separated 
	integers representing the type of the cell.
	Output Format :
	For each test case, print the path from start position to destination 
	position and only cells that are part of the solution path should be 1, 
	rest all cells should be 0.
	
	Output for every test case will be printed in a separate line.
	Constraints:
	0 < N < 11 0 <= Maze[i][j] <=1
	
	Time Limit: 1sec
	Sample Input 1 :
	3
	1 0 1
	1 0 1
	1 1 1
	Sample Output 1 :
	1 0 0 1 0 0 1 1 1 
	Sample Output 1 Explanation :
	Only 1 path is possible
	
	1 0 0
	1 0 0
	1 1 1
	Which is printed from left to right and then top to bottom in one line.
	
	Sample Input 2 :
	3
	1 0 1
	1 1 1
	1 1 1
	Sample Output 2 :
	1 0 0 1 1 1 1 1 1 
	1 0 0 1 0 0 1 1 1 
	1 0 0 1 1 0 0 1 1 
	1 0 0 1 1 1 0 0 1 
	Sample Output 2 Explanation :
	4 paths are possible which are printed in the required format.
 */
import java.io.*;
import java.util.*;

public class RatInMazeAllPaths {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		int[][] maze = new int[20][20];
		for (int i = 0; i < n; i++)
		{
			StringTokenizer tk = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n; j++)
			{
				maze[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		ratInAMaze(maze, n);
	}

	private static void printSolution(int[][] path, int n) {
		for(int i=0; i<n; i++) {

			for(int j=0; j<n; j++) {

				System.out.print(path[i][j]+" ");
			}
		}	
	}

	private static void printAllPath(int[][] maze, int[][] path, int i, int j, int n) {

		if(i<0 || i>=n || j<0 || j>=n || maze[i][j]==0 || path[i][j]==1) {
			return;
		} 
		
		if(i == n-1 && j == n-1) {
			path[i][j]=1;
			printSolution(path, n);
			System.out.println();
			path[i][j]=0;
			return;
		}
		
		path[i][j] = 1;
		printAllPath(maze,path, i-1, j, n);
		printAllPath(maze,path, i, j+1,n );
		printAllPath(maze,path, i+1, j,n );
		printAllPath(maze,path, i, j-1,n );
		path[i][j]=0;
	}

	public static void ratInAMaze(int[][] maze, int n) {

		int[][] path = new int[n][n];
		printAllPath(maze, path, 0, 0, n);
	}
}