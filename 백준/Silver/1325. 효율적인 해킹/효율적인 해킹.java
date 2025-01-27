import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] graph;
	static int N, M;
	static int[] count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		count = new int[N + 1];

		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[b].add(a);
		}

		for(int i = 1; i <= N; i++) {
			bfs(i);
		}

		int max = 0;
		for(int i = 1; i <= N; i++) {
			max = Math.max(max, count[i]);
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			if(count[i] == max) {
				sb.append(i).append(" ");
			}
		}

		System.out.println(sb);
	}

	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];

		q.offer(start);
		visited[start] = true;
		int cnt = 1;

		while(!q.isEmpty()) {
			int cur = q.poll();

			for(int next : graph[cur]) {
				if(!visited[next]) {
					visited[next] = true;
					q.offer(next);
					cnt++;
				}
			}
		}
		count[start] = cnt;
	}
}