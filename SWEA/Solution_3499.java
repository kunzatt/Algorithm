import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution_3499 {
	
	static int T;
	static int N;
	static String[] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.setLength(0);
			sb.append("#" + t + " ");
			N = Integer.parseInt(br.readLine());
			arr = new String[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = st.nextToken();
			}
			
			if(N%2 == 0) {
				for (int i = 0; i < N/2; i++) {
					sb.append(arr[i]).append(" ").append(arr[i+N/2]).append(" ");
				}
				System.out.println(sb);
			}else {
				for (int i = 0; i < N/2; i++) {
					sb.append(arr[i]).append(" ").append(arr[i+(N/2+1)]).append(" ");
				}
				sb.append(arr[N/2]);
				System.out.println(sb);
			}
		}
	}

}
