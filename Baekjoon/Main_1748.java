import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_1748 {

	public static void main(String[] args) throws IOException {
		// StringBuilder를 활용해 자릿수를 구하면 메모리 초과가 난다.
		// 수가 증가하면서 각 자리수를 10, 100 ... 이렇게 구분해서 따로 count 해줘야 정답이 나온다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		int num = 1;
		int tcnt = 10;
		
		for (int i = 1; i <= N; i++) {
			if(i%tcnt == 0) {
				num += 1;
				tcnt *= 10;
			}
			count += num;
		}
		
		bw.write(count+"\n");
		bw.flush();
		bw.close();
	}

}
