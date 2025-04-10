import java.util.*;
import java.io.*;

class Main {

    static int n, m;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new boolean[n + 1];
        visited[1] = true;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        dfs(1, 0);

        int ans = 0;
        for (int i = 2; i < n + 1; i++) {
            if (visited[i]) ans++;
        }
        
        System.out.println(ans);
    }

    private static void dfs(int num, int depth) {
        if (depth == 2) {
            return;
        }

        for (int i : graph.get(num)) {
            visited[i] = true;
            dfs(i, depth + 1);
        }
    }
}