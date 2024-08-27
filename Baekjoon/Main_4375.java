import java.io.*;
import java.util.*;

// 입력이 어려웠던 문제
// 모듈러스 연산을 잘 활용해서 시간초과 유의
public class Main_4375 {
	
	static int n;
	static long num, count;
	static String str;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while((str = br.readLine()) != null) {
			n = Integer.parseInt(str);
			num = 1;
			count = 1;
			while(true) {
				if(num % n == 0) {
					System.out.println(count);
					break;
				}else {
					num = (num*10 +1) % n; // % n을 한번 더 해주면서 시간을 줄인다.
					count++;
				}		
			}
		}
	}

}
