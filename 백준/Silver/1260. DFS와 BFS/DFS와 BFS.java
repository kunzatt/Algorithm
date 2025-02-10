import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, V;
	static boolean[] bvisited;
	static boolean[] dvisited;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		
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
			int	end = Integer.parseInt(st.nextToken());
			map[start][end] = 1;
			map[end][start] = 1;			
		}
		
		dfs(V);
		System.out.println();
		bfs(V);		

	}

	static void dfs(int start) {
		
		dvisited[start] = true;
		System.out.print(start+ " ");
		
		for (int i = 1; i < N+1; i++) {
			if(dvisited[i]) continue;
			if(map[start][i] == 1) {
				dfs(i);
			}
		}
		
	}
	
	static void bfs(int start) {
		
		Queue<Integer> que = new LinkedList<>();
		que.offer(start);
		bvisited[start] = true;
		System.out.print(start + " ");
		
		while(!que.isEmpty()) {
			int temp = que.poll();
			
			for (int i = 1; i < N+1; i++) {
				if(bvisited[i]) continue;
				if(map[temp][i] == 1) {
					que.offer(i);
					bvisited[i] = true;
					System.out.print(i + " ");
				}
			}
			
		}
			
	}

}
