import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1260 {
	
	static int N, M, V;
	static int[][] map;
	static boolean[] bvisited;
	static boolean[] dvisited;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		bvisited = new boolean[N+1];
		dvisited = new boolean[N+1];
		map = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			map[start][end] = map[end][start] = 1;		// 이 부분이 이해하기 어려움
		}
		
		dfs(V);
		System.out.println();
		bfs(V);
		
	}

	static void bfs(int start) {
		
		Queue<Integer> que = new LinkedList<>();
		que.offer(start);
		bvisited[start] = true;
		System.out.print(start + " ");
		
		while (!que.isEmpty()) {
			int temp = que.poll();
			
			for (int i = 1; i < N+1; i++) {
				if (bvisited[i]) continue;
				if (map[temp][i] == 1) {
					que.offer(i);
					bvisited[i] = true;
					System.out.print(i + " ");
				}
			}
		}
		
	}

	static void dfs(int start) {
		
		dvisited[start] = true;
		System.out.print(start + " ");
		
		for (int i = 1; i < N+1; i++) {
			if (dvisited[i]) continue;
			if (map[start][i] == 1) dfs(i);
		}
		
	}

}
