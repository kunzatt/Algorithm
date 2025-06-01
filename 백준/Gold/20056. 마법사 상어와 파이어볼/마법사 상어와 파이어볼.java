import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static ArrayList<Integer>[][] map;
    static ArrayList<Fireball> balls = new ArrayList<>();

    private static class Fireball {
        int r, c, m, s, d;

        Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int mass = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            balls.add(new Fireball(r, c, mass, speed, dir));
        }

        for (int i = 0; i < k; i++) {
            move();
            divide();
        }

        int ans = 0;
        for (Fireball b : balls) {
            ans += b.m;
        }
        System.out.println(ans);
    }

    private static void move() {
        for (Fireball b : balls) {
            int nr = (b.r + dr[b.d] * b.s % n + n) % n;
            int nc = (b.c + dc[b.d] * b.s % n + n) % n;
            b.r = nr;
            b.c = nc;
        }
    }

    private static void divide() {
        map = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < balls.size(); i++) {
            Fireball b = balls.get(i);
            map[b.r][b.c].add(i);
        }

        ArrayList<Fireball> newBalls = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].size() == 1) {
                    newBalls.add(balls.get(map[i][j].get(0)));
                } else if (map[i][j].size() >= 2) {
                    int totalM = 0, totalS = 0;
                    boolean allEven = true, allOdd = true;

                    for (int idx : map[i][j]) {
                        Fireball b = balls.get(idx);
                        totalM += b.m;
                        totalS += b.s;
                        if (b.d % 2 == 0) allOdd = false;
                        else allEven = false;
                    }

                    int newM = totalM / 5;
                    int newS = totalS / map[i][j].size();

                    if (newM > 0) {
                        int[] dirs = (allEven || allOdd) ? new int[]{0, 2, 4, 6} : new int[]{1, 3, 5, 7};
                        for (int d : dirs) {
                            newBalls.add(new Fireball(i, j, newM, newS, d));
                        }
                    }
                }
            }
        }

        balls = newBalls;
    }
}