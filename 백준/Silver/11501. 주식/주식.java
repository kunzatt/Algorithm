import java.io.*;
import java.util.*;

public class Main {

    private static int start, end, N;
    private static long sum;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            sum = 0;
            start = 0;
            while (start < N) {
                end = start;
                for (int i = start; i < N; i++) {
                    if (arr[i] >= arr[end]) {
                        end = i;
                    }
                }

                for (int i = start; i < end; i++) {
                    sum += arr[end] - arr[i];
                }

                start = end + 1;
            }

            System.out.println(sum);

        }

    }
}