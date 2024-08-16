import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2609 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int max = 0;
		int min = 0;
		
		for (int i = 1; i <= A+B; i++) {
			if(A%i == 0 && B%i == 0) {
				max = Math.max(max, i);
			}
			min = max*(A/max)*(B/max);
		}
		System.out.println(max);
		System.out.println(min);

	}

}
