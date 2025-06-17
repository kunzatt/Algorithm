import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static char[][] a;
    static boolean[][][][] v;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        a = new char[n][m];
        v = new boolean[n][m][n][m];
        
        int x1 = -1, y1 = -1, x2 = -1, y2 = -1;
        
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j);
                if (a[i][j] == 'o') {
                    if (x1 == -1) {
                        x1 = i;
                        y1 = j;
                    } else {
                        x2 = i;
                        y2 = j;
                    }
                    a[i][j] = '.';
                }
            }
        }
        
        System.out.println(bfs(x1, y1, x2, y2));
    }
    
    static int bfs(int x1, int y1, int x2, int y2) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x1, y1, x2, y2, 0});
        v[x1][y1][x2][y2] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx1 = cur[0], cy1 = cur[1];
            int cx2 = cur[2], cy2 = cur[3];
            int cnt = cur[4];
            
            if (cnt >= 10) return -1;
            
            for (int i = 0; i < 4; i++) {
                int nx1 = cx1 + dx[i];
                int ny1 = cy1 + dy[i];
                int nx2 = cx2 + dx[i];
                int ny2 = cy2 + dy[i];
                
                boolean out1 = nx1 < 0 || nx1 >= n || ny1 < 0 || ny1 >= m;
                boolean out2 = nx2 < 0 || nx2 >= n || ny2 < 0 || ny2 >= m;
                
                if (out1 && out2) continue;
                if (out1 || out2) return cnt + 1;
                
                if (a[nx1][ny1] == '#') {
                    nx1 = cx1;
                    ny1 = cy1;
                }
                if (a[nx2][ny2] == '#') {
                    nx2 = cx2;
                    ny2 = cy2;
                }
                
                if (!v[nx1][ny1][nx2][ny2]) {
                    v[nx1][ny1][nx2][ny2] = true;
                    q.offer(new int[]{nx1, ny1, nx2, ny2, cnt + 1});
                }
            }
        }
        
        return -1;
    }
}