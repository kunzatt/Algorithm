import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(bfs(a, k));
    }

    private static int bfs(int a, int k) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {a , 0});

        boolean[] visited = new boolean[k + 1];
        visited[a] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentValue = current[0];
            int operations = current[1];

            if (currentValue == k) {
                return operations;
            }

            if (currentValue + 1 <= k && !visited[currentValue + 1]) {
                queue.add(new int[] {currentValue + 1, operations + 1});
                visited[currentValue + 1] = true;
            }

            if (currentValue * 2 <= k && !visited[currentValue * 2]) {
                queue.add(new int[] {currentValue * 2, operations + 1});
                visited[currentValue * 2] = true;
            }
        }
        return -1;
    }
}