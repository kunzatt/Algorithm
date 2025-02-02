import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[][] map, ans;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		ans = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(0, 0);
		
		System.out.println(ans[N-1][M-1]);

	}

	static void bfs(int r, int c) {
		
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] {r, c});
		ans[r][c] = 1;
		
		while (!que.isEmpty()) {
			int[] temp = que.poll();
			int tr = temp[0];
			int tc = temp[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = tr + dr[d];
				int nc = tc + dc[d];
				
				if (!check(nr, nc) || ans[nr][nc] != 0 || map[nr][nc] != 1) continue;
				ans[nr][nc] = ans[tr][tc] + 1;
				que.add(new int[] {nr, nc});
			}
		}
		
	}

	static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

}
