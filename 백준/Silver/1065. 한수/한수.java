import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 99;
		
		if (n < 100) System.out.println(n);
		else {	
			for (int i = 100; i <= n; i++) {
				int a = i / 100;
				int b = (i % 100) / 10;
				int c = i % 10; 
				if (a-b == b-c) {
					count++;				
				}
			}
			System.out.println(count);
		}

	}

}
