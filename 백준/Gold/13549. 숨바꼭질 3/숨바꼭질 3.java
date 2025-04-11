import java.util.*;
import java.io.*;
class Main {
    static int N, K;
    static int[] map;
    static int[] dir = {-1, 1};
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[100001];
        visited = new boolean[100001];
        Arrays.fill(map, Integer.MAX_VALUE);
        map[N] = 0;
        bfs(N);
        System.out.println(map[K]);
    }
    
    private static void bfs(int num) {
        Queue<Integer> que = new LinkedList<>();
        que.add(num);
        visited[num] = true;
        
        while(!que.isEmpty()) {
            int temp = que.poll();
            visited[temp] = true;
            
            int next = temp * 2;
            while (next <= 100000 && !visited[next]) {
                map[next] = map[temp];
                visited[next] = true;
                que.add(next);
                next *= 2;
            }
            
            for (int d = 0; d < 2; d++) {
                int newNum = temp + dir[d];
                if (newNum < 0 || newNum > 100000 || visited[newNum]) continue;
                
                map[newNum] = map[temp] + 1;
                visited[newNum] = true;
                que.add(newNum);
            }
        }
    }
}