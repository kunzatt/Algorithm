import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int sum = 0, max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }

        System.out.println(binarySearch(arr, M, max, sum)); 
    }

    static int binarySearch(int[] arr, int M, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 1, current = 0;

            for (int i : arr) { 
                if (current + i > mid) {
                    count++;
                    current = i;
                } else {
                    current += i;
                }
            }

            if (count > M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}