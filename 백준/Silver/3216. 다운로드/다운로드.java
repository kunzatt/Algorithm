import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int ans = 0, l = 0;
        
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int d = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            
            l -= v;
            if (l < 0) {
                ans -= l;
                l = 0;
            }
            l += d;
        }
        
        System.out.println(ans);
    }
}