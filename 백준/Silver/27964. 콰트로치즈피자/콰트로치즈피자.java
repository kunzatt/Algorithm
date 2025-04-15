import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String str = st.nextToken();
            if (str.endsWith("Cheese")) {
                set.add(str);
            }
        }

        if (set.size() >= 4) {
            System.out.println("yummy");
        } else {
            System.out.println("sad");
        }
    }
}