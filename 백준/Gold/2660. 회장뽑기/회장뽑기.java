import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, min, count;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] score;
    static boolean[] visited;
    static int[] dist;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (start == -1 && end == -1) break;
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        
        score = new int[N + 1];
        min = Integer.MAX_VALUE;
        
        for (int i = 1; i <= N; i++) {
            score[i] = bfs(i);
            min = Math.min(min, score[i]);
        }
        
        count = 0;
        for (int i = 1; i <= N; i++) {
            if (score[i] == min) {
                count++;
            }
        }
        
        System.out.println(min + " " + count);
        
        for (int i = 1; i <= N; i++) {
            if (score[i] == min) {
                System.out.print(i + " ");
            }
        }
    }
    
    private static int bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        dist = new int[N + 1];
        visited = new boolean[N + 1];
        
        Arrays.fill(dist, -1);
        dist[num] = 0;
        visited[num] = true;
        queue.add(num);
        
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            
            for (int next : graph.get(temp)) {
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[temp] + 1;
                    queue.add(next);
                }
            }
        }
        
        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dist[i]);
        }
        
        return max;
    }
}