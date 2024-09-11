import java.io.*;
import java.util.*;

public class Main_3055 {
	
	static int R, C, ans;
	static char[][] map;
	static int[][] dist;
	static Queue<int[]> que;
	static Queue<int[]> water;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		dist = new int[R][C];
		ans = Integer.MAX_VALUE;
		que = new LinkedList<>();
		water = new LinkedList<>();
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'S') {
					que.add(new int[] {i, j, 0});	// 거리를 나타낼 부분도 배열에 함꼐 넣기 
				}else if (map[i][j] == '*') {
					water.add(new int[] {i, j});
				}
			}
		}
		
		bfs();
		if (ans == Integer.MAX_VALUE) System.out.println("KAKTUS");
		else System.out.println(ans);
		
	}

	static void bfs() {
		
		while (!que.isEmpty()) {
			// 물이 퍼지고 
			int size = water.size();
			for (int i = 0; i < size; i++) {
				int[] temp = water.poll();
				int tr = temp[0];
				int tc = temp[1];
				
				for (int j = 0; j < 4; j++) {
					int nr = tr + dr[j];
					int nc = tc + dc[j];
					
					if (!check(nr, nc) || map[nr][nc] != '.') continue;
					map[nr][nc] = '*';
					water.add(new int[] {nr, nc});
				}
			}
			
			// 고슴도치가 이동하고 
			int gsize = que.size();
			for (int i = 0; i < gsize; i++) {
				int[] temp = que.poll();
				int tr = temp[0];
				int tc = temp[1];
				int time = temp[2];
				
				for (int j = 0; j < 4; j++) {
					int nr = tr + dr[j];
					int nc = tc + dc[j];
					
					if (!check(nr, nc)) continue;
					if (map[nr][nc] == 'D') {
						ans = Math.min(ans, time+1);
						return;
					}else if (map[nr][nc] == '.') {
						map[nr][nc] = 'S';
//						map[tr][tc] = '.';	// 왜 넣으면 안되는거지..? 그러면 그 다음 반복때 다시 탐색하기 때문
						// 이게 싫으면 그냥 visited 배열을 따로 만들자 
						que.add(new int[] {nr, nc, time+1});
					}
				}
			}
		}
		
	}

	static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
    
}