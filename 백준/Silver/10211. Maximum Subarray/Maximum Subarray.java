import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            int[] dp = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                dp[i] = -1001;
            }

            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = i; j >= 0; j--) {
                    sum += arr[j];
                    dp[i] = Math.max(dp[i], sum);
                }
            }

            int ans = Integer.MIN_VALUE;
            for (int i : dp) {
                ans = Math.max(ans, i);
            }
            System.out.println(ans);
        }

    }
}