import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15649 {
	
	static int N, M;
	static int[] p;
	static int[] nums;
	static boolean visited[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[M];
		visited	 = new boolean[N];
		p = new int[N];
		
		for (int i = 0; i < N; i++) {
			p[i] = i+1;
		}
		
		dfs(0);
		System.out.println(sb);
	}

	static void dfs(int cnt) {
		if(cnt == M) {
			for (int i : nums) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
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
