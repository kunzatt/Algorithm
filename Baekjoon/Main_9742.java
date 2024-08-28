import java.io.*;
import java.util.*;

public class Main_9742 {
	
	static int N, acount, count, a;
	static char[] p, nums;
	static boolean[] check;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;		
		
		while ((input=br.readLine()) != null) {
			sb.setLength(0);
			StringTokenizer st = new StringTokenizer(input);
			if(!st.hasMoreTokens()) return;		// 이 부분이 제일 어렵다.
			String str = st.nextToken();
			int a = Integer.parseInt(st.nextToken());
			
			N = str.length();
			p = new char[N];
			check = new boolean[N];
			acount = 0;
			count = 0;
			sb.append(str + " ").append(a).append(" " + "=" + " ");
			
			for (int i = 0; i < N; i++) {
				p[i] = str.charAt(i);
			}
			
			nums = new char[N];
			dfs(0);
			if(count < a) {
				sb.append("No permutation");
			}else {
				ans(0, a);				
			}
			System.out.println(sb);
		}

	}

	static void ans(int cnt, int a) {
		
		if (cnt == N) {
			acount++;
			if (acount == a) {
				for (int i = 0; i < N; i++) {
					sb.append(nums[i]);
				}
			}
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(check[i]) continue;
			check[i] = true;
			nums[cnt] = p[i];
			ans(cnt+1, a);
//			nums[cnt] = 0;
			check[i] = false;
		}
		
	}
	
static void dfs(int cnt) {
		
		if (cnt == N) {
			count++;
			return;
		}

		if(acount < a) {
			sb.append("No permutation");
		}
		
		for (int i = 0; i < N; i++) {
			if(check[i]) continue;
			check[i] = true;
			nums[cnt] = p[i];
			dfs(cnt+1);
//			nums[cnt] = 0;
			check[i] = false;
		}
		
	}

}
