import java.util.*;
import java.io.*;

public class Main {
    static int n, m, x;
    static ArrayList<int[]>[] g, rg;
    static final int INF = 1000000000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        
        g = new ArrayList[n + 1];
        rg = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
            rg[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g[a].add(new int[]{b, c});
            rg[b].add(new int[]{a, c});
        }
        
        int[] d1 = dijkstra(g, x);
        int[] d2 = dijkstra(rg, x);
        
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, d1[i] + d2[i]);
        }
        
        System.out.println(ans);
    }
    
    static int[] dijkstra(ArrayList<int[]>[] graph, int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{start, 0});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int d = cur[1];
            
            if (d > dist[u]) continue;
            
            for (int[] edge : graph[u]) {
                int v = edge[0];
                int w = edge[1];
                
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
        
        return dist;
    }
}