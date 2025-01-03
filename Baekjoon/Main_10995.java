import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10995 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] map = new String[N][2 * N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N; j++) {
                if (i % 2 == 1 && j % 2 == 1) {
                    map[i][j] = "*";
                }
                if (i % 2 == 1 && (j % 2 == 0 || j == 0)) {
                    map[i][j] = " ";
                }
                if ((i % 2 == 0 || i == 0) && j % 2 == 1) {
                    map[i][j] = " ";
                }
                if ((i % 2 == 0 || i == 0) && (j % 2 == 0 || j == 0)) {
                    map[i][j] = "*";
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }

}
