import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        int K = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        for (String lamp : arr) {
            int count = 0;
            for (char c : lamp.toCharArray()) {
                if (c == '0') {
                    count++;
                }
            }

            if (count > K || (count % 2 != K % 2)) {
                continue;
            }

            map.put(lamp, map.getOrDefault(lamp, 0) + 1);
        }

        int answer = 0;
        for (int count : map.values()) {
            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }
}