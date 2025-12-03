import java.util.*;
import java.io.*;

public class Main{
	static int N;
	static int M;
	static int count;
	static int white_count = 0;
	static int black_count = 0;

	static Queue<Node> que = new LinkedList<>();
	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = {0, 0, -1, 1};
	static boolean Visited_arr[][];
	static char map[][];

	static class Node {
		int x;
		int y;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Visited_arr = new boolean[M][N];

		map = new char[M][N];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();

			for(int j=0; j<N; j++) {
				char ch = temp.charAt(j);
				map[i][j] = ch;
			}
		}

		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {

				if( Visited_arr[i][j] == false) {
		
					if(map[i][j] == 'W') {
						int num = BFS(i, j, 'W');
						white_count += num * num;
					}
					else {
						int num = BFS(i, j, 'B');
						black_count += num * num;
					}

				}
			}
		}

		System.out.println(white_count + " " + black_count);
	}
	
	static int BFS(int y, int x, char ch) {
		que.offer(new Node(y, x));
		count = 1;
		Visited_arr[y][x] = true;

		while( !que.isEmpty() ) {
			Range_check(ch); 
		}

		return count;
	}
	

	static void Range_check(char ch) {
		Node now = que.poll();

		for(int i=0; i<4; i++) {

			int now_y = now.y + dy[i];
			int now_x = now.x + dx[i];

			if(now_y >= 0 && now_y<M && now_x>=0 && now_x<N) {

				if(Visited_arr[now_y][now_x] == false && ch == map[now_y][now_x] ) {

					que.offer(new Node(now_y, now_x));
					Visited_arr[now_y][now_x] = true;
					count++;
				}

			}	
		}
	}

}