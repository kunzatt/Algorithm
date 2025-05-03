import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] arr;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Map<Integer, Set<Integer>> map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        map = new HashMap<>();

        int[] students = new int[N * N];
        for (int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
            students[i] = temp;

            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < 4; j++) {
                set.add(Integer.parseInt(st.nextToken()));
            }
            map.put(temp, set);
        }

        for (int i = 0; i < N * N; i++) {
            placeStudent(students[i]);
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];

                    if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;

                    if (map.get(arr[i][j]).contains(arr[nr][nc])) {
                        cnt++;
                    }
                }

                if (cnt > 0) {
                    res += (int)Math.pow(10, cnt - 1);
                }
            }
        }

        System.out.println(res);
    }

    private static void placeStudent(int s) {
        int maxLike = -1;
        int maxEmpty = -1;
        int r = -1;
        int c = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] != 0) continue;

                int likeCnt = 0;
                int emptyCnt = 0;

                for (int k = 0; k < 4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];

                    if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;

                    if (arr[nr][nc] == 0) {
                        emptyCnt++;
                    } else if (map.get(s).contains(arr[nr][nc])) {
                        likeCnt++;
                    }
                }

                if (likeCnt > maxLike || (likeCnt == maxLike && emptyCnt > maxEmpty) ||
                        (likeCnt == maxLike && emptyCnt == maxEmpty
                                && (r == -1 || i < r || (i == r && j < c)))) {
                    maxLike = likeCnt;
                    maxEmpty = emptyCnt;
                    r = i;
                    c = j;
                }
            }
        }

        arr[r][c] = s;
    }
}