import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1629 {
	
	static long A, B, C;
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		long ans = pow(A, B);
		System.out.println(ans);

	}
	
	static long pow(long A, long B) {
		if(B == 1) {
			return A%C;
		}
		long temp = pow(A, B / 2);
		if(B % 2 == 1) {
			return (((temp * temp) % C) * A) % C;
		}
		return (temp * temp) % C;
	}

}
