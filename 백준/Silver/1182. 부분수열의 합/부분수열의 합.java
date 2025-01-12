import java.io.*;
import java.util.*;

public class Main {
	
	static int N, S, count;
	static int[] p;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		p = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		count = 0;
		powerSet(0, 0);
		if (S == 0) System.out.println(count - 1);
		else System.out.println(count);

	}

	static void powerSet(int cnt, int sum) {
		
		if (cnt == N) {
			if (sum == S) count++;
			return;
		}
		
		powerSet(cnt+1, sum + p[cnt]);
		powerSet(cnt+1, sum);
		
	}

}
