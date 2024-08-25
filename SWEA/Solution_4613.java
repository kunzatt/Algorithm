import java.io.*;
import java.util.*;

public class Solution_4613 {
	
	static int T, N, M;
	static char[][] arr;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder("#"+t);
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new char[N][M];
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = br.readLine().toCharArray();
			}
			
			int min = N*M;
			int d_cnt = change(arr, 0, 'W') + change(arr, N-1, 'R'); // 첫째줄과 마지막줄은 항상 칠해야 하는 색이 고정.
			
			for (int i = 1; i < N-1; i++) {
				for (int j = 1; j < N-i; j++) {
					int cnt = d_cnt;
					for (int r = 1; r < N-1; r++) {
						if(r < j) {
							cnt += change(arr, r, 'W');
						}else if (r < i+j) {
							cnt += change(arr, r, 'B');
						}else {
							cnt += change(arr, r, 'R');
						}
						
						if(min < cnt) break;
					}
					min = Math.min(cnt, min);
				}
			}
			sb.append(" " + min);
			System.out.println(sb);			
		}
			
	}
	static int change(char[][] arr, int r, int c) {
		int cnt = 0;
		for(int i=0; i<M; i++) {
            if(arr[r][i] != c)
                cnt++;
        }
        return cnt;
	}
}
