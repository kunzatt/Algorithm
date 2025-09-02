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
            Arrays.sort(first);

            int M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int temp = Integer.parseInt(st.nextToken());
                sb.append(Arrays.binarySearch(first, temp) >= 0 ? 1 : 0).append('\n');
            }
        }
        System.out.println(sb);

    }
}