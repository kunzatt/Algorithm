import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> v = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            int pos = Integer.parseInt(st.nextToken());
            q.offer(pos);
            v.add(pos);
        }
        
        long sum = 0;
        int cnt = 0;
        int dist = 0;
        
        while (cnt < k) {
            int size = q.size();
            dist++;
            
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                
                if (!v.contains(cur - 1)) {
                    v.add(cur - 1);
                    q.offer(cur - 1);
                    sum += dist;
                    cnt++;
                    if (cnt == k) break;
                }
                
                if (cnt < k && !v.contains(cur + 1)) {
                    v.add(cur + 1);
                    q.offer(cur + 1);
                    sum += dist;
                    cnt++;
                    if (cnt == k) break;
                }
            }
        }
        
        System.out.println(sum);
    }
}