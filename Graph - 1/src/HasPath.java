/*
 * Has Path?

	Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers), check 
	if there exists any path between them or not. Print true if the path exists and 
	false otherwise.
	Note:
	1. V is the number of vertices present in graph G and vertices are numbered from 0 
	to V-1. 
	2. E is the number of edges present in graph G.
	Input Format :
	The first line of input contains two integers, that denote the value of V and E.
	Each of the following E lines contains two integers, that denote that there exists an 
	edge between vertex 'a' and 'b'.
	The following line contain two integers, that denote the value of v1 and v2.
	Output Format :
	The first and only line of output contains true, if there is a path between v1 and 
	v2 and false otherwise.
	Constraints :
	0 <= V <= 1000
	0 <= E <= 1000
	0 <= a <= V - 1
	0 <= b <= V - 1
	0 <= v1 <= V - 1
	0 <= v2 <= V - 1
	Time Limit: 1 second
	Sample Input 1 :
	4 4
	0 1
	0 3
	1 2
	2 3
	1 3
	Sample Output 1 :
	true
	Sample Input 2 :
	6 3
	5 3
	0 1
	3 4
	0 3
	Sample Output 2 :
	false
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.IOException;

public class HasPath {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) throws NumberFormatException, IOException {

		int n = s.nextInt();
		if(n==0) {
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
		int a = s.nextInt();
		int b = s.nextInt();
		boolean[] visited1 = new boolean[n];
		boolean ans1 = hasPathByDepth(adj,a, b, visited1);
		System.out.println(ans1);

		boolean[] visited2 = new boolean[n];
		boolean ans2 = hasPathByBreadth(adj,a, b, visited2);
		System.out.println(ans2);
	}

	private static boolean hasPathByBreadth(int[][] adj, int a, int b, boolean[] visited) {

		Queue<Integer> pending = new LinkedList<Integer>();
		pending.add(a);
		visited[a]=true;
		while(!pending.isEmpty()) {
			int x = pending.poll();

			for(int i=0; i<adj.length; i++) {
				if(visited[i]==false && adj[x][i]==1) {
					if(i == b) {
						return true;
					}else {
						pending.add(i);
						visited[i]=true;
					}
				}
			}
		}
		return false;
	}

	private static boolean hasPathByDepth(int[][] adj, int a, int b, boolean[] visited) {
		visited[a]=true;
		if(a == b) {
			return true;
		}

		for(int i=0; i<adj.length; i++) {
			if(visited[i]==false && adj[a][i]==1) {
				boolean smallAns = hasPathByDepth(adj, i , b, visited);
				if(smallAns) {
					return true;
				}
			}
		}
		return false;

	}

}