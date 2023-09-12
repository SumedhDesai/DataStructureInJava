/*
 * Dijkstra's Algorithm

	Given an undirected, connected and weighted graph G(V, E) with V 
	number of vertices (which are numbered from 0 to V-1) and E number 
	of edges.
	Find and print the shortest distance from the source vertex (i.e. Vertex 0) 
	to all other vertices (including source vertex also) using Dijkstra's 
	Algorithm.
	Input Format :
	Line 1: Two Integers V and E (separated by space)
	Next E lines : Three integers ei, ej and wi, denoting that there exists 
	an edge between vertex ei and vertex ej with weight wi (separated by space)
	Output Format :
	For each vertex, print its vertex number and its distance from source, 
	in a separate line. The vertex number and its distance needs to be 
	separated by a single space.
	Note : Order of vertices in output doesn't matter.
	Constraints :
	2 <= V, E <= 10^5
	Time Limit: 1 sec
	Sample Input 1 :
	4 4
	0 1 3
	0 3 5
	1 2 1
	2 3 8
	Sample Output 1 :
	0 0
	1 3
	2 4
	3 5
 */
package dijkstraAlgorithm;

import java.util.Scanner;

public class dijkstra {
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int V = s.nextInt();
		int E = s.nextInt();
		
		int[][] adj = new int[V][V];
		
		for(int i=0; i<E; i++) {
			int x = s.nextInt();
			int y = s.nextInt();
			int weight = s.nextInt();
			
			adj[x][y] = weight;
			adj[y][x] = weight;
		}
		dijkstraAlgorithm(adj, V);
	}

	private static void dijkstraAlgorithm(int[][] adj, int n) {
		
		boolean[] visited = new boolean[n];
		
		int[] weight = new int[n];
		for(int i=0; i<n; i++) {
			weight[i]=Integer.MAX_VALUE;
		}
		weight[0]=0;
		
		for(int i=0; i<n; i++) {
			int minVertex = findMin(visited, weight, n);
			visited[minVertex] = true;
			
			for(int j=0; j<n; j++) {
				if(visited[j]==false && adj[minVertex][j]!=0) {
					if(weight[j] > (weight[minVertex]+adj[j][minVertex])) {
						weight[j]=weight[minVertex]+adj[j][minVertex];
					}
				}
			}
			
		}
		
		for(int k=0; k<n; k++) {
			System.out.println(k+" "+weight[k]);
		}
	}

	private static int findMin(boolean[] visited, int[] weight, int n) {
		
		int minVertex = -1;
		for(int i=0; i<n; i++) {
			if(visited[i]==false && (minVertex==-1 || weight[minVertex]>weight[i])) {
				minVertex=i;
			}
		}
		return minVertex;
	}
}