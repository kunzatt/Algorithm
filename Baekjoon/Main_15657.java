import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15657 {
	
	static int N, M;
	static int[] arr;
	static int[] nums;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		nums = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		dfs(0, 0);
		System.out.println(sb);

	}

	static void dfs(int cnt, int start) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(nums[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < N; i++) {
			nums[cnt] = arr[i];
			dfs(cnt+1, i);
		}
	}

}
