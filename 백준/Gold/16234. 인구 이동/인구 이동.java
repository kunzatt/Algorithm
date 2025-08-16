import java.io.*;
import java.util.*;

public class Main {
    static int n, l, r;
    static int[][] a;
    static boolean[][] v;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        
        a = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int day = 0;
        while(true) {
            v = new boolean[n][n];
            boolean moved = false;
            
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!v[i][j]) {
                        List<int[]> union = bfs(i, j);
                        if(union.size() > 1) {
                            moved = true;
                            int sum = 0;
                            for(int[] pos : union) {
                                sum += a[pos[0]][pos[1]];
                            }
                            int avg = sum / union.size();
                            for(int[] pos : union) {
                                a[pos[0]][pos[1]] = avg;
                            }
                        }
                    }
                }
            }
            
            if(!moved) break;
            day++;
        }
        
        System.out.println(day);
    }
    
    static List<int[]> bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> union = new ArrayList<>();
        
        q.offer(new int[]{x, y});
        union.add(new int[]{x, y});
        v[x][y] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];
            
            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && !v[nx][ny]) {
                    int diff = Math.abs(a[cx][cy] - a[nx][ny]);
                    if(diff >= l && diff <= r) {
                        v[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                        union.add(new int[]{nx, ny});
                    }
                }
            }
        }
        
        return union;
    }
}