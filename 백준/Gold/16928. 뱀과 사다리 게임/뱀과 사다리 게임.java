import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] board = new int[101];
        for (int i = 1; i <= 100; i++) {
            board[i] = i;
        }
        
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x] = y;
        }
        
        int[] dist = new int[101];
        Arrays.fill(dist, -1);
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        dist[1] = 0;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            if (cur == 100) {
                System.out.println(dist[100]);
                return;
            }
            
            for (int i = 1; i <= 6; i++) {
                int next = cur + i;
                if (next > 100) continue;
                
                next = board[next];
                
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }
    }
}