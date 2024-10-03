import java.io.*;
import java.util.*;

public class Main_11724 {
	
	static int N, M, count;
	static boolean[] visited;
	static List<ArrayList<Integer>> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		
		for (int i = 0; i < N+1; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list.get(from).add(to);
			list.get(to).add(from);
		}
		
		count = 0;
		
		for (int i = 1; i < N+1; i++) {
			if (!visited[i]) {
				bfs(i);
				count++;
			}
		}
		
		System.out.println(count);
		
	}

	private static void bfs(int num) {
		
		Queue<Integer> que = new LinkedList<>();
		que.offer(num);
		
		while(!que.isEmpty()) {
			int temp = que.poll();
			int size = list.get(temp).size();
			
			for (int i = 0; i < size; i++) {
				int ntemp = list.get(temp).get(i);
				
				if (visited[ntemp]) continue;
				que.add(ntemp);
				visited[ntemp] = true; 
			}
		}
		
	}

}
