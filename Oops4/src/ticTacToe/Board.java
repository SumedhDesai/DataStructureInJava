package ticTacToe;

public class Board {
	private char P1Symbol;
	private char P2Symbol;
	private int boardSize = 3;
	private int count;
	private char[][] board = new char[boardSize][boardSize];
	public static final int PLAYER1WINS = 1;
	public static final int PLAYER2WINS = 2;
	public static final int DROW = 3;
	public static final int INVALIDMOVE = 4;
	public static final int INCOMPLETE = 5;
	public static final char EMPTY = ' ';


	public Board(char P1, char P2) {
		this.P1Symbol=P1;
		this.P2Symbol=P2;
		for(int i=0; i<boardSize; i++) {
			for(int j=0; j<boardSize; j++) {
				board[i][j]=EMPTY;
			}
		}

	}

	public int move(char symbol, int x, int y) {
		if( x<0 || x>=boardSize || y<0 || y>=boardSize || board[x][y]!=EMPTY) {
			return INVALIDMOVE;
		}

		board[x][y] = symbol;
		count++;
		if(board[x][0]==board[x][1] && board[x][0]==board[x][2]) {
			return P1Symbol == symbol ? PLAYER1WINS : PLAYER2WINS;
		}

		if(board[0][y]==board[1][y] && board[0][y]==board[2][y]) {
			return P1Symbol == symbol ? PLAYER1WINS : PLAYER2WINS;
		}
		if(board[0][0]!=EMPTY && board[0][0]==board[1][1] && board[0][0]==board[2][2]) {
			return P1Symbol == symbol ? PLAYER1WINS : PLAYER2WINS;
		}
		if(board[2][0]!=EMPTY && board[2][0]==board[1][1] && board[2][0]==board[0][2]) {
			return P1Symbol == symbol ? PLAYER1WINS : PLAYER2WINS;
		}
		if(count == boardSize*boardSize) {
			return DROW; 
		}
		return INCOMPLETE;
	}



	public void print() {
		System.out.println("------------------");
		for(int i=0; i<boardSize; i++) {
			for(int j=0; j<boardSize; j++) {
				System.out.print("| "+board[i][j]+" |");
			}
			System.out.println();
		}
		System.out.println("------------------");
	}

}
