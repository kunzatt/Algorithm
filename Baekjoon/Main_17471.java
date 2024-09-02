import java.io.*;
import java.util.*;

public class Main_17471 {
	
	static int N, M, asum, bsum, min;
	static boolean[] visited;
	static boolean[] bvisited;
	static int[] p;
	static int[] arr;
	static int[][] map;


	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		p = new int[N];
		arr = new int[N];
		visited = new boolean[N];
		map = new int[N][N];
		min = Integer.MAX_VALUE;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			p[i] = i+1;
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			for (int j = 0; j < M; j++) {
				int a = Integer.parseInt(st.nextToken());
				map[i][a-1] = map[a-1][i] = 1;
			}
		}
		
		subSet(0);
		System.out.println(min==Integer.MAX_VALUE ? -1 : min);
	}

	static void subSet(int cnt) {
		
		if(cnt==N) {
			int n = sol(visited); 
			min=Math.min(min, n );
			return ;
		}
		
		visited[cnt]=true;
		subSet(cnt+1);
		visited[cnt]=false;
		subSet(cnt+1);
	}

	static int sol(boolean[] visit) {
		
		List<Integer> alist=new ArrayList<>();
		List<Integer> blist=new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			if(visit[i]) {
				alist.add(i);
			}
			if(!visit[i]) {
				blist.add(i);
			}
		}
		
		if(alist.size()==0 || blist.size()==0) return Integer.MAX_VALUE;
		
		bvisited=new boolean[N];
		bfs(alist);
		bfs(blist);
		
		if(check(bvisited)) {
			return getMin(alist, blist);
		}else {
			return  Integer.MAX_VALUE;
		}
		
	}

	static int getMin(List<Integer> alist, List<Integer> blist) {
		
		int asum=0;
		for (int i = 0; i < alist.size(); i++) {
			asum+=arr[alist.get(i)];
		}
		int bsum=0;
		for (int i = 0; i < blist.size(); i++) {
			bsum+=arr[blist.get(i)];
		}
		return Math.abs(asum-bsum);
	}

	static boolean check(boolean[] check) {
		
		for (int i = 0; i < N; i++) {
			if(!check[i]) return false;
		}
		return true;
	}

	static void bfs(List<Integer> list) {
		
		Queue<Integer> que=new LinkedList<>();
		que.offer(list.get(0));
		bvisited[list.get(0)]=true;
		
		while(!que.isEmpty()) {
			int s=que.poll();
			for (int e = 0; e <list.size(); e++) {
				if(bvisited[list.get(e)]) continue;
				if(map[s][list.get(e)]==1) {
					que.offer(list.get(e));
					bvisited[list.get(e)]=true;
				}
			}
		}
	}



}
