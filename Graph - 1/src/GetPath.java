/*
 * Get Path

 	Given an undirected graph G(V, E) and two vertices v1 and v2(as integers), find 
 	and print the path from v1 to v2 (if exists). Print nothing if there is no path 
 	between v1 and v2.
	Find the path using DFS & BFS and print the first path that you encountered.
	Note:
	1. V is the number of vertices present in graph G and vertices are numbered from 
	0 to V-1. 
	2. E is the number of edges present in graph G.
	3. Print the path in reverse order. That is, print v2 first, then intermediate 
	vertices and v1 at last.
	4. Save the input graph in Adjacency Matrix.
	Input Format :
	The first line of input contains two integers, that denote the value of V and E.
	Each of the following E lines contains two integers, that denote that there exists 
	an edge between vertex 'a' and 'b'.
	The following line contain two integers, that denote the value of v1 and v2.
	Output Format :
	Print the path from v1 to v2 in reverse order.
	Constraints :
	2 <= V <= 1000
	1 <= E <= (V * (V - 1)) / 2
	0 <= a <= V - 1
	0 <= b <= V - 1
	0 <= v1 <= 2^31 - 1
	0 <= v2 <= 2^31 - 1
	Time Limit: 1 second
	Sample Input 1 :
	4 4
	0 1
	0 3
	1 2
	2 3
	1 3
	Sample Output 1 :
	3 0 1
	Sample Input 2 :
	6 3
	5 3
	0 1
	3 4
	0 3
	Sample Output 2 :

 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;
import java.io.IOException;

public class GetPath {

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
		ArrayList<Integer> ans1 = getPathByDepth(adj,a, b, visited1);
		if(ans1 == null) {
			return;
		}
		for(int i=0; i<ans1.size(); i++) {
			System.out.print(ans1.get(i)+" ");
		}

		boolean[] visited2 = new boolean[n];
		ArrayList<Integer> ans2 = getPathByBreadth(adj,a, b, visited2);
		if(ans2 == null) {
			return;
		}
		for(int i=0; i<ans2.size(); i++) {
			System.out.print(ans2.get(i)+" ");
		}

	}

	private static ArrayList<Integer> getPathByBreadth(int[][] adj, int s, int d, boolean[] visited2) {

		Queue<Integer> pending = new LinkedList<Integer>();
		HashMap<Integer, Integer> childParentMap = new HashMap<>();
		pending.add(s);
		visited2[s]=true;
		childParentMap.put(s, -1);
		ArrayList<Integer> ans = new ArrayList<Integer>();

		boolean pathFound = false;

		while(!pending.isEmpty()) {
			int currentVertex = pending.poll();

			for(int i=0; i<adj.length; i++) {
				if(visited2[i]==false && adj[currentVertex][i]==1) {
					pending.add(i);
					visited2[i]=true;
					childParentMap.put(i, currentVertex);

					if(i==d) {
						pathFound=true;
						break;
					}
				}
				if(pathFound) {
					break;
				}
			}
		}
		if(pathFound) {
			int currentVertex = d;
			while(currentVertex!=-1) {
				ans.add(currentVertex);
				currentVertex = childParentMap.get(currentVertex);
			}
			return ans;
		}else {
			return null;
		}
	}

	private static ArrayList<Integer> getPathByDepth(int[][] adj, int s, int d, boolean[] visited1) {
		visited1[s]=true;

		if(s==d) {
			ArrayList<Integer> ans = new ArrayList<>();
			ans.add(s);
			return ans;
		}
		for(int i=0; i<adj.length; i++) {
			if(visited1[i]==false && adj[s][i]==1) {
				ArrayList<Integer> smallAns = getPathByDepth(adj, i, d, visited1);
				if(smallAns!=null) {
					smallAns.add(s);
					return smallAns;
				}
			}
		}
		return null;
	}

}