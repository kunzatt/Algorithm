import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] sorted = a.clone();
        Arrays.sort(sorted);
        
        int g = gcd(n, k);
        
        for (int start = 0; start < g; start++) {
            List<Integer> group = new ArrayList<>();
            List<Integer> target = new ArrayList<>();
            
            for (int i = start; i < n; i += g) {
                group.add(a[i]);
                target.add(sorted[i]);
            }
            
            Collections.sort(group);
            Collections.sort(target);
            
            if (!group.equals(target)) {
                System.out.println("NO");
                return;
            }
        }
        
        System.out.println("YES");
    }
    
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}