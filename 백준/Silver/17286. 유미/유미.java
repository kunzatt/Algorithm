import java.util.Scanner;

public class Main {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Point[] points = new Point[4];
    static double[][] dist = new double[4][4];
    static boolean[] visit = new boolean[4];

    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<4; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            points[i] = new Point(x, y);
        }

        for(int i=0; i<4; i++) {
            for(int j=i+1; j<4; j++) {
                dist[i][j] = dist[j][i] = getDistance(points[i], points[j]);
            }
        }

        dfs(0, 0, 0);

        System.out.println(ans);
        sc.close();
    }

    public static double getDistance(Point a, Point b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    public static void dfs(int idx, double sum, int cnt) {
        if(cnt == 4) {
            ans = Math.min(ans, (int)sum);
            return;
        }

        if(visit[idx]) return;

        visit[idx] = true;

        for(int i=0; i<4; i++) {
            dfs(i, sum + dist[idx][i], cnt+1);
        }

        visit[idx] = false;
    }
}