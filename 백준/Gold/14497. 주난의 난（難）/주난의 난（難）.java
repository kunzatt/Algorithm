import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static char[][] a;
    static boolean[][] v;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken()) - 1;
        int y1 = Integer.parseInt(st.nextToken()) - 1;
        int x2 = Integer.parseInt(st.nextToken()) - 1;
        int y2 = Integer.parseInt(st.nextToken()) - 1;
        
        a = new char[n][m];
        v = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            a[i] = br.readLine().toCharArray();
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x1, y1});
        v[x1][y1] = true;
        
        int cnt = 0;
        
        while (a[x2][y2] != '0') {
            cnt++;
            Queue<int[]> next = new LinkedList<>();
            
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || v[nx][ny]) continue;
                    
                    v[nx][ny] = true;
                    
                    if (a[nx][ny] == '0') {
                        q.offer(new int[]{nx, ny});
                    } else {
                        a[nx][ny] = '0';
                        next.offer(new int[]{nx, ny});
                    }
                }
            }
            q = next;
        }
        
        System.out.println(cnt);
    }
}