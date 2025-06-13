import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] p, nums;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		p = new int[N];
		
		for (int i = 0; i < N; i++) {
			p[i] = i + 1;
		}
		
		nums = new int[N];
		visited = new boolean [N];
		dfs(0);
		
	}

	static void dfs(int cnt) {
		
		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			nums[cnt] = p[i];
			dfs(cnt+1);
			visited[i] = false;
		}
		
	}

}
