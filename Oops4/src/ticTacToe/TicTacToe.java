/*
 * TicTacToe
 */
package ticTacToe;

import java.util.Scanner;

public class TicTacToe {

	private Player P1;
	private Player P2;
	private int numPlayer;
	private Board board;


	public static void main(String[] args) {
		TicTacToe t = new TicTacToe();
		t.startGame();
	}

	private void startGame() {
//		taking Input
		Scanner s = new Scanner(System.in);

		P1=takeInput(++numPlayer);	
		P2=takeInput(++numPlayer);

		while(P1.getSymbol() == P2.getSymbol()) {
			System.out.println("Symbol already taken please enter another symbol");
			P2.setSymbol(s.next().charAt(0));
		}
		System.out.println("OK");

//		creating board
		board = new Board(P1.getSymbol(), P2.getSymbol());

//		playing game
		boolean player1Turn = true;
		int status = Board.INCOMPLETE;
		while(status ==Board.INCOMPLETE || status == board.INVALIDMOVE) {
			if(player1Turn) {
				System.out.println("Plaer 1 - " + P1.getName() +"'s turn");
				System.out.println("Enter x & y");
				int x = s.nextInt();
				int y = s.nextInt();

				status = board.move(P1.getSymbol(),x,y);

				while(status == Board.INVALIDMOVE) {
					System.out.println("Invalid move !! please try again");
					System.out.println("Enter x & y");
					x = s.nextInt();
					y = s.nextInt();
					status = board.move(P1.getSymbol(),x,y);

				}

			}else {
				System.out.println("Plaer 2 - " + P2.getName() +"'s turn");
				System.out.println("Enter x & y");
				int x = s.nextInt();
				int y = s.nextInt();

				status = board.move(P2.getSymbol(),x,y);

				while(status == Board.INVALIDMOVE) {
					System.out.println("Invalid move !! please try again");
					System.out.println("Enter x & y");
					x = s.nextInt();	
					y = s.nextInt();
					status = board.move(P2.getSymbol(),x,y);

				}
			}
			player1Turn = !player1Turn;
			board.print();
		}

		if(status == board.PLAYER1WINS) {
			System.out.println(P1.getName()+" wins");
		}
		if(status == board.PLAYER2WINS) {
			System.out.println(P2.getName()+" wins");
		}
		if(status == board.DROW) {
			System.out.println("Match is drow");
		}

	}

	private Player takeInput(int num) {

		Scanner s = new Scanner(System.in);

		System.out.println("Enter player "+ num +"'s Name" );
		String name = s.nextLine();
		System.out.println("Enter player "+ num +"'s symbol" );
		char symbol = s.next().charAt(0);
		Player P = new Player(name, symbol);
		return P;
	}
}
