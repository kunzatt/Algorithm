import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        
        int[] cnt = new int[26];
        int l = 0, r = 0, k = 0, ans = 0;
        
        while (r < s.length()) {
            if (cnt[s.charAt(r) - 'a'] == 0) k++;
            cnt[s.charAt(r) - 'a']++;
            
            while (k > n) {
                cnt[s.charAt(l) - 'a']--;
                if (cnt[s.charAt(l) - 'a'] == 0) k--;
                l++;
            }
            
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        
        System.out.println(ans);
    }
}