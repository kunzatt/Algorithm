import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < T; t++) {
			int G = Integer.parseInt(br.readLine());
			int[] arr = new int[G];

			for(int i = 0; i < G; i++){
				arr[i] = Integer.parseInt(br.readLine());
			}
			int m = 1;

			int[] num = new int[1000000];
			while (true) {
				boolean check = true;
				for (int i = 0; i < G; i++) {
					int temp = arr[i] % m;
					if (num[temp] == m) {
						check = false;
						break;
					}
					num[temp] = m;
				}
				if (check) {
					sb.append(m).append('\n');
					break;
				}
				m++;
			}
		}
		System.out.print(sb);

	}
}