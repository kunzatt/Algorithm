import java.io.*;
import java.util.*;

public class Main_1934 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int max = 0;
			for (int j = 1; j < A+B; j++) {
				if(A%j == 0 && B%j == 0) {
					max = Math.max(max, j);
				}
			}
			System.out.println(max*(A/max)*(B/max));
		}

	}

}
