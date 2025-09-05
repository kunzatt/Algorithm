import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] aarr = new int[N];
            int[] barr = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                aarr[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                barr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(barr);
            int result = 0;
            for (int i = 0; i < N; i++) {
               int first = 0;
               int end = M - 1;
               int index = 0;

               while (first <= end) {
                   int mid = (first + end) / 2;
                   if (barr[mid] < aarr[i]) {
                       first = mid + 1;
                       index = mid + 1;
                   }
                   else {
                       end = mid - 1;
                   }
               }
                result += index;
            }
            System.out.println(result);
        }
    }
}
