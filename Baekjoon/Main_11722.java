import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11722 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dec = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dec[i] = 1;
		}
		
		for (int i = N-1; i >= 1; i--) {
			for (int j = i-1; j >= 0; j--) {
				if(arr[i] < arr[j]) {
					dec[j] = Math.max(dec[j], dec[i]+1);
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, dec[i]);
		}
		System.out.println(max);

	}

}
