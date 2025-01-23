import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		int ans = bfs(arr, start, end);
		System.out.println(ans);
	}

	private static int bfs(int[] arr, int start, int end) {
		Queue<Integer> que = new LinkedList<>();
		int[] visited = new int[arr.length];
		Arrays.fill(visited, -1);

		que.add(start - 1);
		visited[start - 1] = 0;

		while (!que.isEmpty()) {
			int curr = que.poll();
			if (curr == end - 1) {  
				return visited[curr];
			}

			for (int i = 0; i < arr.length; i++) {
				if (Math.abs(i-curr) % arr[curr] == 0 && visited[i] == -1) {
					que.add(i);
					visited[i] = visited[curr] + 1;
				}
			}
		}
		return -1;
	}
}