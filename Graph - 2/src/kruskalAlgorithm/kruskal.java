/*
 * Kruskal's Algorithm

	Given an undirected, connected and weighted graph G(V, E) with V number 
	of vertices (which are numbered from 0 to V-1) and E number of edges.
	Find and print the Minimum Spanning Tree (MST) using Kruskal's algorithm.
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
	Next E lines : Three integers ei, ej and wi, denoting that there exists an 
	edge between vertex ei and vertex ej with weight wi (separated by space)
	Output Format :
	Print the MST, as described in the task.
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
	1 2 1
	0 1 3
	0 3 5
 */
package kruskalAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class kruskal {
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int V = s.nextInt();
		int E = s.nextInt();

		Edge[] edges = new Edge[E];
		for(int i=0; i<E; i++) {

			int v1 = s.nextInt();
			int v2 = s.nextInt();
			int weight = s.nextInt();

			Edge e = new Edge(v1, v2, weight);
			edges[i]=e;

		}
		
		Edge[] mst = kruskalAlgorithm(edges, V);
		for(int i=0; i<mst.length; i++) {
			Edge curr = mst[i];
			if(curr.v1<curr.v2) {
				System.out.println(curr.v1+" "+curr.v2+" "+ curr.weight);
			}else {
				System.out.println(curr.v2+" "+curr.v1+" "+ curr.weight);
			}
		}
	}

	private static Edge[] kruskalAlgorithm(Edge[] edges, int n) {
		
		Arrays.sort(edges);
		
		int[] parent = new int[n];
		for(int p=0; p<n; p++) {
			parent[p]=p;
		}
		int count = 0;
		int i=0;
		
		Edge[] mst = new Edge[n-1];
		while(count!=n-1) {
			Edge curr = edges[i];
			int parentV1 = findParent(curr.v1, parent);
			int parentV2 = findParent(curr.v2, parent);
			if(parentV1 != parentV2) {
				mst[count]=curr;
				count++;
				parent[parentV1]=parentV2;
			}
			i++;
		}
		return mst;
	}

	private static int findParent(int v, int[] parent) {
		if(parent[v]==v) {
			return v;
		}
		
		return findParent(parent[v], parent);
	}
}
