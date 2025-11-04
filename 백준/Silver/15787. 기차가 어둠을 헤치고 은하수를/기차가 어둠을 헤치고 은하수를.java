import java.io.*;
import java.util.*;

public class Main {
    static int[] t;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        t = new int[n+1];
        
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int train = Integer.parseInt(st.nextToken());
            
            if(c == 1) {
                int x = Integer.parseInt(st.nextToken()) - 1;
                t[train] |= (1 << x);
            } else if(c == 2) {
                int x = Integer.parseInt(st.nextToken()) - 1;
                t[train] &= ~(1 << x);
            } else if(c == 3) {
                t[train] = (t[train] & ~(1 << 19)) << 1;
            } else {
                t[train] = (t[train] & ~1) >> 1;
            }
        }
        
        HashSet<Integer> s = new HashSet<>();
        for(int i=1;i<=n;i++) {
            s.add(t[i]);
        }
        
        System.out.println(s.size());
    }
}