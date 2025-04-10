import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            long temp = Long.parseLong(br.readLine());
            if (temp == 0 && pq.isEmpty()) {
                System.out.println(0);
            } else if (temp == 0 && !pq.isEmpty()) {
                System.out.println(pq.poll());
            } else {
                pq.add(temp);
            }
        }

    }
}