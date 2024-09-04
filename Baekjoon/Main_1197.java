import java.io.*;
import java.util.*;

class Edge {
	
	int v, e, c;

	public Edge(int v, int e, int c) {
		this.v = v;
		this.e = e;
		this.c = c;
	}
	
}

public class Main_1197 {
	
	static int V , E;
	static Edge[] edges;
	static int[] parent;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		edges = new Edge[E];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());	// 노드
			int e = Integer.parseInt(st.nextToken());	// 간선
			int c = Integer.parseInt(st.nextToken());	// 가중치
			
			edges[i] = new Edge(v, e, c);
		}
		
		Arrays.sort(edges, (o1, o2) -> o1.c - o2.c);
		
		// 유니온 파인드에서 make
		parent = new int[V+1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		
		kruskal(edges, parent);

	}


	static void kruskal(Edge[] edgs, int[] parent) {
		
		int cost = 0;
		
		for (int i = 0; i < E; i++) {
			Edge tmp = edges[i];
			if (find(tmp.v) != find(tmp.e)) {	// 같아지면 사이클이 생겨서 크루스칼이 안된다.
				cost += tmp.c;
				union(tmp.v, tmp.e);
			}
		}

		System.out.println(cost);
		
	}

	static void union(int x, int y) {
		
		x = find(x);
		y = find(y);
		
		if (x <= y) parent[y] = x;
		else parent[x] = y;
		
	}

	static int find(int x) {
		
		if (parent[x] == x) return x;
		else return parent[x] = find(parent[x]);
		
	}

}
