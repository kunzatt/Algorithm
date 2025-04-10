import java.util.*;
import java.io.*;

class Main {
    
    static int N, M;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] dist;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        bfs(1);
        
        int max = 0;
        int min = 0;
        int count = 0;
        
        for (int i = 1; i <= N; i++) {
            if (dist[i] > max) {
                max = dist[i];
                min = i;
                count = 1;
            } else if (dist[i] == max) {
                if (i < min) {
                    min = i;
                }
                count++;
            }
        }
        
        System.out.println(min + " " + max + " " + count);
    }
    
    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        dist = new int[N + 1];
        Arrays.fill(dist, -1);
        
        queue.offer(start);
        dist[start] = 0;
        
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            
            for (int next : graph.get(temp)) {
                if (dist[next] == -1) {
                    dist[next] = dist[temp] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}