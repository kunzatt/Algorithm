import java.io.*;
import java.util.*;

public class Main {
    static long w, h, k;
    
    static boolean check(long a, long b) {
        return a * b <= k;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        w = Long.parseLong(st.nextToken());
        h = Long.parseLong(st.nextToken());
        k = Long.parseLong(st.nextToken());
        
        int n = Integer.parseInt(br.readLine());
        long[] ht = new long[n];
        List<Long> bh = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ht[i] = Long.parseLong(st.nextToken());
            if (i != 0) bh.add(ht[i] - ht[i-1]);
            else bh.add(ht[i]);
        }
        bh.add(h - ht[n-1]);
        
        int m = Integer.parseInt(br.readLine());
        long[] wd = new long[m];
        List<Long> bw = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            wd[i] = Long.parseLong(st.nextToken());
            if (i != 0) bw.add(wd[i] - wd[i-1]);
            else bw.add(wd[i]);
        }
        bw.add(w - wd[m-1]);
        
        long ret = 0;
        Collections.sort(bw);
        
        for (int i = 0; i < bh.size(); i++) {
            long l = 0;
            long r = bw.size() - 1;
            while (l <= r) {
                long mid = (l + r) / 2;
                if (check(bh.get(i), bw.get((int)mid))) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            ret += l;
        }
        
        System.out.println(ret);
    }
}