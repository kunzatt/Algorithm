import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[11];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int temp = c - '0';
            if ((temp == 6 || temp == 9) && arr[6] == arr[9]) {
                arr[6]++;
            } else if ((temp == 6 || temp == 9) && arr[6] > arr[9]) {
                arr[9]++;
            } else {
                arr[temp]++;
            }
        }
        int ans = 0;
        for (int i : arr) {
            ans = Math.max(ans, i);
        }
        System.out.println(ans);
    }
}