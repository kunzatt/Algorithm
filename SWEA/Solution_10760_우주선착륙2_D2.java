import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_10760_우주선착륙2_D2 {
	
	static int T;
	static int N,M;
	static int[][] arr;
	static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int count;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			count = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			arr = new int[N+2][M+2]; // 실제 사용할 배열보다 가로 세로 한칸씩 더 만들어서 배열을 둘러싸는 껍질을 만든다.
			
			for (int i = 0; i < N+2; i++) {
				Arrays.fill(arr[i], 10); 	// 배열 일과 초기화, 배열의 값이 10미만 이므로 껍질을 10으로 초기화 시켜주기 위해 Arrays.fill 사용
			}
			
			for (int r = 1; r <= N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 1; c <= M; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= M; c++) {
					int cnt = 0;
					for (int d = 0; d < 8; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if (arr[r][c] > arr[nr][nc]) {
							cnt++;
						}
						if(cnt >= 4) {
							count ++;
							break; // 4개가 되면 더 이상 탐색할 필요가 없기 때문에 break
						}
					}
				}
			}
			System.out.println("#" + t + " " + count);
		}
	}

}
