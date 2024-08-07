import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_7102_준홍이의카드놀이_D3 {
	
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
			arr = new int[N+M+1];		// N과M을 더한 값을 인덱스로 가지는 배열을 생성
			System.out.print("#" + t + " ");
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					arr[i+j]++;		// i+j 의 인덱스를 가진 값을 1씩 증가
				}
			}
			int max = -1;
			for (int i = 0; i < N+M+1; i++) {
				if(max < arr[i]) {
					max = arr[i];		// 배열의 최댓값을 구한다.
				}				
			}
			for (int i = 0; i < N+M+1; i++) {
				if(arr[i] == max) {		// 최댓값을 가지는 인덱스를 출력
					System.out.print(i + " ");
				}
			}
			System.out.println();
		}
	}
}
