import java.util.*;
import java.io.*;

class Main {

    static int N, count, sum;
    static int[][] dices;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dices = new int[N][6];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dices[i][0] = Integer.parseInt(st.nextToken());
            dices[i][1] = Integer.parseInt(st.nextToken());
            dices[i][2] = Integer.parseInt(st.nextToken());
            dices[i][4] = Integer.parseInt(st.nextToken());
            dices[i][5] = Integer.parseInt(st.nextToken());
            dices[i][3] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 6; i++) {
            int temp = dices[0][(i + 3) % 6];
            count = 0;
            sum = 0;
            check(dices[0][i], temp);
            for (int j = 1; j < N; j++) {                
                for (int k = 0; k < 6; k++) {
                    int num = 0;
                    if(dices[j][k] == temp) {
                        num = dices[j][(k + 3) % 6];
                        check(temp, num);
                        temp = dices[j][(k + 3) % 6];
                        break;
                    }
                }
            }        
            sum += (N - count) * 6;
            max = Math.max(max, sum);
        }

        System.out.println(max);
        
    }

    static void check(int num1, int num2) {
        if (num1 == 6) {
            count++;
            if (num2 == 5) {
                sum += 4;
            } else {
                sum += 5;
            }
        } else if (num2 == 6) {
            count++;
            if (num1 == 5) {
                sum += 4;
            } else {
                sum += 5;
            }
        }      
        
    }
}