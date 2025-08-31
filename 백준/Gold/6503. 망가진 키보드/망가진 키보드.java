import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            int m = Integer.parseInt(br.readLine());
            if (m == 0) break;
            
            String s = br.readLine();
            int len = s.length();
            
            int[] cnt = new int[128];
            int l = 0, r = 0, distinct = 0, ans = 0;
            
            while (r < len) {
                if (cnt[s.charAt(r)] == 0) {
                    distinct++;
                }
                cnt[s.charAt(r)]++;
                
                while (distinct > m) {
                    cnt[s.charAt(l)]--;
                    if (cnt[s.charAt(l)] == 0) {
                        distinct--;
                    }
                    l++;
                }
                
                ans = Math.max(ans, r - l + 1);
                r++;
            }
            
            System.out.println(ans);
        }
        br.close();
    }
}