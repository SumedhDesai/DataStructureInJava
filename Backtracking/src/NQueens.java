/*
 * Code: N Queens

	You are given N, and for a given N x N chessboard, find a way to place 
	N queens such that no queen can attack any other queen on the chess board. 
	A queen can be killed when it lies in the same row, or same column, or 
	the same diagonal of any of the other queens. You have to print all such 
	configurations.
	Input Format :
	Line 1 : Integer N
	Output Format :
	One Line for every board configuration. 
	Every line will have N*N board elements printed row wise and are separated 
	by space
	Note : Don't print anything if there isn't any valid configuration.
	Constraints :
	1<=N<=10
	Sample Input 1:
	4
	Sample Output 1 :
	0 1 0 0 0 0 0 1 1 0 0 0 0 0 1 0 
	0 0 1 0 1 0 0 0 0 0 0 1 0 1 0 0 
 */
import java.util.Scanner;

public class NQueens {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int n = s.nextInt();
		placeNQueens(n);	
	}

	private static void placeNQueens(int n) {
		int board[][] = new int[n][n];
		queensPlacing(board, n , 0);
	}

	private static void queensPlacing(int[][] board, int n, int row) {
		
		if(row == n) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					System.out.print(board[i][j]+" ");
				}
			}
			System.out.println();
			return;
		}

		for(int k=0; k<n; k++) {
			if(isSafe(board, row, k)) {
				board[row][k]=1;
				queensPlacing(board, n, row+1);
				board[row][k]=0;
			}
		}
	}

	private static boolean isSafe(int[][] board, int row, int col) {
		int n=board.length;
		for(int i=row-1, j=col-1; i>=0 && j>=0; i--,j--) {
			if(board[i][j]==1) {
				return false;
			}
		}
//		for(int i=row+1, j=col+1; i<n && j<n; i++,j++) {
//			if(board[i][j]==1) {
//				return false;
//			}
//		}
		for(int i=row-1, j=col+1; i>=0 && j<n; i--,j++) {
			if(board[i][j]==1) {
				return false;
			}
		}
//		for(int i=row+1, j=col-1; i<n && j>=0; i++,j--) {
//			if(board[i][j]==1) {
//				return false;
//			}
//		}
		for(int i=row-1; i>=0; i--) {
			if(board[i][col]==1) {
				return false;
			}
		}
//		for(int i=row+1; i<n; i++) {
//			if(board[i][col]==1) {
//				return false;
//			}
//		}
		return true;
	}

}
