import java.io.*;
import java.util.*;

public class Main_15651 {
	
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
		for (int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		dfs(0);
		System.out.println(sb);
		
	}

	static void dfs(int cnt) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(nums[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			nums[cnt] = arr[i];
			dfs(cnt+1);
		}
	}

}
