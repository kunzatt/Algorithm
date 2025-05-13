import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int k;
    static String[] cards;
    static boolean[] visited;
    static HashSet<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        cards = new String[n];
        visited = new boolean[n];
        set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            cards[i] = br.readLine();
        }

        dfs(0, "");

        System.out.println(set.size());
    }

    public static void dfs(int d, String num) {
        if (d == k) {
            set.add(num);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(d + 1, num + cards[i]);
                visited[i] = false;
            }
        }
    }
}