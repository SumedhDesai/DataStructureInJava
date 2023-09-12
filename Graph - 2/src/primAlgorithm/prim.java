/*
 * Code : Prim's Algorithm

	Given an undirected, connected and weighted graph G(V, E) with V number 
	of vertices (which are numbered from 0 to V-1) and E number of edges.
	Find and print the Minimum Spanning Tree (MST) using Prim's algorithm.
	For printing MST follow the steps -
	1. In one line, print an edge which is part of MST in the format - 
	v1 v2 w
	where, v1 and v2 are the vertices of the edge which is included in MST 
	and whose weight is w. And v1  <= v2 i.e. print the smaller vertex first 
	while printing an edge.
	2. Print V-1 edges in above format in different lines.
	Note : Order of different edges doesn't matter.
	Input Format :
	Line 1: Two Integers V and E (separated by space)
	Next E lines : Three integers ei, ej and wi, denoting that there exists 
	an edge between vertex ei and vertex ej with weight wi (separated by space)
	Output Format :
	Print the MST, as described in the task.
	Constraints :
	2 <= V, E <= 10^5
	1 <= Wi <= 10^5
	Time Limit: 1 sec
	Sample Input 1 :
	4 4
	0 1 3
	0 3 5
	1 2 1
	2 3 8
	Sample Output 1 :
	0 1 3
	1 2 1
	0 3 5
 */
package primAlgorithm;

import java.util.Scanner;

public class prim {
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int V = s.nextInt();
		int E = s.nextInt();
		
		int[][] edges = new int[V][V];
		for(int i=0; i<E; i++) {

			int x = s.nextInt();
			int y = s.nextInt();
			int weight = s.nextInt();

			edges[x][y]=weight;
			edges[y][x]=weight;

		}
//		for(int i=0; i<V; i++) {
//			for(int j=0; j<V; j++) {
//				System.out.print(edges[i][j]+" ");
//			}
//			System.out.println();
//		}
		primAlgo(edges, V);

	}

	private static void primAlgo(int[][] edges, int n) {
				
		boolean[] visited = new boolean[n];
		int[] parent = new int[n];
		parent[0]=-1;
		
		int[] weight = new int[n];
		for(int i=0; i<n; i++) {
			weight[i]=Integer.MAX_VALUE;
		}
		
		weight[0]=0;
	
		for(int i=0; i<n; i++) {
			
			int minVertex = findMin(visited, weight, n);
//			so we can keep minimum weight edge with us
			visited[minVertex]=true;
			
			for(int j=0; j<n; j++) {
				
				if(edges[minVertex][j]!=0 && visited[j]==false) {
					if(weight[j] > edges[j][minVertex]) {
						parent[j]=minVertex;
						weight[j] = edges[j][minVertex];
						
					}
				}
			}
	
		}
		for(int k=1; k<n; k++) {
			if(parent[k]< k) {
			System.out.println(parent[k]+" "+ k +" "+weight[k]);
			}else {
				System.out.println(k +" "+parent[k]+" "+weight[k]);
			}
		}
	}

	private static int findMin(boolean[] visited, int[] weight, int n) {
		
		int minVertex =-1;
		for(int i=0; i<n; i++) {
			if(!visited[i] && (minVertex==-1 || weight[i]<weight[minVertex]))
//				the secound condition is for for first time minVertex is -1 it will 
//				throw Array index out of bound exception
				minVertex=i;
		}
		return minVertex;
	}
}