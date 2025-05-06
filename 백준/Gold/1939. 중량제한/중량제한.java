import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Bridge>[] graph;
    static int n, m;
    static int start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int maxWeight = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Bridge(b, c));
            graph[b].add(new Bridge(a, c));
            maxWeight = Math.max(maxWeight, c);
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int left = 1;
        int right = maxWeight;
        int answer = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (bfs(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    static boolean bfs(int limit) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == end) return true;

            for (Bridge next : graph[current]) {
                if (!visited[next.dest] && next.weight >= limit) {
                    visited[next.dest] = true;
                    queue.offer(next.dest);
                }
            }
        }

        return false;
    }

    private static class Bridge {
        int dest;
        int weight;

        Bridge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
}