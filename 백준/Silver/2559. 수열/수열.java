import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(tempSum(arr, n, k));	

	}
	static int tempSum(int[] map, int a, int b) {
		int max;
		int prev = 0;
		for (int i = 0; i < b; i++) {
			prev += map[i];
		}
		max = prev;
		
		for (int i = 1; i <= a-b; i++) {
			int c = prev - map[i-1] + map[i-1+b]; 
			max = Math.max(max, c);
			prev = c;
		}
		return max;
	}

}
