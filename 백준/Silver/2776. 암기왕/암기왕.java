import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] first = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                first[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());
            int[] second = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                second[i] = Integer.parseInt(st.nextToken());
            }

            boolean[] ans = new boolean[M];
            Arrays.sort(first);

            for (int i = 0; i < M; i++) {
                int left = 0;
                int right = N - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (first[mid] == second[i]) {
                        ans[i] = true;
                        break;
                    } else if (first[mid] < second[i]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }

            for (int i = 0; i < M; i++) {
                sb.append(ans[i] ? 1 : 0).append('\n');
            }
        }
        System.out.println(sb);

    }
}
