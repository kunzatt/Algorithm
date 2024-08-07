import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1225 {
	
	static int T = 10;
	static int n;
	static Queue<Integer> que;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
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
				int p = que.poll();	
				num = (num%5 + 1);			
				p -= num;
				
				if(p <= 0) {
					que.offer(0);
					break;
				}else {
					que.offer(p);
				}				
			}
			System.out.print("#" + t + " " );
			for (int k = 0; k < 8; k++) {
				System.out.print(que.poll() + " ");
			}
			System.out.println();
		}
	}

}
