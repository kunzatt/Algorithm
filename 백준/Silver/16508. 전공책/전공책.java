import java.io.*;
import java.util.*;

public class Main {
    static int n, min = Integer.MAX_VALUE;
    static int[] target = new int[26];
    static int[][] books;
    static int[] prices;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine();
        
        for (int i = 0; i < t.length(); i++) {
            target[t.charAt(i) - 'A']++;
        }
        
        n = Integer.parseInt(br.readLine());
        books = new int[n][26];
        prices = new int[n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            prices[i] = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            for (int j = 0; j < s.length(); j++) {
                books[i][s.charAt(j) - 'A']++;
            }
        }
        
        dfs(new int[26], 0, 0);
        
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
    
    static void dfs(int[] cur, int cost, int idx) {
        boolean ok = true;
        for (int i = 0; i < 26; i++) {
            if (cur[i] < target[i]) {
                ok = false;
                break;
            }
        }
        
        if (ok) {
            min = Math.min(min, cost);
            return;
        }
        
        for (int i = idx; i < n; i++) {
            int[] next = new int[26];
            for (int j = 0; j < 26; j++) {
                next[j] = cur[j] + books[i][j];
            }
            dfs(next, cost + prices[i], i + 1);
        }
    }
}