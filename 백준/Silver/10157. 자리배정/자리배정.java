import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int C, R;
	static int K;
	static int[][] arr;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		arr = new int[R][C];
		
		int d = 0;
		int r = R-1; int c = 0;		
		for (int i = 1; i <= R*C; i++) {
			arr[r][c] = i;
			
			int nr = r + dr[d];
            int nc = c + dc[d];
			if(nr >= R || nr < 0 || nc >= C ||
					nc < 0 || arr[nr][nc] != 0) {
				d = (d +1)%4;
				nr = r + dr[d];
				nc = c + dc[d];
			}
			r = nr;
			c = nc;
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(arr[i][j] == K) {
					System.out.println((j+1) + " " + (R-i));
				}
			}
		}
		if (K >R*C) {
			System.out.println(0);
		}		
	}
}
