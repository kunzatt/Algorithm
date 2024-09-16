import java.io.*;

public class Main_1789 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine());
		long sum = 0;
		int count = 0;
		int a = 1;
		
		while (sum <= S) {
			sum += a++;
			count++;
		}
		
		System.out.println(count-1);

	}

}
