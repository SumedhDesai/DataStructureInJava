package othello;

public class OthelloBoard {

	private int[][] board;
	final static int player1Symbol =1;
	final static int player2Symbol =2;

	private int[] xDir = {-1, -1, 0, 1, 1, 1, 0, -1};
	private int[] yDir = {0, 1, 1, 1, 0, -1, -1, -1};

	public OthelloBoard() {
		board = new int[8][8];
		board[3][3]=player1Symbol;
		board[3][4]=player2Symbol;
		board[4][3]=player2Symbol;
		board[4][4]=player1Symbol;
	}

	public void print() {
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	public boolean move(int symbol, int x, int y) {
		if(x<0 || x>=8 || y<0 || y>=8 || board[x][y]!=0) {
			return false;
		}
		boolean movePossible = false;
		for(int i=0; i<xDir.length; i++) {
			int xStep = xDir[i];
			int yStep = yDir[i];
			int currentX = x+xStep;
			int currentY = y+yStep;
			int count = 0;

			while(currentX>=0 && currentX<8 && currentY>=0 && currentY<8) {

				if(board[currentX][currentY]==0) {

					break;

				}else if(board[currentX][currentY]!=symbol) {
					count++;

				}else {

					if(count>0) {

						movePossible=true;
						int convertX = currentX-xStep;
						int convertY = currentY-yStep;	

						while(convertX!=x || convertY!=y) {

							board[convertX][convertY]=symbol;
							count--;
							convertX = convertX-xStep;
							convertY = convertY-yStep;
						}

//							movePossible=true;
//	                        currentX = currentX-xStep;
//	                        currentY = currentY-yStep;	
//
//	                        while(count>0) {
//
//	                            board[currentX][currentY]=symbol;
//	                            count--;
//	                            currentX = currentX-xStep;
//	                            currentY = currentY-yStep;	



					}
					
					break;
				}

				currentX = currentX+xStep;
				currentY = currentY+yStep;

			}
		}
		if(movePossible) {
			board[x][y]=symbol;

		}
		return movePossible;
	}


}
