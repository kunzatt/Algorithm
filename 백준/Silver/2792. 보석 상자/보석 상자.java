import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] gems = new int[m];
        int max = 0;

        for (int i = 0; i < m; i++) {
            gems[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, gems[i]);
        }

        int left = 1;
        int right = max;
        int ans = max;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (check(gems, n, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }

    static boolean check(int[] gems, int n, int limit) {
        int cnt = 0;

        for (int gem : gems) {
            cnt += (gem + limit - 1) / limit;
            if (cnt > n) return false;
        }

        return true;
    }
}