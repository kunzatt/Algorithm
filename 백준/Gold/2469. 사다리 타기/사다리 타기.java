import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        
        char[] start = new char[k];
        for (int i = 0; i < k; i++) {
            start[i] = (char)('A' + i);
        }
        
        char[] end = br.readLine().toCharArray();
        char[][] ladder = new char[n][];
        int blank = -1;
        
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            if (line.charAt(0) == '?') {
                blank = i;
                ladder[i] = new char[k-1];
            } else {
                ladder[i] = line.toCharArray();
            }
        }
        
        char[] top = start.clone();
        for (int i = 0; i < blank; i++) {
            for (int j = 0; j < k-1; j++) {
                if (ladder[i][j] == '-') {
                    char temp = top[j];
                    top[j] = top[j+1];
                    top[j+1] = temp;
                }
            }
        }
        
        char[] bottom = end.clone();
        for (int i = n-1; i > blank; i--) {
            for (int j = 0; j < k-1; j++) {
                if (ladder[i][j] == '-') {
                    char temp = bottom[j];
                    bottom[j] = bottom[j+1];
                    bottom[j+1] = temp;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k-1; i++) {
            if (top[i] == bottom[i]) {
                sb.append('*');
            } else if (top[i] == bottom[i+1] && top[i+1] == bottom[i]) {
                sb.append('-');
                char temp = top[i];
                top[i] = top[i+1];
                top[i+1] = temp;
            } else {
                sb.setLength(0);
                for (int j = 0; j < k-1; j++) {
                    sb.append('x');
                }
                break;
            }
        }
        
        System.out.println(sb);
    }
}