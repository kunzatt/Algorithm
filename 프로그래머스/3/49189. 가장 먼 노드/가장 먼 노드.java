import java.util.*;
class Solution {
    
    static int[] dist;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    
    public int solution(int n, int[][] edge) {
        
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edge.length; i++) {
            int start = edge[i][0];
            int end = edge[i][1];
            
            graph[start].add(end);
            graph[end].add(start);
        }
        
        visited = new boolean[n + 1];
        dist = new int[n + 1];
        
        bfs(1);
        
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dist[i]);
        }
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == max) {
                count++;
            }
        }
        
        return count;
    }
    
    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            
            for (int next : graph[temp]) {
                if (!visited[next]) {
                    dist[next] = dist[temp] + 1;
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}