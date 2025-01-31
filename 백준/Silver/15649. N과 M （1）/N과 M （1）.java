import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] p;
	static int[] nums;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		p = new int[N];
		nums = new int[M];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			p[i] = i+1;
		}
		dfs(0);

	}

	static void dfs(int cnt) {
		
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			nums[cnt] = p[i];
			dfs(cnt+1);
			visited[i] = false;
		}
		
	}

}
