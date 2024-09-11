import java.io.*;
import java.util.*;

public class Main_2206 {
	
	static int N, M, ans;
	static int[][] map, dist;
	static boolean[][][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dist = new int[N][M];
		visited = new boolean[N][M][2];
		ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(0, 0, 1, 0);
		if (ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);

	}

	static void bfs(int r, int c, int count, int k) {
		
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {r, c, 1, 0});
		visited[r][c][0] = true;
		
		while (!que.isEmpty()) {
			int[] temp = que.poll();
			int tr = temp[0];
			int tc = temp[1];
			int tcount = temp[2];
			int tk = temp[3];
			
			if (tr == N - 1 && tc == M - 1) ans = Math.min(ans, tcount);
			
			for (int i = 0; i < 4; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if (!check(nr, nc) || visited[nr][nc][tk]) continue;
				if (map[nr][nc] == 0) {
					visited[nr][nc][tk] = true;
					que.add(new int[] {nr, nc, tcount + 1, tk});
				}else if (map[nr][nc] == 1 && tk == 0) {
					visited[nr][nc][tk] = true;
					que.add(new int[] {nr, nc, tcount + 1, tk + 1});
				}
			}
		}
		
	}
	
	static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

}
