import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2748 {
	// 입력값 n이 90이하의 자연수 이기 때문에 45? 정도가 넘어가면 출력값이 int가 아닌 long이다.

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] fibo = new long[n+1];
		fibo[0] = 0;
		fibo[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
		System.out.println(fibo[n]);
	}
}
