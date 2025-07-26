import java.io.*;
import java.util.*;

public class Main {
    static int n, m, h, w, sr, sc, fr, fc;
    static int[][] g;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        g = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                g[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        sr = Integer.parseInt(st.nextToken()) - 1;
        sc = Integer.parseInt(st.nextToken()) - 1;
        fr = Integer.parseInt(st.nextToken()) - 1;
        fc = Integer.parseInt(st.nextToken()) - 1;
        
        System.out.println(bfs());
    }
    
    static int bfs() {
        if (!canPlace(sr, sc) || !canPlace(fr, fc)) return -1;
        if (sr == fr && sc == fc) return 0;
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] v = new boolean[n][m];
        
        q.offer(new int[]{sr, sc, 0});
        v[sr][sc] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], d = cur[2];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx + h - 1 < n && ny + w - 1 < m && !v[nx][ny] && canPlace(nx, ny)) {
                    if (nx == fr && ny == fc) return d + 1;
                    q.offer(new int[]{nx, ny, d + 1});
                    v[nx][ny] = true;
                }
            }
        }
        
        return -1;
    }
    
    static boolean canPlace(int x, int y) {
        if (x + h > n || y + w > m) return false;
        for (int i = x; i < x + h; i++) {
            for (int j = y; j < y + w; j++) {
                if (g[i][j] == 1) return false;
            }
        }
        return true;
    }
}