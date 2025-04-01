import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Boolean> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 1; j <= s.length(); j++) {
                map.put(s.substring(0, j), true);
            }
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            String str = br.readLine();

            if (map.containsKey(str)) {
                count++;
            }
        }

        System.out.println(count);
    }
}