import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

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
		
		for (int i = 2; i <= n; i++) {
			arr[i] = i;
		}
		
		for (int i = 2; i <= n; i++) {
			if (arr[i] == 0) 
				continue;  
            for (int j = i+i; j <= n; j += i) {
                arr[j] = 0;
            }
        }
        for (int i = m; i <= n; i++) {
            if (arr[i] != 0) sb.append(i + "\n");
        }
        System.out.print(sb);
	}
}
