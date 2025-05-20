import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < C; i++) {
			double sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				sum += arr[j];
			}
			double avg = sum/N;
			double count = 0;
			for (int j = 0; j < N; j++) {
				if(arr[j] > avg) {
					count++;
				}
			}
			double result = (count/N)*100;
			System.out.printf("%.3f%%\n",result);
		}
	}
}
