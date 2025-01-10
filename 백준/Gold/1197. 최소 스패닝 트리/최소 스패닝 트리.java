import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
	
	int start, end, cost;

	public Edge(int start, int end, int cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}
	
	// cost를 기준으로 정렬해야한다(크루스칼)
	@Override
	public int compareTo(Edge e) {
		return this.cost - e.cost;
	}
}

public class Main {
	
	static int V, E;
	static PriorityQueue<Edge> pq;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		pq = new PriorityQueue<>();
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			pq.add(new Edge(a, b, c));
		}
		
		parent = new int[V+1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		
		kruskal(pq, parent);

	}

	static void kruskal(PriorityQueue<Edge> pq, int[] parent) {
		
		int cost = 0;
		
		while (!pq.isEmpty()) {
			Edge temp = pq.poll();
			if (find(temp.start) != find(temp.end)) {
				cost += temp.cost;
				union(temp.start, temp.end);
			}
		}
		
		System.out.println(cost);
	}

	static int find(int x) {

		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}

	static void union(int x, int y) {
		
		x = find(x);
		y = find(y);
		
		if (x <= y) parent[y] = x;
		else parent[x] = y;
		
	}

}
