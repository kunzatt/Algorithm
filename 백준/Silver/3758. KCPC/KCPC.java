import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < c; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            
            int[][] score = new int[n][k];
            int[] submit = new int[n];
            int[] time = new int[n];
            
            for (int j = 0; j < l; j++) {
                st = new StringTokenizer(br.readLine());
                int[] ex = new int[3];
                ex[0] = Integer.parseInt(st.nextToken());
                ex[1] = Integer.parseInt(st.nextToken());
                ex[2] = Integer.parseInt(st.nextToken());
                
                score[ex[0] - 1][ex[1] - 1] = Math.max(score[ex[0] - 1][ex[1] - 1], ex[2]);
                submit[ex[0] - 1]++;
                time[ex[0] - 1] = j;
            }
            
            int[][] line = new int[n][4];
            for (int h = 0; h < n; h++) {
                int sum = 0;
                for (int s : score[h]) {
                    sum += s;
                }
                line[h][0] = sum;
                line[h][1] = submit[h];
                line[h][2] = time[h];
                line[h][3] = h;
            }
            
            Arrays.sort(line, (a, b) -> {
                if (a[0] != b[0]) return b[0] - a[0];
                if (a[1] != b[1]) return a[1] - b[1];
                return a[2] - b[2];
            });
            
            for (int rank = 0; rank < n; rank++) {
                if (line[rank][3] == t - 1) {
                    System.out.println(rank + 1);
                    break;
                }
            }
        }
    }
}