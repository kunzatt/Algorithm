import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] str = new String[N];

		for (int i = 0; i < N; i++) {
			str[i] = br.readLine();
		}

		Set<String> set = new HashSet<>();
		int count = 0;

		for (int i = 1; i < N; i++) {
			if (str[i].equals("ENTER")) {
				count += set.size();
				set.clear();
			}else {
				set.add(str[i]);
			}
		}
		count += set.size();

		System.out.println(count);
	}
}