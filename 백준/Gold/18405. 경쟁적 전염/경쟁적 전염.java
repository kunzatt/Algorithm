import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] a = new int[n][n];
        List<int[]> v = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                if (a[i][j] != 0) {
                    v.add(new int[]{a[i][j], i, j});
                }
            }
        }

        v.sort((x, y) -> x[0] - y[0]);

        Queue<int[]> q = new LinkedList<>();
        for (int[] virus : v) {
            q.offer(new int[]{virus[1], virus[2], virus[0]});
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;

        int t = 0;
        while (!q.isEmpty() && t < s) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && a[nx][ny] == 0) {
                        a[nx][ny] = cur[2];
                        q.offer(new int[]{nx, ny, cur[2]});
                    }
                }
            }
            t++;
        }

        System.out.println(a[x][y]);
    }
}