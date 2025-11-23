import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            String s = br.readLine();
            int k = Integer.parseInt(br.readLine()); 
            
            if(k == 1) {
                System.out.println("1 1");
                continue;
            }
            
            int[] cnt = new int[26];
            for(int j = 0; j < s.length(); j++) {
                cnt[s.charAt(j) - 'a']++;
            }
            
            int min = Integer.MAX_VALUE;
            int max = -1;
            for(int j = 0; j < s.length(); j++) {
                if(cnt[s.charAt(j) - 'a'] < k) continue;
                
                int c = 1;
                for(int l = j + 1; l < s.length(); l++) {
                    if(s.charAt(j) == s.charAt(l)) c++;
                    if(c == k) {
                        min = Math.min(min, l - j + 1);
                        max = Math.max(max, l - j + 1);
                        break;
                    }
                }
            }
            if(min == Integer.MAX_VALUE || max == -1) System.out.println("-1");
            else System.out.println(min + " " + max);
        }
    }        
}