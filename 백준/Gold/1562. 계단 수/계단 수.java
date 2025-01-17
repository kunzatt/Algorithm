// 0~9까지의 수가 모든 수가 포함되어 있다는 것을 확인하기 위해 비트마스킹 활용
import java.io.*;

public class Main {
    static long ans;
    static int N, MOD;
    static long[][][] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ans = 0;
        N = Integer.parseInt(br.readLine());
        MOD = 1000000000;
        dp = new long[N+1][10][1<<10]; // dp[2][3][0000011100(2)] -> 2자리 숫자 중, 3으로 끝나면서, [2,3,4]를 사용한 계단 수의 개수

        for (int i = 1; i <= 9; i++) {
        	dp[1][i][1<<i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                for(int visited = 0; visited < (1<<10); visited++) {
                    int nvisited = (visited | (1<<j));
                    if(j == 0) dp[i][j][nvisited] += dp[i-1][j+1][visited]%MOD; 
                    else if(j == 9) dp[i][j][nvisited] += dp[i-1][j-1][visited]%MOD; 
                    else dp[i][j][nvisited] += (dp[i-1][j-1][visited]%MOD + dp[i-1][j+1][visited]%MOD);

                    dp[i][j][nvisited] %= MOD;
                }
            }
        }

        for (int i = 0; i <= 9; i++) { 
            ans += dp[N][i][(1<<10)-1]%MOD;
            ans %= MOD;
        }
        System.out.println(ans);
    }
}