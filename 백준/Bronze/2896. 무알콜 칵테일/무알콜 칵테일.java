import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double[] fruit = new double[3];
        double[] amount = new double[3];

        for (int i = 0; i < 3; i++) {
            fruit[i] = Double.parseDouble(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            amount[i] = Double.parseDouble(st.nextToken());
        }

        double min = Double.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, fruit[i] / amount[i]);
        }

        for (int i = 0; i < 3; i++) {
            double ans = fruit[i] - (amount[i] * min);

            if (ans == (int) ans) {
                System.out.print((int) ans + " ");
            } else {
                System.out.printf("%.6f ", ans);
            }
        }

    }
}