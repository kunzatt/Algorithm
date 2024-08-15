import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1929 {
	// 소수를 에라토스테네스 체로 구해야 하는 문제
	// 일반적인 반복문으로 구하면 시간초과가 난다.
	// 에라토스테네스의 체를 제대로 숙지하기.

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());		
		primeNumber(M, N);
	}
	
	static void primeNumber(int m, int n) {
		int[] arr = new int[n+1];
		StringBuilder sb = new StringBuilder();
		
		// 배열을 인덱스 번호와 값을 동일하게 초기
		for (int i = 2; i <= n; i++) {
			arr[i] = i;
		}
		
		for (int i = 2; i <= n; i++) {
			if (arr[i] == 0) 
				continue;  		// 배열의 값이 0이어도 continue
            for (int j = i+i; j <= n; j += i) { // 초기화된 배열에서 n의 배수는 지운다.
                arr[j] = 0;
            }
        }
        for (int i = m; i <= n; i++) {
            if (arr[i] != 0) sb.append(i + "\n");
        }
        System.out.print(sb);
	}
}
