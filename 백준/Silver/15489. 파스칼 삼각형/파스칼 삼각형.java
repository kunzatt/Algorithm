import java.io.*;
import java.util.*;

public class Main {
	
	static int R, C, W, N, M, sum ,k ,l;
	static int[] p;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		N = R-1;
		M = C-1;
		sum = 0;
		int tcount = 0;
		
		for (int k = N; k < N+W; k++) {
			for (int l = M; l <= N+M+(2*tcount)-k; l++) {
				p = new int[k];
				nums = new int[l];
				sum += com(k, l);
			}
			tcount++;
		}
		System.out.println(sum);
	}

	static int com(int a, int b) {
		if (a == b || b == 0) return 1;
		else return com(a-1, b-1) + com(a-1, b);
	}

}
