import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_15666 {
	
	static int N, M;
	static int[] arr;
	static int[] nums;
	static Set<String> ans;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		nums = new int[M];
		ans = new HashSet<>();
		
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
			StringBuilder temp = new StringBuilder();
			for (int i = 0; i < M; i++) {
				temp.append(nums[i]).append(" ");
			}
			String str = temp.toString();
			if(!ans.contains(str)) {
				ans.add(str);
				sb.append(temp).append("\n");
			}
			return;
		}
		for (int i = start; i < N; i++) {
			nums[cnt] = arr[i];
			dfs(cnt+1, i);
		}
	}

}
