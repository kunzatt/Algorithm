import java.io.*;
import java.util.*;

public class Main_1476 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int a = 0;
		int b = 0;
		int c = 0;
		
		while(true) {
			int A = 15*a + E;
			int B = 28*b + S;
			int C = 19*c + M;
			if(A == B && B == C) break;
			if(A < B || A < C) {
				a++;
			}
			if(B < A || B < C) {
				b++;
			}
			if(C < A || C < B) {
				c++;
			}
		}
		System.out.println(15*a + E);
	}

}
