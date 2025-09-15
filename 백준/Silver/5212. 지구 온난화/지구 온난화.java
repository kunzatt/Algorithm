import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] arr = new char[r][c];
        for (int i = 0; i < r; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                arr[i][j] = input[j].charAt(0);
            }
        }

        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};

        char[][] find = new char[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int count = 0;
                if(arr[i][j] == 'X'){
                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if(ny < 0 || ny >= r || nx < 0 || nx >= c){
                            count++;
                        }else{
                            if(arr[ny][nx] == '.'){
                                count++;
                            }
                        }
                    }
                    if(count >= 3){
                        find[i][j] = '.';
                    }else{
                        find[i][j] = 'X';
                    }
                }else{
                    find[i][j] = '.';
                }
            }
        }

        int left = c;
        int right = -1;
        int top = r;
        int bottom = -1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(find[i][j]== 'X'){
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                    top = Math.min(top, i);
                    bottom = Math.max(bottom, i);
                }
            }
        }

        for (int i = top; i <= bottom; i++) {
            for (int j = left; j <= right; j++) {
                bw.write(find[i][j]);
            }
            bw.write("\n");
        }


        br.close();
        bw.close();
    }
}