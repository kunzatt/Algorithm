import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] m = new char[n][n];
        for (int i = 0; i < n; i++) {
            m[i] = br.readLine().toCharArray();
        }
        
        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], Integer.MAX_VALUE);
        }
        
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        d[0][0] = 0;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    int w = (m[nx][ny] == '0') ? 1 : 0;
                    if (d[x][y] + w < d[nx][ny]) {
                        d[nx][ny] = d[x][y] + w;
                        if (w == 0) {
                            q.offerFirst(new int[]{nx, ny});
                        } else {
                            q.offerLast(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        
        System.out.println(d[n-1][n-1]);
    }
}