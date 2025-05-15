import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        A %= B;

        for (int i = 0; i < N - 1; i++) {
            A *= 10;
            A %= B;
        }

        A *= 10;
        int result = A / B;

        System.out.println(result);
    }
}