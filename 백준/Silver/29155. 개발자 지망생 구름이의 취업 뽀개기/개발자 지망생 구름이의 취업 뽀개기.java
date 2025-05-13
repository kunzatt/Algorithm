import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine().trim());

        st = new StringTokenizer(br.readLine());
        int[] p = new int[6];
        for (int i = 1; i <= 5; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer>[] times = new ArrayList[6];
        for (int i = 1; i <= 5; i++) {
            times[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            times[k].add(t);
        }

        for (int i = 1; i <= 5; i++) {
            Collections.sort(times[i]);
        }

        int ans = 0;
        int temp = 0;

        for (int i = 1; i <= 5; i++) {
            if (p[i] == 0) continue;

            if (temp != 0) {
                ans += 60;
            }

            temp = i;

            for (int j = 0; j < p[i]; j++) {
                ans += times[i].get(j);

                if (j > 0) {
                    ans += times[i].get(j) - times[i].get(j - 1);
                }
            }
        }

        System.out.println(ans);
    }
}