import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int v, w;
        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
        public int compareTo(Node o) {
            return w - o.w;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        List<Node>[] g = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g[a].add(new Node(b, c));
            g[b].add(new Node(a, c));
        }
        
        int[] d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[1] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.w > d[cur.v]) continue;
            
            for (Node next : g[cur.v]) {
                if (d[cur.v] + next.w < d[next.v]) {
                    d[next.v] = d[cur.v] + next.w;
                    pq.add(new Node(next.v, d[next.v]));
                }
            }
        }
        
        System.out.println(d[n]);
    }
}