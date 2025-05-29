import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int y1 = sc.nextInt();
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int y2 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        
        if (y2 - y1 > 1000 || (y2 - y1 == 1000 && (m2 > m1 || (m2 == m1 && d2 >= d1)))) {
            System.out.println("gg");
            return;
        }
        
        int days = 0;
        
        while (y1 != y2 || m1 != m2 || d1 != d2) {
            d1++;
            days++;
            
            int[] dm = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            
            if (isLeap(y1)) {
                dm[2] = 29;
            }
            
            if (d1 > dm[m1]) {
                d1 = 1;
                m1++;
                if (m1 > 12) {
                    m1 = 1;
                    y1++;
                }
            }
        }
        
        System.out.println("D-" + days);
    }
    
    static boolean isLeap(int y) {
        return (y % 4 == 0 && y % 100 != 0) || y % 400 == 0;
    }
}