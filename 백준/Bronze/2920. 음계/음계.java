import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean flag = true;
        boolean check = true;
        for (int i = 1; i < 7; i++) {
            if ((arr[i] - arr[i - 1]) * (arr[i + 1] - arr[i]) < 0) {
                flag = false;
                break;
            }

            if (arr[i - 1]  > arr[i]) {
                check = false;
            }
        }
        if (!flag) {
            System.out.println("mixed");
        } else if (!check) {
            System.out.println("descending");
        } else {
            System.out.println("ascending");
        }
    }
}