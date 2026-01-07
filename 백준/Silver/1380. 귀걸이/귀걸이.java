import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 1;

        while (true) {
            StringTokenizer st;
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            String[] name = new String[n + 1];
            for (int i = 1; i <= n; i++) {
                name[i] = br.readLine();
            }
            int[] arr = new int[n + 1];
            for (int i = 0; i < 2 * n - 1; i++) {
                st = new StringTokenizer(br.readLine());
                arr[Integer.parseInt(st.nextToken())]++;
            }

            int temp = 0;

            for (int i = 1; i <= n; i++) {
                if (arr[i] == 1) temp = i;
            }

            System.out.println(num + " " + name[temp]);
            num++;

        }


    }
}
