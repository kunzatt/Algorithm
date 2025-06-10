import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            dq.offer(new int[]{i + 1, Integer.parseInt(st.nextToken())});
        }

        StringBuilder sb = new StringBuilder();

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            sb.append(cur[0]).append(" ");

            if (dq.isEmpty()) break;

            int move = cur[1];
            if (move > 0) {
                for (int i = 0; i < move - 1; i++) {
                    dq.offerLast(dq.pollFirst());
                }
            } else {
                for (int i = 0; i < -move; i++) {
                    dq.offerFirst(dq.pollLast());
                }
            }
        }

        System.out.println(sb.toString().trim());
    }
}