import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] dp = new int[41];
        dp[0] = 0;
        dp[1] = 1;
        
        for (int i = 2; i <= 40; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        int t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            
            if (n == 0) {
                bw.write("1 0\n");
            } else {
                bw.write(dp[n-1] + " " + dp[n] + "\n");
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}