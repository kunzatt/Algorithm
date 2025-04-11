import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(computers, visited, i, n);
                count++;
            }
        }
        
        return count;
    }
    
    static void bfs(int[][] map, boolean[] visited, int start, int n) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;
        
        while(!que.isEmpty()) {
            int temp = que.poll();
            
            for (int i = 0; i < n; i++) {
                if (map[temp][i] == 1 && !visited[i]) {
                    que.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}