import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5099 {
	
	// 치즈와 인덱스를 연결하기 위해서 클래스를 만들어준다.
	static class Pizza {
		int index;
		int chz;
		
		public Pizza(int index, int chz) {
			super();
			this.index = index;
			this.chz = chz;
		}
	}
	
	static int T;
	static int N,M;
	static Queue<Pizza> ovens;
	static Queue<Pizza> pizzas;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			ovens = new LinkedList<>();
			pizzas = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				pizzas.offer(new Pizza(i+1, Integer.parseInt(st.nextToken()))); // 피자 큐에 인풋 피자 넣기
			}
			
			for (int i = 0; i < N; i++) {
				ovens.offer(pizzas.poll()); // 오븐 크기만큼 피자 큐에서 빼와서 넣기
			}
			
			while(ovens.size() > 1) {	// 오븐 크기가 1이 될때까지
				Pizza p = ovens.poll(); // 오븐 큐에서 먼저 뺴고
				p.chz = p.chz/2;	// 치즈를 2로 나누고
				if(p.chz == 0) {	// 치즈가 0이면
					if(pizzas.size() > 0) {		// 피자가 피자큐에 있으면 오븐에 넣고 없으면 넣을게 없다.
						ovens.offer(pizzas.poll());
					}
				}else {		// 치즈가 0이 아닌경우 다시 오븐에 넣는다
					ovens.offer(p);
				}
			}
			System.out.println("#" + t + " " + ovens.poll().index); 	// 오븐에 남아있는 피자의 인덱스를 출력
		}
	}
}
