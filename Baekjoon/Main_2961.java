import java.io.*;
import java.util.*;

public class Main_2961 {
	
	static int N, min;
	static int[] sour, bitter;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sour = new int[N];
		bitter = new int[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}

		min = Integer.MAX_VALUE;
		subSet(0, 0, 1, 0);
		System.out.println(min);

	}

	static void subSet(int cnt, int sel, int ssum, int bsum) {

		if (cnt == N) {
			if (sel > 0) min = Math.min(min, Math.abs(ssum-bsum));
			return;
		}
		
		subSet(cnt+1, sel+1, ssum*sour[cnt], bsum+bitter[cnt]);
		subSet(cnt+1, sel, ssum, bsum);
		
	}

}
