import java.io.*;
import java.util.*;

public class Main {
	
	static int N, r, c;
	static int num = 0;
//	static int[][] arr;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int a = (int) Math.pow(2, N);
//		arr = new int[a][a];
//		rec(0, 0, a);
//		System.out.println(arr[r][c]);
		rec(r, c, a);
		System.out.println(num);

	}

	static void rec(int r, int c, int n) {	
		
		// 가지치기를 해야한다.
		if(n == 1)
			return;
		
		if(r < n/2 && c < n/2) {
			rec(r, c, n/2);
		}
		else if(r < n/2 && c >= n/2) {
			num += n*n / 4;
			rec(r, c-n/2, n/2);
		}
		else if(r >= n/2 && c < n/2) {
			num += (n*n / 4) * 2;
			rec(r-n/2, c, n/2);
		}
		else {
			num += (n*n / 4) * 3;
			rec(r-n/2, c-n/2, n/2);
		}
			
//		// 단순 재귀로 풀어도 풀리지만 메모리 초과가 난다.
//		if (n == 2) {
//			for (int i = 0; i < 2; i++) {
//				for (int j = 0; j < 2; j++) {
//					arr[x+i][y+j] = num++;
//				}
//			}
//			return;
//		}
//		
//		rec(x, y, n/2);
//		rec(x, y+n/2, n/2);
//		rec(x+n/2, y, n/2);
//		rec(x+n/2, y+n/2, n/2);
//		
	}
		

}
