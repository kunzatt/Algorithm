import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] parent;
    static boolean[] visited;
    static ArrayList<Integer> tree[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        tree = new ArrayList[N + 1];
        parent = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            tree[start].add(end);
            tree[end].add(start);
        }

        dfs(1);

        for (int i = 2; i < N + 1; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void dfs(int idx) {
        visited[idx] = true;
        for (int next : tree[idx]) {
            if (!visited[next]) {
                parent[next] = idx;
                dfs(next);
            }
        }
    }
}