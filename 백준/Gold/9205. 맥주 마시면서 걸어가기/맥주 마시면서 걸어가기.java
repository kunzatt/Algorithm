import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] pos = new int[n + 2][2];
            
            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                pos[i][0] = Integer.parseInt(st.nextToken());
                pos[i][1] = Integer.parseInt(st.nextToken());
            }
            
            boolean[] v = new boolean[n + 2];
            Queue<Integer> q = new LinkedList<>();
            q.add(0);
            v[0] = true;
            
            boolean flag = false;
            while (!q.isEmpty()) {
                int cur = q.poll();
                
                if (cur == n + 1) {
                    flag = true;
                    break;
                }
                
                for (int i = 1; i <= n + 1; i++) {
                    if (!v[i] && Math.abs(pos[cur][0] - pos[i][0]) + Math.abs(pos[cur][1] - pos[i][1]) <= 1000) {
                        v[i] = true;
                        q.add(i);
                    }
                }
            }
            
            System.out.println(flag ? "happy" : "sad");
        }
    }
}