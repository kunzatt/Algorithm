import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] str = new String[N];
		
		for (int i = 0; i < N; i++) {
			str[i] = br.readLine();
		}
		
		for (int i = 0; i < str.length; i++) {
			int sum = 0;
			int count = 1;
			for (int j = 0; j < str[i].length(); j++) {
				char[] ch = new char[str[i].length()];
				ch[j] = str[i].charAt(j);
				if(ch[j] == 'O') {
					sum += count++;
				}else if(ch[j] == 'X') {
					count = 1;
				}
			}
			System.out.println(sum);
		}
	}
}
