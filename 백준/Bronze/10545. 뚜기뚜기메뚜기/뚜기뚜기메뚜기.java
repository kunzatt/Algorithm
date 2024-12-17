import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[10];

        for (int i = 1; i <= 9; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        char[] ch = br.readLine().toCharArray();

        int temp = 0;
        for (int i = 0; i < ch.length; i++) {
            switch (ch[i]) {
                case 'a':
                case 'b':
                case 'c':
                    if (temp == 2) {
                        sb.append("#");
                    }
                    for (int j = 0; j <= Math.abs(ch[i] - 'a'); j++) {
                        sb.append(find(arr, 2));
                    }
                    temp = 2;
                    break;
                case 'd':
                case 'e':
                case 'f':
                    if (temp == 3) {
                        sb.append("#");
                    }
                    for (int j = 0; j <= Math.abs(ch[i] - 'd'); j++) {
                        sb.append(find(arr, 3));
                    }
                    temp = 3;
                    break;
                case 'g':
                case 'h':
                case 'i':
                    if (temp == 4) {
                        sb.append("#");
                    }
                    for (int j = 0; j <= Math.abs(ch[i] - 'g'); j++) {
                        sb.append(find(arr, 4));
                    }
                    temp = 4;
                    break;
                case 'j':
                case 'k':
                case 'l':
                    if (temp == 5) {
                        sb.append("#");
                    }
                    for (int j = 0; j <= Math.abs(ch[i] - 'j'); j++) {
                        sb.append(find(arr, 5));
                    }
                    temp = 5;
                    break;
                case 'm':
                case 'n':
                case 'o':
                    if (temp == 6) {
                        sb.append("#");
                    }
                    for (int j = 0; j <= Math.abs(ch[i] - 'm'); j++) {
                        sb.append(find(arr, 6));
                    }
                    temp = 6;
                    break;
                case 'p':
                case 'q':
                case 'r':
                case 's':
                    if (temp == 7) {
                        sb.append("#");
                    }
                    for (int j = 0; j <= Math.abs(ch[i] - 'p'); j++) {
                        sb.append(find(arr, 7));
                    }
                    temp = 7;
                    break;
                case 't':
                case 'u':
                case 'v':
                    if (temp == 8) {
                        sb.append("#");
                    }
                    for (int j = 0; j <= Math.abs(ch[i] - 't'); j++) {
                        sb.append(find(arr, 8));
                    }
                    temp = 8;
                    break;
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    if (temp == 9) {
                        sb.append("#");
                    }
                    for (int j = 0; j <= Math.abs(ch[i] - 'w'); j++) {
                        sb.append(find(arr, 9));
                    }
                    temp = 9;
                    break;
            }
        }
        System.out.println(sb);
    }

    private static int find(int[] arr, int value) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}