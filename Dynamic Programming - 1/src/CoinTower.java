/*
 * Coin Tower

	Whis and Beerus are playing a new game today. They form a tower of N 
	coins and make a move in alternate turns. Beerus plays first. 
	In one step, the player can remove either 1, X, or Y coins from the tower. 
	The person to make the last move wins the game. Can you find out who wins 
	the game?
	 Input format :
	The first and the only line of input contains three integer values separated 
	by a single space. They denote the value of N, X and Y, respectively.
	Output format :
	Prints the name of the winner, either 'Whis' or 'Beerus' (Without the quotes).
	Constraints :
	1 <= N <= 10 ^ 6
	2 <= X <= Y<= 50
	
	Time Limit: 1 sec
	Sample Input 1 :
	4 2 3
	Sample Output 1 :
	Whis
	Sample Input 2 :
	10 2 4
	Sample Output 2 :
	Beerus
	Explanation to Sample Input 1:
	Initially, there are 4 coins,  In the first move, Beerus can remove either 1, 2, 
	or 3 coins in all three cases, Whis can win by removing all the remaining coins. 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinTower {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
            String[] strNums = br.readLine().trim().split("\\s");
            int n = Integer.parseInt(strNums[0]);
            int x = Integer.parseInt(strNums[1]);
            int y = Integer.parseInt(strNums[2]);

            System.out.println(findWinner(n, x, y));
    }

	private static String findWinner(int n, int x, int y) {
		boolean[] dp = new boolean[n+1];
//		lets find probability of A winning the game
		
//		when there is no coin A cant pick the coin so A lose
		dp[0]=false;
		
//		when there is only 1 coin A can win by picking 1 coin
		dp[1]=true;
		
		for(int i=2; i<=n; i++) {
			if(i-1>=0 && dp[i-1]==false) {
				dp[i]=true;
			}else if(i-x>=0 && dp[i-x]==false) {
				dp[i]=true;
			}else if(i-y>=0 && dp[i-y]==false) {
				dp[i]=true;
			}else {
				dp[i]=false;
			}
		}
		for(boolean i: dp) {
			System.out.print(i+" ");
		}
		if(dp[n]) {
			return "A";
		}else {
			return "B";
		}
	}
}