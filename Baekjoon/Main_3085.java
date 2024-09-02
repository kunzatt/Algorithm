import java.io.*;
import java.util.*;

public class Main_3085 {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N, nr, nc, max, count;
	static char[][] arr, narr;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		narr = new char[N][N];
		max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				narr[i][j] = arr[i][j];
			}
		}
				
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				for (int i = 0; i < 4; i++) {
					nr = r+dr[i];
					nc = c+dc[i];
					if(check(nr, nc) && arr[r][c] != arr[nr][nc]) {
						swap(r, c, nr, nc);
						solution();
						rswap(r, c, nr, nc);
					}
				}
			}
		}
		
		System.out.println(max);
		
	}

	static void rswap(int x, int y, int nx, int ny) {
		
		narr[x][y] = arr[x][y];
		narr[nx][ny] = arr[nx][ny];
		
	}

	static void swap(int x, int y, int nx, int ny) {
		
		char temp = narr[x][y];
		narr[x][y] = narr[nx][ny];
		narr[nx][ny] = temp;
		
	}

	private static void solution() {
		
		for (int i = 0; i < N; i++) {
			count = 1;
			for (int j = 0; j < N-1; j++) {
				if(narr[i][j] == narr[i][j+1]) {
					count++;
				}else {
					max = Math.max(max, count);
					count = 1;
				}
			}
			max = Math.max(max, count);
		}
		
		for (int i = 0; i < N; i++) {
			count = 1;
			for (int j = 0; j < N-1; j++) {
				if(narr[j][i] == narr[j+1][i]) {
					count++;
				}else {
					max = Math.max(max, count);
					count = 1;
				}
			}
			max = Math.max(max, count);
		}
		
	}

	static boolean check(int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= N) return false;
		else return true;
	}

}
