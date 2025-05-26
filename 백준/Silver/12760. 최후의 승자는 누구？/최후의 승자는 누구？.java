import java.util.*;
import java.io.*;

class Main {
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       int N = Integer.parseInt(st.nextToken());
       int M = Integer.parseInt(st.nextToken());
       
       int[][] map = new int[N][M];
       
       for (int i = 0; i < N; i++) {
           st = new StringTokenizer(br.readLine());
           for (int j = 0; j < M; j++) {
               map[i][j] = Integer.parseInt(st.nextToken());
           }
           Arrays.sort(map[i]);
           for (int j = 0; j < M / 2; j++) {
               int temp = map[i][j];
               map[i][j] = map[i][M - 1 - j];
               map[i][M - 1 - j] = temp;
           }
       }
       
       int[] res = new int[N];
       
       for (int i = 0; i < M; i++) {
           int max = 0;
           for (int j = 0; j < N; j++) {
               max = Math.max(max, map[j][i]);
           }
           
           for (int j = 0; j < N; j++) {
               if (map[j][i] == max) {
                   res[j]++;
               }
           }
       }
       
       int max = 0;
       for (int i = 0; i < N; i++) {
           max = Math.max(max, res[i]);
       }
       
       StringBuilder sb = new StringBuilder();
       for (int i = 0; i < N; i++) {
           if (res[i] == max) {
               if (sb.length() > 0) {
                   sb.append(" ");
               }
               sb.append(i + 1);
           }
       }
       
       System.out.println(sb.toString());
   }
}