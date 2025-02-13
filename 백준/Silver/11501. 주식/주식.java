import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long ans = 0;
            int max = 0;

            for (int i = N - 1; i >= 0; i--) {
                if (arr[i] >= max) {
                    max = arr[i];
                }else {
                    ans += max - arr[i];
                }
            }

            System.out.println(ans);

        }

    }
}