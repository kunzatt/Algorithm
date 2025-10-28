import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[][] arr;
    private static int[] max;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][5];
        max = new int[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findmax(arr);

        int maxNum = 0;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (max[i] >= maxNum) {
                maxNum = max[i];
                ans = i + 1;
            }
        }

        System.out.println(ans);

    }

    private static void findmax(int[][] arr) {
        for (int i = 0; i < N; i++) {
            int maxNum = 0;
            for (int j = 0; j < 5; j++) {
                for (int k = j + 1; k < 5; k++) {
                    for (int l = k + 1; l < 5; l++) {
                        int sum = arr[i][j] + arr[i][k] + arr[i][l];
                        maxNum = Math.max(maxNum, sum % 10);
                    }
                }
            }
            max[i] = maxNum;
        }

    }
}