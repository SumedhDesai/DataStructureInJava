package kruskalAlgorithm;

public class Edge implements Comparable<Edge> {

	public int v1;
	public int v2;
	public int weight;

	public Edge(int v1, int v2, int weight) {
		this.v1=v1;
		this.v2=v2;
		this.weight=weight;
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}
}
