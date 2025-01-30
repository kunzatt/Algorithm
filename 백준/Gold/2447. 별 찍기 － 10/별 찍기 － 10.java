import java.io.*;

public class Main {
	
	static int[][] star;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		star = new int[N][N];
		pattern(0, 0, N);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(star[i][j] == 1?"*":" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
	static void pattern(int r, int c, int n) {
		
		if(n == 3) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if(i == 1 && j == 1) continue;		// 중앙 빼고
					star[r+i][c+j] = 1;
				}
			}
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(i == 1 && j == 1) continue;		
				pattern(r + i*n/3, c + j*n/3, n/3);
			}
		}
		
	}

}
