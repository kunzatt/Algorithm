import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int diff = Math.abs(A - B);
        int tdiff = 2000;
        for (int i = 0; i < N; i++) {
            int temp = Math.abs(arr[i] - B);
            if (diff > temp && tdiff > temp) {
                tdiff = temp;
            }
        }

        System.out.println(tdiff + 1 < diff ? tdiff + 1 : diff);

    }
}