import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_7102 {
	
	static int T;
	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N+M+1];
			System.out.print("#" + t + " ");
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					arr[i+j]++;
				}
			}
			int max = -1;
			for (int i = 0; i < N+M+1; i++) {
				if(max < arr[i]) {
					max = arr[i];
				}				
			}
			for (int i = 0; i < N+M+1; i++) {
				if(arr[i] == max) {
					System.out.print(i + " ");
				}
			}
			System.out.println();
		}
	}
}
