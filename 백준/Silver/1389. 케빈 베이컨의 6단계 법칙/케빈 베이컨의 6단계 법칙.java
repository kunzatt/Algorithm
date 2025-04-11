import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static ArrayList<Integer>[] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N + 1];
        graph = new ArrayList[N + 1];
        
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }
        
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                if (j == i) continue;
                sum += bfs(i, j);
            }
            arr[i] = sum;
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            min = Math.min(min, arr[i]);
        }
        
        for (int i = 1; i <= N; i++) {
            if (arr[i] == min) {
                System.out.println(i);
                break;
            }
        }
    }
    
    private static int bfs(int num, int target) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        int[] distance = new int[N + 1];
        
        que.add(num);
        visited[num] = true;
        
        while (!que.isEmpty()) {
            int temp = que.poll();
            
            if (temp == target) {
                return distance[temp];
            }
            
            for (int next : graph[temp]) {
                if (!visited[next]) {
                    que.add(next);
                    visited[next] = true;
                    distance[next] = distance[temp] + 1;
                }
            }
        }
        
        return -1;
    }
}