import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1225_암호생성기_D3 {
	
	static int T = 10;
	static int n;
	static Queue<Integer> que;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			que = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 8; i++) {
				que.offer(Integer.parseInt(st.nextToken()));				
			}
			
			int num = 0;
			while(true) {
				int p = que.poll(); // 큐 맨앞을 뺀다.
				num = (num%5 + 1);			
				p -= num;	// 뺀것을 1,2,3,4,5 사이클로 뺀다.
				
				if(p <= 0) { // 뺀 값이 0이하면 뒤에 0을 삽입한다.
					que.offer(0);
					break;
				}else {
					que.offer(p);	// 뺀 값이 0보다 크면 그 값을 뒤에 삽입한다.
				}				
			}
			System.out.print("#" + t + " " );
			for (int k = 0; k < 8; k++) {
				System.out.print(que.poll() + " ");		// 큐를 하나씩 빼면서 출력
			}
			System.out.println();
		}
	}

}
