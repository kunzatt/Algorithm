import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }

        int[][] dp = new int[3][N + 1];
        int mod = 1000000007;

        dp[0][2] = dp[1][2] = 1;

        for (int i = 3; i <= N; i++) {
            dp[0][i] = (dp[1][i - 1] + dp[2][i - 1]) % mod;
            dp[1][i] = (dp[0][i - 1] + dp[2][i - 1]) % mod;
            dp[2][i] = (dp[0][i - 1] + dp[1][i - 1]) % mod;
        }

        System.out.println(dp[0][N]);
    }
}