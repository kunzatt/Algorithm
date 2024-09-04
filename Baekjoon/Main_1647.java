import java.io.*;
import java.util.*;

public class Main_1647 {
	
	static int N, M;
	static class Node implements Comparable<Node>{
		int start;
		int end;
		int cost;
		
		public Node(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node n) {
			return this.cost - n.cost;
		}
	}
	static int[] parent;
	static PriorityQueue<Node> pque;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		pque = new PriorityQueue<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			pque.add(new Node(a, b, c));
		}
		
		parent = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		kruskal();

	}

	static void kruskal() {
		
		int cost = 0;
		int max = 0;
		
		for (int i = 0; i < M; i++) {
			Node temp = pque.poll();
			if (find(temp.start) != find(temp.end)) {
				cost += temp.cost;
				union(temp.start, temp.end);
				max = temp.cost;
			}
		}
		
		System.out.println(cost - max);
		
	}

	static void union(int x, int y) {
		
		x = find(x);
		y = find(y);
		
		if (x < y) parent[y] = x;
		else if (y < x) parent[x] = y;
		
	}

	static int find(int x) {
		
		if (parent[x] == x) return x;
		return find(parent[x]);
	}

}
