import java.io.*;
import java.util.*;

public class Main_14501 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] T = new int[num];
		int[] P = new int[num];
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());			
		}
		
		int[] dp = new int[num+1];
		
		for(int i = 0; i < num; i++) {
			if(i + T[i] <= num) {	
				dp[i+T[i]]=Math.max(dp[i+T[i]], dp[i] + P[i]);	
			}
			dp[i+1]=Math.max(dp[i+1], dp[i]);
		}
		
		System.out.println(dp[num]);	
	}
	
}
