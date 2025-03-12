import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            Queue<int[]> que = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                que.add(new int[] {Integer.parseInt(st.nextToken()), i});
            }

            int count = 0;

            while (!que.isEmpty()) {
                int[] front = que.poll();
                boolean flag = false;

                for (int[] arr : que) {
                    if (arr[0] > front[0]) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    que.add(front);
                } else {
                    count++;
                    if (front[1] == M) break;
                }
            }
            System.out.println(count);
        }
    }
}