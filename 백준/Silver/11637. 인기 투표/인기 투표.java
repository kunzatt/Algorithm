import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] v = new int[n];
            int sum = 0;
            int max = 0;
            int idx = 0;

            for(int i = 0; i < n; i++) {
                v[i] = Integer.parseInt(br.readLine());
                sum += v[i];
                if(v[i] > max) {
                    max = v[i];
                    idx = i + 1;
                }
            }

            int cnt = 0;
            for(int i = 0; i < n; i++) {
                if(v[i] == max) cnt++;
            }

            if(cnt > 1) {
                System.out.println("no winner");
            } else if(max > sum / 2) {
                System.out.println("majority winner " + idx);
            } else {
                System.out.println("minority winner " + idx);
            }
        }
    }
}