import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");;
		int N = Integer.parseInt(st.nextToken());
		
		double[] arr = new double[N];
		double max = arr[0];
		double sum = 0;
		
		st = new StringTokenizer(br.readLine(), " ");;
		for (int i = 0; i < N; i++) {
			arr[i]	= Double.parseDouble(st.nextToken());
			if(max<arr[i]) {
				max = arr[i];
			}
		}
		
		for (int i = 0; i < N; i++) {
			arr[i] = arr[i]/max*100;
			sum += arr[i];
		}
		System.out.println(sum/N);
	}

}
