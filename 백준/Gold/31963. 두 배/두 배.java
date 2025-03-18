import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long count = 0;  
        long[] carr = new long[N];  

        for (int i = 1; i < N; i++) {
            double ratio = Math.ceil(Math.log(arr[i - 1] / (double)arr[i]) / Math.log(2)) + carr[i - 1];
            if (ratio > 0) {
                carr[i] = Math.max(0, (long)ratio);
                count += carr[i];
            }
        }

        System.out.println(count);
    }
}