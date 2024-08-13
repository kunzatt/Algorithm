import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1712 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		if (C <= B) {
			sb.append(-1);
		}else {
			int result = A/(C-B) + 1; // result변수를 if문 밖에 넣으면 C-B가 0이 되는 상황이 발생하기 때문에 안에 넣어야 한다.
			sb.append(result);
		}
		System.out.println(sb);
	}
}
