import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        long osum = 0;
        long esum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            if (i % 2 == 0) osum += arr[i];
            if (i % 2 == 1) esum += arr[i];
        }
        long ans = 0;
        if (N == 3 && osum > esum) {
            ans = -1;
        } else {
            if (osum > esum) ans = osum - esum;
            if (esum > osum) ans = esum - osum;
        }
        System.out.println(ans);
    }
}