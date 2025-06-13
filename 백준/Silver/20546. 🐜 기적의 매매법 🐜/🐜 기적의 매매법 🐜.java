import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[14];
        for (int i = 0; i < 14; i++) {
            p[i] = sc.nextInt();
        }
        
        int jm = n, js = 0;
        int sm = n, ss = 0;
        
        for (int i = 0; i < 14; i++) {
            js += jm / p[i];
            jm %= p[i];
            
            if (i >= 3) {
                boolean up = true, down = true;
                for (int j = 1; j <= 3; j++) {
                    if (p[i-j+1] <= p[i-j]) up = false;
                    if (p[i-j+1] >= p[i-j]) down = false;
                }
                if (up) {
                    sm += ss * p[i];
                    ss = 0;
                }
                if (down) {
                    ss += sm / p[i];
                    sm %= p[i];
                }
            }
        }
        
        int jt = jm + js * p[13];
        int st = sm + ss * p[13];
        
        if (jt > st) System.out.println("BNP");
        else if (jt < st) System.out.println("TIMING");
        else System.out.println("SAMESAME");
    }
}