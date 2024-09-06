import java.io.*;
import java.util.*;

public class Main_5014 {
	
	static int F, S, G, U, D;
	static boolean[] visited;
	static int[] map;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		visited = new boolean[F+1];
		map = new int[F+1];
		
		if (S == G) System.out.println(0);		// 처음에 이거 고려 안해줘서 틀렸음. 고려 안하면 use the stairs가 나온다.
		else bfs(S);

	}

	static void bfs(int start) {
		
		Queue<Integer> que = new LinkedList<>();
		que.add(start);
		visited[start] = true;
		map[start] = 0;
		
		while (!que.isEmpty()) {
			int temp = que.poll();
			int nu = temp + U;
			int nd = temp - D;
			
			if (temp == G) {
				System.out.println(map[temp]);
			}
			
			if (nu <= F && !visited[nu]) {
				visited[nu] = true;
				map[nu] = map[temp] + 1;
				que.add(nu);
			}
			if (nd > 0 && !visited[nd]) {
				visited[nd] = true;
				map[nd] = map[temp] + 1;
				que.add(nd);
			}
		}
		
		if (map[G] == 0) {
			System.out.println("use the stairs");
		}
		
	}

}
