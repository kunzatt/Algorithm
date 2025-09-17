import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		primeNumber(N);

	}
	
	static void primeNumber(int n) {
		int[] arr = new int[n+1];
		StringBuilder sb = new StringBuilder();
		
		for (int i = 2; i <= n; i++) {
			arr[i] = i;
		}
		
		for (int i = 2; i <= n; i++) {
			if(arr[i] == 0) continue;
			for (int j = i+i; j <= n; j+=i) {
				arr[j] = 0;
			}
		}
		while(n>1) {
			for (int i = 2; i <= n; i++) {
				if(arr[i] == 0) continue;
				if((n%arr[i]) == 0) {
					n = n/arr[i];
					System.out.println(arr[i]);
					break;
				}				
			}
		}
	}
}
