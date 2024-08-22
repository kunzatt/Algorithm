import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15650 {
	
	static int N, M;
	static int[] nums;
	static int[] arr;

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
		dfs(0, 0);
		
	}

	static void dfs(int cnt, int start) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(nums[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < N; i++) {
			nums[cnt] = arr[i];
			dfs(cnt+1, i+1);
			nums[cnt] = 0;
		}
	}

}
