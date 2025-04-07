import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] wheel = new char[N];
        Arrays.fill(wheel, '?');
        int cur = 0;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
            char ch = st.nextToken().charAt(0);

            cur = (cur + temp) % N;

            if (wheel[cur] != '?' && wheel[cur] != ch) {
                System.out.println("!");
                return;
            }
            wheel[cur] = ch;
        }

        boolean[] used = new boolean[26];
        for (int i = 0; i < N; i++) {
            if (wheel[i] != '?') {
                if (used[wheel[i] - 'A']) {
                    System.out.println("!");
                    return;
                }
                used[wheel[i] - 'A'] = true;
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int pos = (cur - i + N) % N;
            ans.append(wheel[pos]);
        }

        System.out.println(ans.toString());
    }
}