import java.util.*;
import java.io.*;

class Main {

    static int N, M, cnt, K;
    static ArrayList<Integer> graph[];
    static ArrayList<Integer> rgraph[];
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = (N + 1) / 2;

        graph = new ArrayList[N + 1];
        rgraph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            rgraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            rgraph[end].add(start);
        }

        int ans = 0;        
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            cnt = 0;
            Arrays.fill(visited, false);
            visited[i] = true;
            
            for (int next : rgraph[i]) {
                if (!visited[next]) {
                    visited[next] = true;
                    cnt += 1 + isHeavier(next);
                    
                    if (cnt >= K) {
                        break;
                    }
                }
            }
            if (cnt >= K) {
                ans++;
                continue;
            }
            
            cnt = 0;
            Arrays.fill(visited, false);
            visited[i] = true;
            for (int next : graph[i]) {
                if (!visited[next]) {
                    visited[next] = true;
                    cnt += 1 + isLighter(next);
                    
                    if (cnt >= K) {
                        break;
                    }
                }
            }
            if (cnt >= K) {
                ans++;
                continue;
            }

        }

        System.out.println(ans);        
    }

    private static int isHeavier(int num) {
        int count = 0;
        
        for (int next : rgraph[num]) {
                if (!visited[next]) {
                    visited[next] = true;
                    count += 1 + isHeavier(next);
                    
                    if (count >= K) {
                        break;
                    }
                }
            }
        return count;
    }

    private static int isLighter(int num) {
        int count = 0;
        
        for (int next : graph[num]) {
                if (!visited[next]) {
                    visited[next] = true;
                    count += 1 + isLighter(next);
                    
                    if (count >= K) {
                        break;
                    }
                }
            }
        return count;
    }
}