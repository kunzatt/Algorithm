import java.io.*;

public class Main {
    static String s;
    static boolean[] v;
    static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        n = s.length();
        v = new boolean[51];
        dfs(0, 0, "");
    }
    
    static void dfs(int i, int max, String ans) {
        if(i == n) {
            for(int j = 1; j <= max; j++) {
                if(!v[j]) return;
            }
            System.out.println(ans.trim());
            System.exit(0);
            return;
        }
        
        String t = s.substring(i, i+1);
        int num = Integer.parseInt(t);
        if(!v[num]) {
            v[num] = true;
            dfs(i+1, Math.max(max, num), ans + " " + t);
            v[num] = false;
        }
        
        if(i < n-1) {
            t = s.substring(i, i+2);
            num = Integer.parseInt(t);
            if(num <= 50 && !v[num]) {
                v[num] = true;
                dfs(i+2, Math.max(max, num), ans + " " + t);
                v[num] = false;
            }
        }
    }
}