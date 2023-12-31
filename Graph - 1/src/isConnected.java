/*
 * isConnected?
 
	Given an undirected graph G(V,E), check if the graph G is connected 
	graph or not.
	Note:
	1. V is the number of vertices present in graph G and vertices are 
	numbered from 0 to V-1. 
	2. E is the number of edges present in graph G.
	Input Format :
	The first line of input contains two integers, that denote the value 
	of V and E.
	Each of the following E lines contains two integers, that denote that 
	there exists an edge between vertex a and b.
	Output Format :
	The first and only line of output contains "true" if the given graph 
	is connected or "false", otherwise.
	Constraints :
	0 <= V <= 1000
	0 <= E <= (V * (V - 1)) / 2
	0 <= a <= V - 1
	0 <= b <= V - 1
	Time Limit: 1 second
	Sample Input 1:
	4 4
	0 1
	0 3
	1 2
	2 3
	Sample Output 1:
	true
	Sample Input 2:
	4 3
	0 1
	1 3 
	0 3
	Sample Output 2:
	false 
	Sample Output 2 Explanation
	The graph is not connected, even though vertices 0,1 and 3 are connected 
	to each other but there isn�t any path from vertices 0,1,3 to vertex 2. 
 */
import java.util.Scanner;
import java.io.IOException;

public class isConnected {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = s.nextInt();
		if(n==0) {
			System.out.println(true);
			return;
		}
		int[][] adj = new int[n][n];

		int e = s.nextInt();
		for(int i=0; i<e; i++) {
			int x = s.nextInt();
			int y = s.nextInt();
			adj[x][y]=1;
			adj[y][x]=1;
		}
		boolean[] visited = new boolean[n];
		DepthFirstTravel(adj, 0, visited);
		for(boolean conected : visited) {
			if(conected==false) {
				System.out.println(false);
				return;
			}
		}
		System.out.println(true);
	}

	private static void DepthFirstTravel(int[][] adj, int currentV, boolean[] visited) {
		visited[currentV] = true;
		
		for(int i=0; i<adj.length; i++) {
			if(visited[i]==false && adj[currentV][i]==1) {
				DepthFirstTravel(adj, i, visited);
			}
		}

	}
}