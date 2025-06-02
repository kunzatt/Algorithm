import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long B = Long.parseLong(st.nextToken());  
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long sum = 0;
        Map<String, Long> map = new HashMap<>(); 
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), Long.parseLong(st.nextToken()));
        }
        for (int i = 0; i < M; i++) {
            sum += map.get(br.readLine());
        }

        System.out.println(sum <= B ? "acceptable" : "unacceptable");
    }
}