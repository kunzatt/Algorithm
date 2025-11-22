import java.util.*;
import java.io.*;

public class Main {
    static int[] p;
    
    static int find(int x) {
        if (x == p[x]) return x;
        return p[x] = find(p[x]);
    }
    
    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa < pb) {
            p[pb] = pa;
        } else if (pb < pa) {
            p[pa] = pb;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int tc = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= tc; t++) {
            sb.append("Scenario " + t + ":\n");
            int n = Integer.parseInt(br.readLine());
            p = new int[n];
            
            for (int i = 0; i < n; i++) p[i] = i;
            
            int m = Integer.parseInt(br.readLine());
            
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }
            
            int q = Integer.parseInt(br.readLine());
            
            for (int i = 0; i < q; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (find(a) == find(b)) sb.append("1\n");
                else sb.append("0\n");
            }
            
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
}