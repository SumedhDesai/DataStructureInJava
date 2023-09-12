/*
 * Rat In A Maze

	You are given a N*N maze with a rat placed at maze[0][0]. Find whether 
	any path exist that rat can follow to reach its destination i.e. 
	maze[N-1][N-1]. Rat can move in any direc­tion ( left, right, up and down).
	Value of every cell in the maze can either be 0 or 1. Cells with value 0 
	are blocked means rat can­not enter into those cells and those with value 
	1 are open.
	Input Format
	Line 1: Integer N
	Next N Lines: Each line will contain ith row elements (separated by space)
	Output Format :
	The output line contains true if any path exists for the rat to reach its 
	destination otherwise print false.
	Sample Input 1 :
	3
	1 0 1
	1 0 1
	1 1 1
	Sample Output 1 :
	true
	Sample Input 2 :
	3
	1 0 1
	1 0 1
	0 1 1
	Sample Output 2 :
	 false
 */
import java.util.Scanner;

public class RatInAMaze {
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int n = s.nextInt();
		int maze[][] = new int[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				maze[i][j] = s.nextInt();
			}
		}
		System.out.println(ratInAMaze(maze));	
	}
	private static boolean ratInAMaze(int[][] maze) {
		int n = maze.length;
		int[][] path = new int[n][n];
		return solveMaze(maze, 0, 0, path);
	}

	private static boolean solveMaze(int[][] maze, int i, int j, int[][] path) {
		int n = maze.length;
		if(i == n-1 && j == n-1) {
			return true;
		}
//      checking valid cell
		if(i<0 || i>=n || j<0 || j>=n || maze[i][j]==0 || path[i][j]==1) {
			return false;
		}
//		add path 
		path[i][j] = 1;
//		reach destination
		
//		search top
		if(solveMaze(maze, i-1, j, path)) {
			return true;
		}
//		search right
		if(solveMaze(maze, i, j+1, path)) {
			return true;
		}
//		search down
		if(solveMaze(maze, i+1, j, path)) {
			return true;
		}
//		search left
		if(solveMaze(maze, i, j-1, path)) {
			return true;
		}
		return false;
	}

}
