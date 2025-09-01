import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int left = 1;
        int right = arr[N - 1];

        int ans = 0;
        while(left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += Math.min(arr[i], mid);
            }
            if (sum <= M) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);

    }
}