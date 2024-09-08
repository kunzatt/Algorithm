import java.io.*;
import java.util.*;

public class Main_2589 {
	
	static int N, M, max;
	static char[][] map;
	static int[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 'L') {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(max);

	}

	static void bfs(int r, int c) {
		
		visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = -1;
			}
		}
		
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] {r, c});
		visited[r][c] = 0;
		
		while (!que.isEmpty()) {
			int[] temp = que.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = temp[0] + dr[i];
				int nc = temp[1] + dc[i];
				
				if(!check(nr, nc) || visited[nr][nc] != -1 || map[nr][nc] == 'W') continue;
				visited[nr][nc] = visited[temp[0]][temp[1]] + 1;
				que.add(new int[] {nr, nc});
				max = Math.max(max, visited[nr][nc]);
			}
		}
		
	}

	static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

}
