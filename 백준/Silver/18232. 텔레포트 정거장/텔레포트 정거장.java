import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            // 인접한 집으로 이동 가능
            if (i > 1) graph[i].add(i - 1);
            if (i < n) graph[i].add(i + 1);
        }
        
        // 텔레포트 연결 추가
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        dist[s] = 0;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int next : graph[cur]) {
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }
        
        System.out.println(dist[e]);
    }
}