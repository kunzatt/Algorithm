import java.io.*;
import java.util.*;

public class Main_15686 {
	
	static int N, M, ans;
	static int[][] map;
	static ArrayList<Point> chicken;
	static ArrayList<Point> home;
	static boolean[] visited;
	static class Point {
		int r;
		int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		ans = Integer.MAX_VALUE;
		chicken = new ArrayList<>();
		home = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 1) {
					home.add(new Point(i, j));
				}else if (map[i][j] == 2) {
					chicken.add(new Point(i, j));
				}
			}
		}
		
		visited = new boolean[chicken.size()];
		dfs(0, 0);
		
		System.out.println(ans);

	}

	static void dfs(int start, int cnt) {
		
		if (cnt == M) {
            int result = 0;
 
            for (int i = 0; i < home.size(); i++) {
                int temp = Integer.MAX_VALUE;
 
                for (int j = 0; j < chicken.size(); j++) {
                    if (visited[j]) {
                        int cd = Math.abs(home.get(i).r - chicken.get(j).r) + Math.abs(home.get(i).c - chicken.get(j).c);
                        temp = Math.min(temp, cd);
                    }
                }
                result += temp;
            }
            ans = Math.min(ans, result);
            return;
        }
		
		for (int i = start; i < chicken.size(); i++) {
			visited[i] = true;
			dfs(i+1, cnt+1);
			visited[i] = false;
		}
		
		
		
	}

}
