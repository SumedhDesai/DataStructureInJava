/*
 * Print vertices by DF & BF
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Traversal {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {

		int [][] input = takeInput();
		if(input.length==0) {

			return;

		}

		printDepthFirst(input);
		System.out.println();
		printBreadthFirst(input);

	}

	//	time complexity is O(n^2)
	private static void printBreadthFirst(int[][] input) {

		boolean[] visited = new boolean[input.length];
		Queue<Integer> pending = new LinkedList<>();

		//		to print disconnected vertices we use this for loop.

		for(int i=0; i<visited.length; i++) {

			if(!visited[i]) {

				pending.add(i);
				visited[i] = true;

				while(!pending.isEmpty()) {

					int vertex = pending.poll();
					System.out.print(vertex + " ");

					for(int j=0; j<input.length; j++) {

						if(visited[j]==false && input[vertex][j]==1) {

							pending.add(j);
							visited[j] = true;

						}
					}
				}
			}
		}
	}

	//	time complexity is O(n^2)
	private static void printDepthFirst(int[][] adj) {

		boolean[] visited = new boolean[adj.length];
		for(int i=0; i<visited.length; i++) {
			if(visited[i]==false) {
				printDepthFirstHelper(adj, i, visited);
			}
		}
	}

	private static void printDepthFirstHelper(int[][] adj, int currentVertex, boolean[] visited) {

		visited[currentVertex] = true;
		System.out.print(currentVertex+" ");

		for(int i=0; i<adj.length; i++) {
			if(visited[i]==false && adj[currentVertex][i]==1) {
				printDepthFirstHelper(adj, i, visited);
			}
		}
	}

	private static int[][] takeInput() {

		int n = s.nextInt();

		if(n==0) {
			return new int[0][0];
		}
		int e = s.nextInt();
		int[][] adj = new int[n][n];

		for(int i=0; i<e; i++) {

			int x = s.nextInt();
			int y = s.nextInt();
			adj[x][y] = 1;
			adj[y][x] = 1;

		}

		return adj;

	}
}
