import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int ans = 0;

		while (true) {
			int count = 0;
			int temp = N + ans;

			while (temp > 0) {
				if (temp % 2 == 1) count++;
				temp /= 2;
			}

			if (count <= K) break;
			ans++;
		}

		System.out.println(ans);
	}
}