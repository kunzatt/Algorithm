import java.util.*;
import java.io.*;
class Main {
    
    static int max;
    static ArrayList<Integer> tree[];
    static boolean[] visited;
    static boolean[] finished;
    static boolean isTree;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); 
            int m = Integer.parseInt(st.nextToken());
            
            if (n == 0 && m == 0) {
                break;
            }
            
            tree = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                tree[i] = new ArrayList<>();
            }
            
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                
                tree[start].add(end);
                tree[end].add(start);
            }
            
            visited = new boolean[n + 1];
            
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    isTree = true;
                    dfs(i, 0); 
                    if (isTree) count++;
                }
            }
            
            sb.append("Case ").append(t).append(": ");
            if (count == 0) {
                sb.append("No trees.");
            } else if (count == 1) {
                sb.append("There is one tree.");
            } else {
                sb.append("A forest of ").append(count).append(" trees.");
            }
            sb.append("\n");
            
            t++;
        }
        
        System.out.print(sb.toString());
    }
    
    private static void dfs(int current, int parent) {
        visited[current] = true;
        
        for (int next : tree[current]) {
            if (next == parent) continue;
            
            if (visited[next]) {
                isTree = false;
                continue;
            }
            
            dfs(next, current);
        }
    }
}