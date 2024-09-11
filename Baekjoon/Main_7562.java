import java.io.*;
import java.util.*;

public class Main_7562 {
	
	static int T, N;
	static int[][] map, dist;
	static boolean[][] visited;
	static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			dist = new int[N][N];
			visited = new boolean[N][N];
			
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			
			dist[r1][c1] = 0;
			bfs(r1, c1);
			System.out.println(dist[r2][c2]);			
			
		}

	}

	static void bfs(int r, int c) {

		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {r, c});
		visited[r][c] = true;
		
		while (!que.isEmpty()) {
			int[] temp = que.poll();
			int tr = temp[0];
			int tc = temp[1];
			
			for (int i = 0; i < 8; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if (!check(nr, nc) || visited[nr][nc]) continue;
				visited[nr][nc] = true;
				dist[nr][nc] = dist[tr][tc] + 1;
				que.add(new int[] {nr, nc});
			}
		}
		
	}

	static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

}
